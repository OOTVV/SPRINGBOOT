package com.igrus.ootw.postImage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igrus.ootw.postImage.domain.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}
