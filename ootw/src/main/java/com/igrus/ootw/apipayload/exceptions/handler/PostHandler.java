package com.igrus.ootw.apipayload.exceptions.handler;

import com.igrus.ootw.apipayload.code.BaseErrorCode;
import com.igrus.ootw.apipayload.exceptions.GeneralException;

public class PostHandler extends GeneralException {
	public PostHandler(BaseErrorCode code) {
		super(code);
	}
}
