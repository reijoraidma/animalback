package com.lostfound.animalback.business.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Get found animal info by animal type", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal type for found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getFoundPostInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getPostInfoByAnimalType(animalTypeId, PostType.FOUND);
    }

    @GetMapping("/posts/found/{animalBreedId}")
    @Operation(summary = "Get found animal info by animal breed", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal breed for found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getFoundPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getPostInfoByAnimalBreed(animalBreedId, PostType.FOUND);
    }

    @GetMapping("/posts/lost/{animalTypeId}")
    @Operation(summary = "Get lost animal info by animal type", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal type for lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getLostPostInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getPostInfoByAnimalType(animalTypeId, PostType.LOST);
    }

    @GetMapping("/posts/lost/{animalBreedId}")
    @Operation(summary = "Get lost animal info by animal breed", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal breed for lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getLostPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getPostInfoByAnimalBreed(animalBreedId, PostType.LOST);
    }

}
