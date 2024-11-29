package com.igrus.ootw.post.ui;

import com.igrus.ootw.apipayload.ApiResponse;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.application.PostService;
import com.igrus.ootw.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    // 게시물 생성 API
    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) { // post 객체로 변환

        // 게시물 저장
        Post createdPost = postService.createPost(post);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // 게시물 조회 api
    @GetMapping("/{id}")
    ApiResponse<Post> getPost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        return ApiResponse.onSuccess(post);
    }

    // 게시글 목록 조회 api
}