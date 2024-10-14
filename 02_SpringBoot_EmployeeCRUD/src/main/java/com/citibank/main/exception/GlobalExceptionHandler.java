package com.citibank.main.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.citibank.main.dto.ErrorResponseDto;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		Map<String, String> validationErrors = new HashMap<String, String>();

		List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

		for (ObjectError objectError : validationErrorList) {

			FieldError fieldError = (FieldError) objectError;
			String fieldName = fieldError.getField();
			String fieldMessage = fieldError.getDefaultMessage();

			validationErrors.put(fieldName, fieldMessage);

		}

		return new ResponseEntity<Object>(validationErrors, HttpStatus.BAD_REQUEST);
	}

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
