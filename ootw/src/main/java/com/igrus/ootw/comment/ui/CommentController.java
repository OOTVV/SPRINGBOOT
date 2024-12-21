package com.igrus.ootw.comment.ui;

import com.igrus.ootw.comment.domain.dto.CommentRequestDto;
import com.igrus.ootw.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController


public class CommentController {
    private final CommentService commentService;
    @PostMapping("/posts/{id}/comments")
    public ResponseEntity commentSave(@PathVariable Long id, @RequestBody CommentRequestDto dto, @LoginUser UserSessionDto userSessionDto) {
        return ResponseEntity.ok(commentService.commentSave(userSessionDto.getNickname(), id, dto));

    }
}
*/