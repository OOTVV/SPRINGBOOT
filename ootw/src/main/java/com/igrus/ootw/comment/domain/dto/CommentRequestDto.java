package com.igrus.ootw.comment.DTO;


import com.igrus.ootw.comment.entity.Comment;
import com.igrus.ootw.post.domain.Post;


import lombok.Builder;

@Builder
public class CommentRequestDto {
    private long commentid;
    private String comment;
    private long parentIdx;
    private long orderNumber;
    //private USER user;
    private Post post;
    /* Dto -> Entity */
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .commentid(commentid)
                .commentContent(comment)
                .orderNumber(orderNumber)
                .parentIdx(parentIdx)
                //.user(user)
                .post(post)
                .build();
        return comments;
    }
}
