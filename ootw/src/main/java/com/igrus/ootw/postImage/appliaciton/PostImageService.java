package com.igrus.ootw.postImage.appliaciton;

import static com.igrus.ootw.postImage.domain.dto.PostImageRequestDTO.*;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.igrus.ootw.postImage.domain.PostImage;
import com.igrus.ootw.postImage.domain.dto.PostImageRequestDTO;

public interface PostImageService {
	public List<PostImage> uploadImages(PostImagesCreateRequestDTO postImagesCreateRequestDTO);

	public List<PostImage> savePostImages(List<PostImage> postImages);

}
