package com.lostfound.animalback.business.post;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/{postType}")
    List<PostInfo> getPostInfos(@PathVariable PostType postType){
        return postService.getPostInfos(postType);
    }
}
