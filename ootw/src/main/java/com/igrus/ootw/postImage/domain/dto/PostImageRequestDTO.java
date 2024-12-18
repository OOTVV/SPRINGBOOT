package com.igrus.ootw.postImage.domain.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.igrus.ootw.post.domain.Post;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

public class PostImageRequestDTO {
	@Getter
	@Builder
	public static class PostImagesCreateRequestDTO {

		@NotNull(message = "Image is empty")
		private List<MultipartFile> multipartFiles;

		@NotNull(message = "Post is Emtpy")
		private Post post;
	}
}