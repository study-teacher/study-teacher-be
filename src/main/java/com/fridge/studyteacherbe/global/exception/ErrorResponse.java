package com.fridge.studyteacherbe.global.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;

/**
 * @param statusCode
 * @param code
 * @param message
 * @param exceptionName
 * @param details
 */
@JsonInclude(Include.NON_EMPTY)
public record ErrorResponse(
    int statusCode,
    String code,
    String message,
    String exceptionName,
    Map<String, Object> details
) {

  public static ErrorResponse of(ExceptionCode exceptionCode, Exception exception) {
    return new ErrorResponse(
        exceptionCode.getHttpStatus().value(),
        exceptionCode.getCode(),
        exceptionCode.getMessage(),
        exception.getClass().getSimpleName(),
        null);
  }

  public static ErrorResponse of(ExceptionCode exceptionCode, Exception exception,
      Map<String, Object> details) {
    return new ErrorResponse(
        exceptionCode.getHttpStatus().value(),
        exceptionCode.getCode(),
        exceptionCode.getMessage(),
        exception.getClass().getSimpleName(),
        details
    );
  }

}
