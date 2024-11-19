package com.igrus.ootw.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igrus.ootw.post.domain.Post;

public interface PostRepository extends JpaRepository<Post,Long> {
}
