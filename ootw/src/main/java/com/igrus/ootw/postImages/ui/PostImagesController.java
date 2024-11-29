package com.igrus.ootw.postImages.ui;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.igrus.ootw.apipayload.ApiResponse;
import com.igrus.ootw.postImages.domain.PostImage;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post-image")
public class PostImagesController {


	@PostMapping
	public ApiResponse<PostImage> uploadImage(
		@RequestParam("postId") Long postId,
		@RequestParam("file") MultipartFile file,
		@RequestParam(value = "isMain", required = false, defaultValue = "false") boolean isMain) {
		PostImage postImage = null;//postImageService.uploadImage(postId, file, isMain);
		return ApiResponse.onSuccess(postImage);
	}
}
