package com.fridge.studyteacherbe.domain.post;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl {

  private final PostRepository postRepository;

  public List<PostResponseDto> getAllPosts() {
    log.info("getAllPosts");
    List<Post> all = postRepository.findAll();

    return all.stream().map(PostResponseDto::from).toList();
  }

}
