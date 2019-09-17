package com.lion.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="数据转换失败")
public class MyException extends RuntimeException {
	public MyException() {
		
	}
}
