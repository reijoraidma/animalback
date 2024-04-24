package com.lostfound.animalback.business.post;

import com.lostfound.animalback.business.post.dto.PostFilter;
import com.lostfound.animalback.business.post.dto.PostInfo;
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

    @GetMapping("/posts/found")
    @Operation(summary = "Get all found animals info", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) for all found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getFoundFilteredInfo(){
        return postService.getFilteredInfosBy(PostType.FOUND);
    }
    @GetMapping("/posts/found/animaltype/{animalTypeId}")
    @Operation(summary = "Get found animal info by animal type", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal type for found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getFoundFilteredInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getSameAnimalTypeFilteredInfosBy(animalTypeId, PostType.FOUND);
    }

    @GetMapping("/posts/found/animalbreed/{animalBreedId}")
    @Operation(summary = "Get found animal info by animal breed", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal breed for found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getFoundPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getSameAnimalBreedFilteredInfosBy(animalBreedId, PostType.FOUND);
    }

    @GetMapping("/posts/lost")
    @Operation(summary = "Get all lost animals info", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) for all lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getLostFilteredInfo(){
        return postService.getFilteredInfosBy(PostType.LOST);
    }

    @GetMapping("/posts/lost/animaltype/{animalTypeId}")
    @Operation(summary = "Get lost animal info by animal type", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal type for lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getLostPostInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getSameAnimalTypeFilteredInfosBy(animalTypeId, PostType.LOST);
    }

    @GetMapping("/posts/lost/animalbreed/{animalBreedId}")
    @Operation(summary = "Get lost animal info by animal breed", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal breed for lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getLostPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getSameAnimalBreedFilteredInfosBy(animalBreedId, PostType.LOST);
    }


    @GetMapping("/posts/{postId}")
    public PostInfo getPost(@PathVariable Integer postId){
        return postService.getPost(postId);
    }

}
