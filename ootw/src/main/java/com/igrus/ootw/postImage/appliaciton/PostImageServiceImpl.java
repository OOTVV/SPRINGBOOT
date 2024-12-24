package com.igrus.ootw.postImage.appliaciton;

import static com.igrus.ootw.postImage.converter.PostImageConverter.*;
import static com.igrus.ootw.postImage.domain.dto.PostImageRequestDTO.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;

import com.igrus.ootw.apipayload.code.status.ErrorStatus;
import com.igrus.ootw.apipayload.exceptions.handler.PostImageHandler;
import com.igrus.ootw.postImage.domain.PostImage;
import com.igrus.ootw.postImage.domain.dto.PostImageRequestDTO;
import com.igrus.ootw.postImage.repository.PostImageRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Slf4j
@RequiredArgsConstructor
@Service
public class PostImageServiceImpl implements PostImageService {

	@Value("${aws.s3.bucket.name}")
	private String bucketName;

	private final S3Client s3Client;
	// 업로드, postImage만드는거
	private final PostImageRepository postImageRepository;
	@Override
	public List<PostImage> uploadImages(PostImagesCreateRequestDTO postImagesCreateRequestDTO) {

		List<String> uploadedUrls = new ArrayList<>();

		for (MultipartFile file : postImagesCreateRequestDTO.getMultipartFiles()) {
			uploadedUrls.add(uploadFile(file));
		}
		return savePostImages(PostImagesOf(postImagesCreateRequestDTO.getPost(), uploadedUrls));
	}
	@Override
	public List<PostImage> savePostImages(List<PostImage> postImages) {
		return postImages.stream()
			.map(postImageRepository::save)
			.collect(Collectors.toList());
	}
	private String uploadFile(MultipartFile file) {
		try {
			String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

			// 임시 파일 생성
			Path tempFile = Files.createTempFile("s3-upload-", fileName);
			Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

			// S3에 파일 업로드
			PutObjectRequest request = PutObjectRequest.builder()
				.bucket(bucketName)
				.key(fileName)
				.build();

			s3Client.putObject(request, tempFile);


			// 임시 파일 삭제
			Files.delete(tempFile);

			return fileName;
		} catch (Exception e) {
			throw new PostImageHandler(ErrorStatus.POST_IMAGE_NOT_FOUND);
		}
	}
}
