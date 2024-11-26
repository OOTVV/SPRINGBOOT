package com.igrus.ootw.postImages.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_image")
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
	private Long postId;

	@Column(nullable = false)
	private String imageUrl;

	@Column(nullable = false)
	private Boolean isMain;
	@Column(nullable = false)
	private LocalDateTime createdAt;
}
