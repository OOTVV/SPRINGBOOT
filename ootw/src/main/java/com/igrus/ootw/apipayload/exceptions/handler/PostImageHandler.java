package com.igrus.ootw.apipayload.exceptions.handler;

import com.igrus.ootw.apipayload.code.BaseErrorCode;
import com.igrus.ootw.apipayload.exceptions.GeneralException;

public class PostImageHandler extends GeneralException {
	public PostImageHandler(BaseErrorCode code) {
		super(code);
	}
}
