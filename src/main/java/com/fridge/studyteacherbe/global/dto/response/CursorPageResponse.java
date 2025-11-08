package com.fridge.studyteacherbe.global.dto.response;

import java.util.List;

/**
 * Using Cursor-based Pagination
 * <p>
 * 커서 기반 페이지네이션 사용 시 이용하는 Response DTO
 *
 * @param nextCursor 다음 조회를 위한 커서 (마지막 항목의 아이디)
 * @param hasNext    다음 페이지 존재 여부
 * @param size       현재 전달된 항목 수
 * @param totalCount 전체 항목 수
 * @param content    전달될 데이터 리스트
 */
public record CursorPageResponse<T, K>(
    T nextCursor,
    boolean hasNext,
    int size,
    long totalCount,
    List<K> content
) {

  public static <T, K> CursorPageResponse<T, K> of(List<K> content, T nextCursor, boolean hasNext,
      int size, long totalCount) {
    return new CursorPageResponse<>(
        nextCursor,
        hasNext,
        content.size(),
        totalCount,
        content
    );
  }

}
