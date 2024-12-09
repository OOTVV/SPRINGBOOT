package com.igrus.ootw.post.ui;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.igrus.ootw.apipayload.ApiResponse;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.application.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    // 게시물 생성 API

    @PostMapping("/create") // localhost:8080/api/posts/create, postman에서 하나의 id 해당하는 내용 POST
    public ResponseEntity<Post> createPost(@RequestBody Post post) { // post 객체로 변환

        // 게시물 저장
        Post createdPost = postService.savePost(post);

        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // 여러개의 게시물 생성 Api
    @PostMapping("/create-multiple") // postman에서 여러 id에 해당하는 내용 POST
    public ResponseEntity<List<Post>> createPosts(@RequestBody List<Post> posts) {
        return new ResponseEntity<>(postService.savePosts(posts), HttpStatus.CREATED);
    }

    // 게시물 조회 api

    @GetMapping("/{id}") // localhost:8080/api/post/해당 id
    public ResponseEntity<ApiResponse<Post>> getPost(@PathVariable Long id) {
        Post post = postService.findPost(id);
        return ResponseEntity.ok(ApiResponse.onSuccess(post));
    }

    // 게시글 목록 조회(페이징) api

    @GetMapping("/list") // localhost:8080/api/post/list
    public ResponseEntity<Page<Post>> getPosts(
            @RequestParam(value = "page", defaultValue = "0") int page, // page 초기값 0, size 초기값 10
            @RequestParam(value = "size", defaultValue = "10") int size) {

        Page<Post> posts = postService.findPosts(page, size);

        return ResponseEntity.ok(posts);
    }

    // 게시글 수정 api

    @PutMapping("/{id}") // postman에서 수정할 id에 대한 내용 Put
    public ResponseEntity<ApiResponse<Post>> updatePost(
            @PathVariable Long id, // 게시글 ID
            @RequestBody @Valid Post postDetails) { // 수정할 게시글 정보

            Post updatedPost = postService.updatePost(id, postDetails);
            return ResponseEntity.ok(ApiResponse.onSuccess(updatedPost));
    }

    // 게시글 삭제 api

    @DeleteMapping("/{id}") // postman에서 삭제할 id에 대한 내용 Delete
    public ResponseEntity<ApiResponse<Void>> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.ok(ApiResponse.onSuccess(null));
    }

}
