package com.igrus.ootw.user.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.igrus.ootw.comment.domain.Comment;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.user.domain.enums.Gender;

@Entity
@Getter
@Setter
@Builder
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 12)
	private String nickname;

	@Column(nullable = false, length = 20)
	private String password;

	@Column(nullable = false, length = 30)
	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Post> posts = new ArrayList<>();

}

