package com.igrus.ootw.comment.service;


import com.igrus.ootw.comment.domain.Comment;
import com.igrus.ootw.comment.domain.dto.CommentRequestDto;
import com.igrus.ootw.comment.repository.CommentRepository;
import com.igrus.ootw.post.domain.Post;
import com.igrus.ootw.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

 // private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Transactional
    public Long saveComment(String username, Long postId, CommentRequestDto dto) {
        // 게시글 조회
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new IllegalArgumentException("댓글 저장 실패: 해당 게시글이 존재하지 않습니다. ID: " + postId));

        // 부모 댓글 조회 (없으면 null)
        Comment parentComment = null;
        if (dto.getParent() != null) {
            parentComment = commentRepository.findById(dto.getParent().getId()).orElseThrow(() ->
                    new IllegalArgumentException("대댓글 저장 실패: 부모 댓글이 존재하지 않습니다. ID: " + dto.getParent().getId()));
        }

        // 댓글 또는 대댓글 생성
        Comment comment = Comment.builder()
                .content(dto.getComment())
                .parentComment(parentComment) // 부모 댓글 설정 (없으면 null)
                .post(post)
                .user(dto.getUser())
                .childComments(null) // 자식 댓글은 저장 시 비워둠
                .build();

        // 댓글 저장
        commentRepository.save(comment);
        // 부모 댓글이 있으면 자식 댓글 추가
        if (parentComment != null) {
            parentComment.getChildComments().add(comment);

        }

        // 저장된 댓글의 ID 반환
        return comment.getId();
    }


}
