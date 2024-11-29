package com.igrus.ootw.post.application;

import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    // 게시물 생성 메서드
    public Post createPost(Post post) {
        // 데이터베이스에 게시물 저장 후, 저장된 게시물을 반환
        return postRepository.save(post);
    }

    public Post getPost(Long id) {
        Optional<Post> byId = postRepository.findById(id);
        Post createdPost = byId.orElse(null);
        // 데이터베이스에 게시물 저장 후, 저장된 게시물을 반환
        return createdPost;
    }
}