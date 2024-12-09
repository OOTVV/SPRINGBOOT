/*
package com.igrus.ootw.apipayload.exceptions.validation;

import com.igrus.ootw.apipayload.exceptions.validation.PostNotFoundException;
import com.igrus.ootw.apipayload.exceptions.annotation.ExistPost;
import com.igrus.ootw.post.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostExistValidator implements ConstraintValidator<ExistPost, Long> {

    private final PostRepository postRepository;

    @Override
    public void initialize(ExistPost constraintAnnotation) {
        // 초기화 로직이 필요하면 여기에 추가
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        // 데이터베이스에서 해당 게시물이 존재하는지 확인
        boolean exists = postRepository.existsById(value);

        if (!exists) {
            // 게시물이 없으면 에러 메시지 설정
            throw new PostNotFoundException("Post with id " + value + " does not exist");
        }

        return exists;  // 존재하면 true, 없으면 false
    }
}
*/