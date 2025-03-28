package com.igrus.ootw.comment.domain.dto;

import com.igrus.ootw.comment.domain.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private long commentid;
    private String comment;
    private Long userid;
    private long parentIdx;
    private long orderNumber;
    private Long postsId;
    //Entity->DTO
     public CommentResponseDto(Comment comment)
     {
         this.commentid=comment.getId();
         this.comment=comment.getContent();
         this.postsId=comment.getPost().getId();
         this.parentIdx=comment.getParentComment().getId();
         this.orderNumber=comment.getChildComments().size();
         this.userid=comment.getUser().getId();

     }
}
