package com.igrus.ootw.postImage.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import com.igrus.ootw.post.domain.Post;

@Entity
@Getter
@Setter
@Builder
@Table(name = "post_image")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PostImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="iamge_url")
	private String imageUrl;

	@Column(name="is_main", columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean isMain;

	@Column(name="created_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

}

