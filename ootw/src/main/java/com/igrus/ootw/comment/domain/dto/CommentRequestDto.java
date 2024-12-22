package com.igrus.ootw.comment.domain.dto;


import com.igrus.ootw.comment.domain.Comment;
import com.igrus.ootw.post.domain.Post;


import com.igrus.ootw.user.domain.User;
import lombok.Builder;
import lombok.Getter;


import java.util.ArrayList;
import java.util.List;
@Getter
@Builder
public class CommentRequestDto {
     private String comment;       // 댓글 내용
     private Long parentId;        // 부모 댓글 ID
     private Long postId;          // 게시글 ID

     /* Dto -> Entity (기본적인 데이터만 매핑) */
     public Comment toEntity(User user, Post post, Comment parent) {
          return Comment.builder()
                  .content(comment)
                  .parentComment(parent) // 부모 댓글 엔티티
                  .post(post)           // 게시글 엔티티
                  .user(user)           // 유저 엔티티
                  .childComments(new ArrayList<>()) // 기본 초기화
                  .build();
     }
}

