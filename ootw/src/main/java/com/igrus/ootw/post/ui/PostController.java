package com.igrus.ootw.post.ui;

import com.igrus.ootw.apipayload.ApiResponse;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.application.PostService;
import com.igrus.ootw.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    // 게시물 조회 api
    @GetMapping("/{id}")
    ApiResponse<Post> getPost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        return ApiResponse.onSuccess(post);
    }
}