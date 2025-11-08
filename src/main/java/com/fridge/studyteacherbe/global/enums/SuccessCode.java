package com.fridge.studyteacherbe.global.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum SuccessCode {
  SUCCESS("S001", "SUCCESS", HttpStatus.OK),
  CREATED("S002", "CREATED SUCCESSFULLY.", HttpStatus.CREATED),
  UPDATED("S003", "UPDATED SUCCESSFULLY", HttpStatus.OK),
  DELETED("S004", "DELETED SUCCESSFULLY", HttpStatus.NO_CONTENT),

  // 도메인 별 (필요시)
  USER_CREATED("SU101", "사용자가 생성되었습니다.", HttpStatus.CREATED),
  USER_UPDATED("SU102", "사용자 정보가 수정되었습니다.", HttpStatus.OK);

  private final String code;
  private final String message;
  private final HttpStatus httpStatus;

}
