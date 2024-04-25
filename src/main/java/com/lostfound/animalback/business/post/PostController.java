package com.lostfound.animalback.business.post;

import com.lostfound.animalback.business.post.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    @Operation(summary = "Add new post", description = "Accepts lost or found posts. postType,userId,animalType,postAnimalImageData are mandatory. If animalType or animalBreed status is PENDING ('P') then post status will be PENDING ('P')")
    @ApiResponse(responseCode = "200", description = "OK")
    public void savePost(@RequestBody PostRequest postRequest){
        postService.savePost(postRequest);
    }

    @PatchMapping("/posts")
    @Operation(summary = "Change post", description = "Accepts lost or found posts. postId,animalTypeId are mandatory. If animalType or animalBreed status is PENDING ('P') then post status will be PENDING ('P')")
    @ApiResponse(responseCode = "200", description = "OK")
    public void changePost(@RequestBody PostChangeRequest postChangeRequest){
        postService.changePost(postChangeRequest);
    }
    @GetMapping("/posts/{postId}")
    public PostInfo getPost(@PathVariable Integer postId){
        return postService.getPost(postId);
    }
    @GetMapping("/posts/found")
    @Operation(summary = "Get all found animals info", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) for all found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<PostFilter> getFoundFilteredInfo(){
        return postService.getFilteredInfosBy(PostType.FOUND);
    }
    @GetMapping("/posts/found/animaltypes/{animalTypeId}")
    @Operation(summary = "Get found animal info by animal type", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal type for found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<PostFilter> getFoundFilteredInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getSameAnimalTypeFilteredInfosBy(animalTypeId, PostType.FOUND);
    }

    @GetMapping("/posts/found/animalbreeds/{animalBreedId}")
    @Operation(summary = "Get found animal info by animal breed", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal breed for found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<PostFilter> getFoundPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getSameAnimalBreedFilteredInfosBy(animalBreedId, PostType.FOUND);
    }

    @GetMapping("/posts/found/postFilter")
    @Operation(summary = "Get found animal info by filters ", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by filters(animalTypeId,animalBreedId,size, color, age) for found animals")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<PostFilter> getFoundPostInfoBy(@RequestParam(required = false) Integer animalTypeId,
                                               @RequestParam(required = false) Integer animalBreedId,
                                               @RequestParam(required = false) String postAnimalSize,
                                               @RequestParam(required = false) String postAnimalColor,
                                               @RequestParam(required = false) String postAnimalAge)
    {
        return postService.getPostInfoByFilter(animalTypeId,animalBreedId,postAnimalSize,postAnimalColor,postAnimalAge, PostType.FOUND);
    }
    @GetMapping("/posts/found/features")
    @Operation(summary = "Get found animals features by filters", description = "Returns a list of features lists(animalSizes,animalAges,animalColors) features by filter criteria(animalTypeId,animalBreedId,size, color, age) for found animals, features must meet all criteria")
    @ApiResponse(responseCode = "200", description = "OK")
    public PostAnimalUniqueFeatures getFoundAnimalsUniqueFeatures(@RequestParam(required = false) Integer animalTypeId,
                                                                  @RequestParam(required = false) Integer animalBreedId,
                                                                  @RequestParam(required = false) String animalSize,
                                                                  @RequestParam(required = false) String postAnimalColor,
                                                                  @RequestParam(required = false) String postAnimalAge)
    {
        return postService.getAnimalsUniqueFeatures(animalTypeId,animalBreedId,animalSize,postAnimalColor,postAnimalAge, PostType.FOUND);
    }

    @GetMapping("/posts/lost")
    @Operation(summary = "Get all lost animals info", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) for all lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<PostFilter> getLostFilteredInfo(){
        return postService.getFilteredInfosBy(PostType.LOST);
    }

    @GetMapping("/posts/lost/animaltypes/{animalTypeId}")
    @Operation(summary = "Get lost animal info by animal type", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal type for lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<PostFilter> getLostPostInfoByAnimalType(@PathVariable Integer animalTypeId){
        return postService.getSameAnimalTypeFilteredInfosBy(animalTypeId, PostType.LOST);
    }

    @GetMapping("/posts/lost/animalbreeds/{animalBreedId}")
    @Operation(summary = "Get lost animal info by animal breed", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by animal breed for lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    List<PostFilter> getLostPostInfoByAnimalBreed(@PathVariable Integer animalBreedId){
        return postService.getSameAnimalBreedFilteredInfosBy(animalBreedId, PostType.LOST);
    }

    @GetMapping("/posts/lost/postFilter")
    @Operation(summary = "Get lost animal info by filters ", description = "Returns list of info(postId,postTimestamp,postCounty,animalImageData) by filters(animalTypeId,animalBreedId,size, color, age) for lost animals")
    @ApiResponse(responseCode = "200", description = "OK")
    public List<PostFilter> getLostPostInfoBy(@RequestParam(required = false) Integer animalTypeId,
                                               @RequestParam(required = false) Integer animalBreedId,
                                               @RequestParam(required = false) String postAnimalSize,
                                               @RequestParam(required = false) String postAnimalColor,
                                               @RequestParam(required = false) String postAnimalAge)
    {
        return postService.getPostInfoByFilter(animalTypeId,animalBreedId,postAnimalSize,postAnimalColor,postAnimalAge, PostType.LOST);
    }

    @GetMapping("/posts/lost/features")
    @Operation(summary = "Get lost animals features by filters ", description = "Returns a list of features lists(animalSizes,animalAges,animalColors) by filter criteria(animalTypeId,animalBreedId,size, color, age) for lost animals, features must meet all criteria")
    @ApiResponse(responseCode = "200", description = "OK")
    public PostAnimalUniqueFeatures getLostAnimalsUniqueFeatures(@RequestParam(required = false) Integer animalTypeId,
                                                                  @RequestParam(required = false) Integer animalBreedId,
                                                                  @RequestParam(required = false) String animalSize,
                                                                  @RequestParam(required = false) String postAnimalColor,
                                                                  @RequestParam(required = false) String postAnimalAge)
    {
        return postService.getAnimalsUniqueFeatures(animalTypeId,animalBreedId,animalSize,postAnimalColor,postAnimalAge, PostType.LOST);
    }
}
