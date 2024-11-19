package com.igrus.ootw.apipayload.exceptions;

import com.igrus.ootw.apipayload.code.BaseErrorCode;
import com.igrus.ootw.apipayload.code.ErrorReasonDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

	private BaseErrorCode code;

	public ErrorReasonDTO getErrorReason() {
		return this.code.getReason();
	}

	public ErrorReasonDTO getErrorReasonHttpStatus() {
		return this.code.getReasonHttpStatus();
	}
}
