package com.example.campusoverflow.vote;

import com.example.campusoverflow.answer.AnswerRepository;
import com.example.campusoverflow.exceptions.AlreadyExistsException;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.user.UserRepository;
import com.example.campusoverflow.vote.dto.VoteRequestNewDto;
import com.example.campusoverflow.vote.enums.VoteType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoteService {

    private final VoteRepository repository;
    private final AnswerRepository answerRepository;
    private final UserRepository userRepository;
    private final VoteMapper mapper;

    public Vote save(VoteRequestNewDto requestNewDto) {
        Optional<Vote> existedVote = repository.findByUserIdAndAnswerId(requestNewDto.getUserId(), requestNewDto.getAnswerId());
        Vote vote;
        if (existedVote.isPresent())
        {
            vote = existedVote.get();
            vote.setType(requestNewDto.getType());
        }else{
            vote = mapper.toVote(requestNewDto);
        }
        return repository.save(vote);
    }

    public Vote findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Iterable<Vote> findAllByAnswerId(Long answerId) {
        answerRepository.findById(answerId).orElseThrow(() -> new NotFoundException("Answer not found"));
        return repository.findAllByAnswerId(answerId);
    }

    public Iterable<Vote> findAllByUserId(Long userId) {
        userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
        return repository.findAllByUserId(userId);
    }

}
