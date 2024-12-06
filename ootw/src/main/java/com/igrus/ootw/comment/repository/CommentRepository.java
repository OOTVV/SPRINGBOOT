package com.igrus.ootw.comment.repository;

import com.igrus.ootw.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}

