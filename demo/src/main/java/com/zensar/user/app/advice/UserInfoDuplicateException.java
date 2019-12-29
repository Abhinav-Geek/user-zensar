package com.zensar.user.app.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserInfoDuplicateException extends RuntimeException 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4992012908979974285L;

	public UserInfoDuplicateException(String exception) {
        super(exception);
    }
}
