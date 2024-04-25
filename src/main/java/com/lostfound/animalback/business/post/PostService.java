package com.lostfound.animalback.business.post;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.post.dto.*;
import com.lostfound.animalback.domain.animal.Animal;
import com.lostfound.animalback.domain.animal.AnimalRepository;
import com.lostfound.animalback.domain.animal.animalgender.AnimalGenderRepository;
import com.lostfound.animalback.domain.animal.animalimage.AnimalImage;
import com.lostfound.animalback.domain.animal.animalimage.AnimalImageRepository;
import com.lostfound.animalback.domain.animal.animaltype.AnimalTypeRepository;
import com.lostfound.animalback.domain.animal.breed.BreedRepository;
import com.lostfound.animalback.domain.post.Post;
import com.lostfound.animalback.domain.post.PostMapper;
import com.lostfound.animalback.domain.post.PostRepository;
import com.lostfound.animalback.domain.user.User;
import com.lostfound.animalback.domain.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.StringConverter;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AnimalImageRepository animalImageRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;
    private final AnimalRepository animalRepository;
    private final AnimalTypeRepository animalTypeRepository;
    private final AnimalGenderRepository animalGenderRepository;
    private final BreedRepository breedRepository;

    public List<PostFilter> getFilteredInfosBy(String postType) {

        List<Post> animalPosts = postRepository.findPostsBy(postType);
        List<PostFilter> filteredInfos = postMapper.toPostFilters(animalPosts);
        addFirstAnimalImage(animalPosts, filteredInfos);
        return filteredInfos;
    }
    public List<PostFilter> getSameAnimalTypeFilteredInfosBy(Integer animalTypeId, String postType ) {

        List<Post> sameAnimalTypePosts = postRepository.findSameAnimalTypePostsBy(animalTypeId, postType);
        List<PostFilter> filteredInfos = postMapper.toPostFilters(sameAnimalTypePosts);
        addFirstAnimalImage(sameAnimalTypePosts, filteredInfos);
        return filteredInfos;
    }
    public List<PostFilter> getSameAnimalBreedFilteredInfosBy(Integer animalBreedId,String postType) {

        List<Post> sameAnimalBreedPosts = postRepository.findSameAnimalBreedPostsBy(animalBreedId, postType);
        List<PostFilter> filteredInfos = postMapper.toPostFilters(sameAnimalBreedPosts);
        addFirstAnimalImage(sameAnimalBreedPosts, filteredInfos);
        return filteredInfos;
    }
    public List<PostFilter> getPostInfoByFilter(Integer animalTypeId,Integer animalBreedId,String postAnimalSize,String postAnimalColor,String postAnimalAge, String postType) {
        List<Post> postsFilter = postRepository.findPostsWithOptionalParams(
                animalTypeId,
                animalBreedId,
                postAnimalSize,
                postAnimalColor,
                postAnimalAge,
                postType);
        List<PostFilter> filteredInfos = postMapper.toPostFilters(postsFilter);
        addFirstAnimalImage(postsFilter, filteredInfos);
        return filteredInfos;
    }


    public PostAnimalUniqueFeatures getAnimalsUniqueFeatures(Integer animalTypeId,
                                                 Integer animalBreedId,
                                                 String postAnimalSize,
                                                 String postAnimalAge,
                                                 String postAnimalColor,
                                                 String found)
    {
        PostAnimalUniqueFeatures postAnimalUniqueFeatures = new PostAnimalUniqueFeatures();
        postAnimalUniqueFeatures.setAnimalSizes(getAnimalsUniqueSizes(animalTypeId,animalBreedId,postAnimalSize,postAnimalAge,postAnimalColor,found));
        postAnimalUniqueFeatures.setAnimalColors(getAnimalsUniqueColors(animalTypeId,animalBreedId,postAnimalSize,postAnimalAge,postAnimalColor,found));
        postAnimalUniqueFeatures.setAnimalAges(getAnimalsUniqueAges(animalTypeId,animalBreedId,postAnimalSize,postAnimalAge,postAnimalColor,found));
        return postAnimalUniqueFeatures;
    }
    public List<String> getAnimalsUniqueSizes(Integer animalTypeId, Integer animalBreedId, String postAnimalSize, String postAnimalColor, String postAnimalAge, String postType) {
        List<String> postsAllAnimalSizes = postRepository.findSizesWithOptionalParams(
                animalTypeId,
                animalBreedId,
                postAnimalSize,
                postAnimalAge,
                postAnimalColor,
                postType);
        return postsAllAnimalSizes.stream().distinct().toList();
    }

    public List<String> getAnimalsUniqueColors(Integer animalTypeId, Integer animalBreedId, String postAnimalSize, String postAnimalColor, String postAnimalAge, String postType) {
        List<String> postsAllAnimalColors = postRepository.findColorsWithOptionalParams(
                animalTypeId,
                animalBreedId,
                postAnimalSize,
                postAnimalAge,
                postAnimalColor,
                postType);
        return postsAllAnimalColors.stream().distinct().toList();
    }
    public List<String> getAnimalsUniqueAges(Integer animalTypeId, Integer animalBreedId, String postAnimalSize, String postAnimalColor, String postAnimalAge, String postType) {
        List<String> postsAllAnimalAges = postRepository.findAgesWithOptionalParams(
                animalTypeId,
                animalBreedId,
                postAnimalSize,
                postAnimalAge,
                postAnimalColor,
                postType);
        return postsAllAnimalAges.stream().distinct().toList();
    }

    private void addFirstAnimalImage(List<Post> animalPosts, List<PostFilter> filteredInfos) {
        for (Post post : animalPosts){
            Integer animalId = post.getAnimal().getId();
            String animalImage = StringConverter.bytesToString(animalImageRepository.getAnimalImagesBy(animalId).getFirst().getImageData());
            for(PostFilter postFilter: filteredInfos){
                if(postFilter.getPostId().equals(post.getId())){
                    postFilter.setAnimalImageData(animalImage);
                }
            }
        }
    }


    public PostInfo getPost(Integer postId) {
        Post post = postRepository.getReferenceById(postId);
        return postMapper.toPostInfo(post);
    }

    @Transactional
    public void savePost(PostRequest postRequest) {

        Post post= postMapper.toPost(postRequest);
        User user = userRepository.getReferenceById(postRequest.getUserId());
        post.setUser(user);
        Animal animal = createAnimalAndFillInfo(postRequest);
        Animal savedAnimal = saveAnimalAndChangePostStatus(animal,post);

        post.setTimestamp(LocalDateTime.now());

        AnimalImage animalImage = new AnimalImage();
        animalImage.setAnimal(savedAnimal);
        animalImage.setImageData(StringConverter.stringToBytes(postRequest.getPostAnimalImageData()));
        animalImageRepository.save(animalImage);

        postRepository.save(post);
    }
    private Animal createAnimalAndFillInfo(PostRequest postRequest) {
        Animal animal = new Animal();
        fillAnimalInfo(postRequest, animal);
        return animal;
    }

    @Transactional
    public void changePost(PostChangeRequest postChangeRequest) {
        Post post= postRepository.getReferenceById(postChangeRequest.getPostId());
        Animal animal = animalRepository.getReferenceById(post.getAnimal().getId());
        fillAnimalInfo(postMapper.toPostRequest(postChangeRequest),animal);
        saveAnimalAndChangePostStatus(animal, post);
        postRepository.save(post);
    }
    private void fillAnimalInfo(PostRequest postRequest, Animal animal) {
        animal.setAnimalType(animalTypeRepository.getReferenceById(postRequest.getAnimalTypeId()));
        animal.setBreed(breedRepository.getReferenceById(postRequest.getAnimalBreedId()));
        animal.setGender(animalGenderRepository.getReferenceById(postRequest.getAnimalGenderId()));
        animal.setSize(postRequest.getAnimalSize());
        animal.setAge(postRequest.getAnimalAge());
        animal.setColor(postRequest.getAnimalColor());
    }

    Animal saveAnimalAndChangePostStatus(Animal animal, Post post) {
        Animal savedAnimal = animalRepository.save(animal);
        post.setAnimal(savedAnimal);
        String animalTypeStatus = savedAnimal.getAnimalType().getStatus();
        String animalBreedStatus = savedAnimal.getBreed().getStatus();
        changePostStatus(post, animalTypeStatus, animalBreedStatus);
        return savedAnimal;
    }

    private static void changePostStatus(Post post, String animalTypeStatus, String animalBreedStatus) {
        if(animalTypeStatus.equals(Status.PENDING) || animalBreedStatus.equals(Status.PENDING)){
            post.setStatus(Status.PENDING);
        }else {
            post.setStatus(Status.ACTIVE);
        }
    }
}
