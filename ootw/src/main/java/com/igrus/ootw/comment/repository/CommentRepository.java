package com.igrus.ootw.comment.repository;

import com.igrus.ootw.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}

