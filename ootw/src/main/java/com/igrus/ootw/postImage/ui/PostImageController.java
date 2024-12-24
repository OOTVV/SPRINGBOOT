package com.igrus.ootw.postImage.ui;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.igrus.ootw.apipayload.ApiResponse;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.repository.PostRepository;
import com.igrus.ootw.postImage.appliaciton.PostImageService;
import com.igrus.ootw.postImage.domain.PostImage;
import com.igrus.ootw.postImage.domain.dto.PostImageRequestDTO;
import com.igrus.ootw.postImage.domain.dto.PostImageRequestDTO.PostImagesCreateRequestDTO;
import com.igrus.ootw.user.domain.User;
import com.igrus.ootw.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post-images")
public class PostImageController {
	private final PostImageService postImageService;
	// TODO PostId에 따른 PostImage return

}
