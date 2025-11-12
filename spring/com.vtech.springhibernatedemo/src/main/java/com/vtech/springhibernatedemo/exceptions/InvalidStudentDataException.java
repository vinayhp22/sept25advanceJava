package com.vtech.springhibernatedemo.exceptions;

public class InvalidStudentDataException extends RuntimeException {

	public InvalidStudentDataException(String message) {
		super(message);
	}
}
