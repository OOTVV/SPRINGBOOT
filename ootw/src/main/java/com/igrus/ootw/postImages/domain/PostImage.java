package com.igrus.ootw.postImages.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import com.igrus.ootw.post.domain.Post;

@Entity
@Table(name = "post_images")
@Getter
@Setter
@Builder
@NoArgsConstructor
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

