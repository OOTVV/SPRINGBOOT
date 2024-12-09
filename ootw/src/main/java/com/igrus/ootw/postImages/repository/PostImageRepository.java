package com.igrus.ootw.postImages.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igrus.ootw.postImages.domain.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}
