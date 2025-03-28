package com.igrus.ootw.comment.service;


import com.igrus.ootw.comment.domain.Comment;
import com.igrus.ootw.comment.domain.dto.CommentRequestDto;
import com.igrus.ootw.comment.repository.CommentRepository;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.repository.PostRepository;
import com.igrus.ootw.user.domain.User;
import com.igrus.ootw.user.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    /*
    @Transactional
    public Long saveComment(String username, Long postId, CommentRequestDto dto) {
        // 유저 조회
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new IllegalArgumentException("댓글 저장 실패: 해당 유저가 존재하지 않습니다. Username: " + username));

        // 게시글 조회
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new IllegalArgumentException("댓글 저장 실패: 해당 게시글이 존재하지 않습니다. ID: " + postId));

        Comment parent = null;
        if (dto.getParentId() != null) {
            parent = commentRepository.findById(dto.getParentId()).orElseThrow(() ->
                    new IllegalArgumentException("대댓글 저장 실패: 부모 댓글이 존재하지 않습니다. ID: " + dto.getParentId()));
        }

        Comment comment = dto.toEntity(user, post, parent);

        // 댓글 저장
        commentRepository.save(comment);

        // 부모 댓글이 있으면 자식 댓글 추가
        if (parent != null) {
            parent.getChildComments().add(comment);
        }

        // 저장된 댓글의 ID 반환
        return comment.getId();
    }

     */
    /* UPDATE */
    @Transactional
    public void update(Long postsId, Long id, CommentRequestDto dto)
    {
        Comment comment = commentRepository.findByPostIdAndId(postsId, id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));
        comment.update(dto.getComment());
    }

    /* DELETE */
    @Transactional
    public void delete(Long postId, Long id) {
        Comment comment = commentRepository.findByPostIdAndId(postId, id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));
        commentRepository.delete(comment);
    }


}
