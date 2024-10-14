package com.citibank.main.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.citibank.main.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleEmployeeNotFoundException(
			EmployeeNotFoundException employeeNotFoundException, WebRequest webRequest) {

		ErrorResponseDto errorResponseDto = new ErrorResponseDto();

		errorResponseDto.setApiPath(webRequest.getDescription(false));
		errorResponseDto.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponseDto.setErrorMessage(employeeNotFoundException.getLocalizedMessage());
		errorResponseDto.setErrorTime(LocalDateTime.now());

		return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.BAD_REQUEST);
	}
}
