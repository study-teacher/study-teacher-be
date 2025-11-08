package com.fridge.studyteacherbe.global.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fridge.studyteacherbe.global.enums.SuccessCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

/**
 * 응답 데이터 전달 시 기본 형식
 */
@Getter
@Builder(access = AccessLevel.PROTECTED)
@JsonInclude(Include.NON_EMPTY) // 비지 않은 것만 전달
public class CommonResponse<T> {

  @Schema(description = "Http Status Code", example = "200")
  private int statusCode;

  @Schema(description = "Custom Status Code", example = "COMM001")
  private String code;

  @Schema(description = "Message", example = "SUCCESS")
  private String message;

  @Schema(description = "Data")
  private T data;

  public static <T> CommonResponse<T> of(SuccessCode successCode, T data) {
    return CommonResponse.<T>builder()
        .statusCode(successCode.getHttpStatus().value())
        .code(successCode.getCode())
        .message(successCode.getMessage())
        .data(data)
        .build();
  }

  public static <T> CommonResponse<T> of(SuccessCode successCode) {
    return of(successCode, null);
  }

}
