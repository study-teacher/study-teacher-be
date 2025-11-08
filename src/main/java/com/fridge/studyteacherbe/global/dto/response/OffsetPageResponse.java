package com.fridge.studyteacherbe.global.dto.response;

import java.util.List;
import org.springframework.data.domain.Page;

/**
 * Using Offset-based Pagination
 * <p>
 * 오프셋 기반 페이지네이션 사용 시 이용하는 Response DTO
 *
 * @param page       현재 페이지 번호
 * @param size       페이지 별 항목 수
 * @param totalPages 전체 페이지 수
 * @param totalCount 전체 항목 수
 * @param hasNext    다음 페이지 존재 여부
 * @param content    전달될 데이터 리스트
 */
public record OffsetPageResponse<T>(
    int page,
    int size,
    int totalPages,
    long totalCount,
    boolean hasNext,
    List<T> content
) {

  public static <T> OffsetPageResponse<T> of(Page<T> page) {
    return new OffsetPageResponse<>(
        page.getNumber(),
        page.getSize(),
        page.getTotalPages(),
        page.getTotalElements(),
        page.hasNext(),
        page.getContent()
    );
  }
}
