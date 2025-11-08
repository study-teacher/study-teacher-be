package com.fridge.studyteacherbe.global.dto.response;

/**
 * 응답(CommonResponse) 내부 데이터에 단순 데이터의 ID만 전달할 때 사용
 */
public record IdResponseDto<T>(T id) {

  public static <T> IdResponseDto<T> of(T id) {
    return new IdResponseDto<>(id);
  }

}
