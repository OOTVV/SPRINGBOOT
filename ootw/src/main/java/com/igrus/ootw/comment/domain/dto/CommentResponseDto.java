package com.igrus.ootw.comment.DTO;

import com.igrus.ootw.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private long commentid;
    private String comment;
    private String userid;
    private long parentIdx;
    private long orderNumber;
    private Long postsId;
    //Entity->DTO
    public CommentResponseDto(Comment comment)
    {
        this.commentid=comment.getCommentid();
        this.comment=comment.getCommentContent();
        this.postsId=comment.getPost().getId();
        this.parentIdx=comment.getParentIdx();
        this.orderNumber=comment.getOrderNumber();
        //this.userid=comment.getUser().getId();

    }
}
