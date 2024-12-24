package com.igrus.ootw.apipayload.code.status;

import org.springframework.http.HttpStatus;

import com.igrus.ootw.apipayload.code.BaseErrorCode;
import com.igrus.ootw.apipayload.code.ErrorReasonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
	_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
	_BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
	_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
	_FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),
	TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

	//멤버
	MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND,"MEMBER400","존재하지 않는 회원입니다."),

	//정원
	GARDEN_NOT_FOUND(HttpStatus.NOT_FOUND, "GARDEN400", "정원을 찾을 수 없습니다"),
	GARDEN_NOT_EXIST(HttpStatus.NOT_FOUND, "GARDEN401", "정원이 하나도 존재하지않습니다."),
	// 게시글 사진
	POST_IMAGE_NOT_FOUND(HttpStatus.NOT_FOUND,"POSTIMAGE400","사진을 찾을수 없습니다."),
	;
	private final HttpStatus httpStatus;

	private final String code;

	private final String message;

	@Override
	public ErrorReasonDTO getReason() {
		return ErrorReasonDTO.builder()
			.message(message)
			.code(code)
			.isSuccess(false)
			.build();
	}

	@Override
	public ErrorReasonDTO getReasonHttpStatus() {
		return ErrorReasonDTO.builder()
			.message(message)
			.code(code)
			.isSuccess(false)
			.httpStatus(httpStatus)
			.build();
	}
}
