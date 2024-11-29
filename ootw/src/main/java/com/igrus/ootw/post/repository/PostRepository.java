package com.igrus.ootw.post.repository;

import com.igrus.ootw.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    // JpaRepository에서 제공하는 기본적인 CRUD 메서드를 사용
}