package com.lostfound.animalback.business.post;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;
    @GetMapping("/posts/found/{animalTypeId}")
    List<PostFilter> getInitialInfoBy(@PathVariable Integer animalTypeId){
        return postService.getInitialInfoBy(animalTypeId);
    }
}
