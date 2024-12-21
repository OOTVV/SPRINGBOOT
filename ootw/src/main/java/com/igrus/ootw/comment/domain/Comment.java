package com.igrus.ootw.comment.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.user.domain.User;

@Entity
@Getter
@Setter
@Builder
@Table(name="comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key 자동 생성
    private Long id;  // 내 댓글 키

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;  // 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_comment_id")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> childComments = new ArrayList<>();
}
