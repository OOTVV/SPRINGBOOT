package com.igrus.ootw.postImages.domain;

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

	@Column(nullable = false)
	private String imageUrl;

	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean isMain;

	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;

}

