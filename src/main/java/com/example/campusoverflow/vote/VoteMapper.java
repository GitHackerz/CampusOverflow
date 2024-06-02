package com.example.campusoverflow.vote;

import com.example.campusoverflow.answer.Answer;
import com.example.campusoverflow.answer.AnswerRepository;
import com.example.campusoverflow.exceptions.NotFoundException;
import com.example.campusoverflow.user.User;
import com.example.campusoverflow.user.UserRepository;
import com.example.campusoverflow.vote.dto.VoteRequestNewDto;
import com.example.campusoverflow.vote.dto.VoteRequestUpdateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VoteMapper {

    private final UserRepository userRepository;
    private final AnswerRepository answerRepository;

    public Vote toVote(VoteRequestNewDto requestNewDto) {
        User user = userRepository.findById(requestNewDto.getUserId()).orElseThrow(()-> new NotFoundException("User not found"));
        Answer answer = answerRepository.findById(requestNewDto.getAnswerId()).orElseThrow(()-> new NotFoundException("Answer not found"));
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setAnswer(answer);
        vote.setType(requestNewDto.getType());
        return vote;
    }
}
