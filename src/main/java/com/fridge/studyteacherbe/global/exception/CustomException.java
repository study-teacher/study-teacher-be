package com.fridge.studyteacherbe.global.exception;

import java.util.Map;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

  private final ExceptionCode exceptionCode;
  private final Map<String, Object> details;

  /**
   * 기본 예외 생성자 단순히 예외 코드만으로 예외를 발생시킬 때 사용
   */
  public CustomException(ExceptionCode exceptionCode) {
    super(exceptionCode.getMessage());
    this.exceptionCode = exceptionCode;
    this.details = Map.of();
  }

  /**
   * 상세 정보를 포함하는 예외 생성자 에러 발생 시 추가적인 컨텍스트 정보를 함께 전달할 때 사용
   * <p>
   * - 유효성 검증 실패 시 어떤 필드에서 문제가 발생했는지 전달
   */

  public CustomException(ExceptionCode exceptionCode, Map<String, Object> details) {
    super(exceptionCode.getMessage());
    this.exceptionCode = exceptionCode;
    this.details = details != null ? details : Map.of();
  }

  /**
   * 원본 예외를 포함하는 생성자 하위 레이어에서 발생한 예외를 래핑하여 던질 때 사용 원본 예외의 스택 트레이스를 보존하여 디버깅을 용이하게 함
   * <p>
   * - 외부 API 호출 실패, DB 연결 실패 등의 시스템 예외를 래핑할 때
   */
  public CustomException(ExceptionCode exceptionCode, Throwable cause) {
    super(exceptionCode.getMessage(), cause);
    this.exceptionCode = exceptionCode;
    this.details = Map.of();
  }

  /**
   * 상세 정보와 원본 예외를 모두 포함하는 생성자 하위 레이어 예외를 래핑하면서
   * <p>
   * 추가 컨텍스트도 함께 전달할 때 사용
   */
  public CustomException(ExceptionCode exceptionCode, Map<String, Object> details,
      Throwable cause) {
    super(exceptionCode.getMessage(), cause);
    this.exceptionCode = exceptionCode;
    this.details = details != null ? details : Map.of();
  }
}
