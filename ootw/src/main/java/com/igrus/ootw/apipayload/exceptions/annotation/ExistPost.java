/*
package com.igrus.ootw.apipayload.exceptions.annotation;

import com.igrus.ootw.apipayload.exceptions.validation.PostExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PostExistValidator.class)  // PostExistValidator로 유효성 검증
@Target({ElementType.FIELD, ElementType.PARAMETER}) // 필드나 파라미터에 적용
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistPost {

    String message() default "Invalid Post ID";  // 기본 메시지

    Class<?>[] groups() default {};  // 검증 그룹

    Class<? extends Payload>[] payload() default {};  // 페이로드
}

 */