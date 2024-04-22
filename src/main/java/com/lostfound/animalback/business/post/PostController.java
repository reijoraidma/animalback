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
    List<PostFilter> getFoundPostInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getPostInfoByAnimalType(animalTypeId, PostType.FOUND);
    }

    @GetMapping("/posts/found/{animalBreedId}")
    List<PostFilter> getFoundPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getPostInfoByAnimalBreed(animalBreedId, PostType.FOUND);
    }

    @GetMapping("/posts/lost/{animalTypeId}")
    List<PostFilter> getLostPostInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getPostInfoByAnimalType(animalTypeId, PostType.LOST);
    }

    @GetMapping("/posts/lost/{animalBreedId}")
    List<PostFilter> getLostPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getPostInfoByAnimalBreed(animalBreedId, PostType.LOST);
    }

}
