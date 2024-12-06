package com.igrus.ootw.comment.entity;

import jakarta.persistence.*;
import lombok.*;

import com.igrus.ootw.post.domain.Post;
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

@Entity
@Table(name = "comments") // 테이블 이름 comments
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary Key 자동 생성
    private Long commentid;  // 내 댓글 키

    @Column
    private long parentIdx; // 부모 댓글의 commentIdx

    @Column
    private long orderNumber;//댓글 묶음(부모+자식)의 순서

    @Column(columnDefinition = "TEXT",nullable = false)
    private String commentContent;  // 내용

    @ManyToOne
    @JoinColumn(name = "posts_id")
    private Post post;
    // 왜래키 (Post 클래스)
/*
    @ManyToOne
    @JoinColumn(name = "ID")
    private USER user; // 왜래키 (User 클래스 id) 작성자 ID
//대댓글은 일단 미루고 댓글 기능부터
    */


}
