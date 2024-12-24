package com.igrus.ootw.postImage.converter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.postImage.domain.PostImage;

public class PostImageConverter {
	public static List<PostImage> PostImagesOf(Post post, List<String> fileNames) {
		return IntStream.range(0, fileNames.size())
			.mapToObj(i -> PostImage.builder()
				.imageUrl(fileNames.get(i))
				.isMain(i == 0) // Set isMain to true for the first image
				.createdAt(LocalDateTime.now())
				.post(post)
				.build())
			.collect(Collectors.toList());
	}
}
