package com.fridge.studyteacherbe.domain.post;

import com.fridge.studyteacherbe.global.dto.response.CommonResponse;
import com.fridge.studyteacherbe.global.enums.SuccessCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

  private final PostServiceImpl postService;

  @GetMapping
  public ResponseEntity<CommonResponse<List<PostResponseDto>>> getPosts() {

    return ResponseEntity.ok()
        .body(CommonResponse.of(
            SuccessCode.SUCCESS,
            postService.getAllPosts()
        ));
  }

}
