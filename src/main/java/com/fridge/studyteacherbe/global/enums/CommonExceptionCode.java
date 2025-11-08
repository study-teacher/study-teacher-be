package com.fridge.studyteacherbe.global.enums;

import com.fridge.studyteacherbe.global.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonExceptionCode implements ExceptionCode {
  // 서버 에러
  INTERNAL_SERVER_ERROR("COMM001", "서버 에러입니다. 관리자에게 연락해주세요.", HttpStatus.INTERNAL_SERVER_ERROR),

  // 요청 에러
  BAD_REQUEST("COMM002", "잘못된 요청입니다.", HttpStatus.BAD_REQUEST),
  INVALID_INPUT_VALUE("COMM003", "입력값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
  MISSING_REQUIRED_PARAMETER("COMM004", "필수 파라미터가 누락되었습니다.", HttpStatus.BAD_REQUEST),
  INVALID_TYPE_VALUE("COMM005", "입력 타입이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),

  // 인증/인가 에러
  UNAUTHORIZED("COMM006", "인증이 필요합니다.", HttpStatus.UNAUTHORIZED),
  FORBIDDEN("COMM007", "접근 권한이 없습니다.", HttpStatus.FORBIDDEN),
  INVALID_TOKEN("COMM008", "유효하지 않은 토큰입니다.", HttpStatus.UNAUTHORIZED),
  EXPIRED_TOKEN("COMM009", "만료된 토큰입니다.", HttpStatus.UNAUTHORIZED),

  // 리소스 에러
  NOT_FOUND("COMM010", "요청한 리소스를 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
  RESOURCE_CONFLICT("COMM011", "리소스 충돌이 발생했습니다.", HttpStatus.CONFLICT),

  // 메서드/미디어 타입 에러
  METHOD_NOT_ALLOWED("COMM012", "지원하지 않는 HTTP 메서드입니다.", HttpStatus.METHOD_NOT_ALLOWED),
  UNSUPPORTED_MEDIA_TYPE("COMM013", "지원하지 않는 미디어 타입입니다.", HttpStatus.UNSUPPORTED_MEDIA_TYPE),

  ;

  private final String code;
  private final String message;
  private final HttpStatus httpStatus;

}
