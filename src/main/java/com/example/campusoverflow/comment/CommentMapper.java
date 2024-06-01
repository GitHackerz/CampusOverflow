package com.example.campusoverflow.comment;

import com.example.campusoverflow.comment.dto.CommentRequestNewDto;
import com.example.campusoverflow.comment.dto.CommentRequestUpdateDto;
import com.example.campusoverflow.question.Question;
import com.example.campusoverflow.user.User;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {

    public Comment toComment(CommentRequestNewDto commentRequestDto) {
        return Comment.builder()
                .content(commentRequestDto.getContent())
                .user(User.builder().id(commentRequestDto.getUserId()).build())
                .question(Question.builder().id(commentRequestDto.getQuestionId()).build())
                .build();
    }

    public Comment toComment(CommentRequestUpdateDto commentRequestDto) {
        return Comment.builder()
                .id(commentRequestDto.getId())
                .content(commentRequestDto.getContent())
                .user(User.builder().id(commentRequestDto.getUserId()).build())
                .question(Question.builder().id(commentRequestDto.getQuestionId()).build())
                .build();
    }
}
