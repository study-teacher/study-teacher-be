package com.fridge.studyteacherbe.global.exception;

import com.fridge.studyteacherbe.global.enums.CommonExceptionCode;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.View;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

  private final View error;

  public GlobalExceptionHandler(View error) {
    this.error = error;
  }

  // Auth Exception (Security 적용 시)
//  @ExceptionHandler
//  public ResponseEntity<ErrorResponse> handleAuthorizationDeniedException(
//      AuthorizationDeniedException e) {
//
//    return ResponseEntity.status(SecurityExceptionCode.AUTHORIZATION_DENIED.getHttpStatus())
//        .body(ErrorResponse.of(SecurityExceptionCode.AUTHORIZATION_DENIED, e));
//  }

  // 존재하지 않는 요청에 대한 예외
  @ExceptionHandler(value = {NoHandlerFoundException.class,
      HttpRequestMethodNotSupportedException.class})
  public ResponseEntity<ErrorResponse> handleNoPageFoundException(Exception e) {
    log.error("GlobalExceptionHandler catch {}", e.getClass().getSimpleName());
    return ResponseEntity
        .status(CommonExceptionCode.INTERNAL_SERVER_ERROR.getHttpStatus())
        .body(ErrorResponse.of(CommonExceptionCode.INTERNAL_SERVER_ERROR, e,
            Map.of("reason", "No Handler or Unsupported method")));
  }

  // Validation Exception
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    BindingResult bindingResult = e.getBindingResult();

    List<String> errors = bindingResult.getFieldErrors().stream()
        .map(error ->
            String.format("[field=%s, rejected=%s, message=$s]",
                error.getField(), error.getRejectedValue(), error.getDefaultMessage()))
        .toList();

    log.error("Catch ValidationException: {}", errors);

    return ResponseEntity
        .status(CommonExceptionCode.INVALID_INPUT_VALUE.getHttpStatus())
        .body(ErrorResponse.of(CommonExceptionCode.INVALID_INPUT_VALUE, e,
            Map.of("validation", errors)));
  }

  // Custom Exception (Business Excetpion)
  @ExceptionHandler(CustomException.class)
  public ResponseEntity<ErrorResponse> handleBusinessException(CustomException e) {
    log.error("Catch BusinessException: {}", e.getClass().getSimpleName());
    return ResponseEntity
        .status(e.getExceptionCode().getHttpStatus())
        .body(ErrorResponse.of(e.getExceptionCode(), e));
  }

  // Global Exception (Unhandled Exception)
  @ExceptionHandler
  public ResponseEntity<ErrorResponse> handleException(Exception e) {
    log.error("Catch Exception: {}", e.getClass().getSimpleName());

    return ResponseEntity
        .status(CommonExceptionCode.INTERNAL_SERVER_ERROR.getHttpStatus())
        .body(ErrorResponse.of(CommonExceptionCode.INTERNAL_SERVER_ERROR, e));
  }

}
