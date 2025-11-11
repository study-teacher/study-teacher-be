package com.fridge.studyteacherbe.domain.post;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostResponseDto {

  private final Long id;
  private final String title;
  private final String author;
  private final String content;

  public static PostResponseDto from(Post post) {
    return new PostResponseDto(
        post.getId(),
        post.getTitle(),
        post.getAuthor(),
        post.getContent()
    );
  }

}
