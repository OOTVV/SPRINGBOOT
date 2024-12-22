package com.igrus.ootw.comment.repository;

import com.igrus.ootw.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByPostIdAndId(Long postId, Long id);

}

