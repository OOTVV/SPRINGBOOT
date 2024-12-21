package com.igrus.ootw.comment.domain.dto;


import com.igrus.ootw.comment.domain.Comment;
import com.igrus.ootw.post.domain.Post;


import com.igrus.ootw.user.domain.User;
import lombok.Builder;
import lombok.Getter;


import java.util.List;
@Getter
@Builder
public class CommentRequestDto {
     private long commentid;
     private String comment;
     private Comment parent;
     private List<Comment> children;
     private User user;
     private Post post;
     /* Dto -> Entity */
     public Comment toEntity() {
         Comment comments = Comment.builder()
                 .id(commentid)
                 .content(comment)
                 .parentComment(parent)
                 .childComments(children)
                 .user(user)
                 .post(post)
                 .build();
         return comments;
     }
}
