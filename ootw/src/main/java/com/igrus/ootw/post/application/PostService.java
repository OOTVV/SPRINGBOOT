package com.igrus.ootw.post.application;

import com.igrus.ootw.apipayload.exceptions.validation.PostNotFoundException;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시물 생성 메서드
    public Post createPost(Post post) {
        // 데이터베이스에 게시물 저장 후, 저장된 게시물을 반환
        return postRepository.save(post);
    }

    // 여러 개의 게시물 생성 매서드
    public List<Post> createPosts(List<Post> posts) {
        return postRepository.saveAll(posts);
    }

    // 게시물 조회 메서드
    public Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with ID " + id + " not found"));
    }

    // 게시물 목록 조회 메서드 (페이지네이션)
    public Page<Post> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);  // PageRequest로 Pageable 객체 생성
        return postRepository.findAll(pageable);  // 페이지네이션 적용하여 게시물 목록 반환
    }

    // 게시글 수정 메서드
    public Post updatePost(Long id, Post postDetails) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with ID " + id + " not found"));

        post.setContent(postDetails.getContent());
        post.setLikes(postDetails.getLikes());
        post.setViews(postDetails.getViews());

        return postRepository.save(post);
    }

    // 게시글 삭제 메서드
    public void deletePost(Long id) {
        if(!postRepository.existsById(id)) {
            throw new PostNotFoundException("Post with ID " + id + " not found");
        }
        postRepository.deleteById(id);
    }
}