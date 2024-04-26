package com.lostfound.animalback.domain.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {


    @Query("select p from Post p where p.type = :postType order by p.timestamp desc")
    List<Post> findPostsBy(String postType);

    @Query("select p from Post p order by p.timestamp desc")
    List<Post> findDateOrderedPosts();

    @Query("select p from Post p where p.animal.animalType.id = :animalTypeId and p.type = :postType")
    List<Post> findSameAnimalTypePostsBy(Integer animalTypeId, String postType);

    @Query("select p from Post p where p.animal.breed.id = :animalBreedId and p.type = :postType")
    List<Post> findSameAnimalBreedPostsBy(Integer animalBreedId, String postType);

    @Query("SELECT p FROM Post p WHERE " +
            "(:animalTypeId IS NULL OR :animalTypeId = 0 OR p.animal.animalType.id = :animalTypeId) " +
            "AND (:animalBreedId IS NULL OR :animalBreedId = 0 OR p.animal.breed.id = :animalBreedId) " +
            "AND (:postAnimalSize IS NULL OR :postAnimalSize = '' OR p.animal.size = :postAnimalSize) " +
            "AND (:postAnimalAge IS NULL OR :postAnimalAge = '' OR p.animal.age = :postAnimalAge) " +
            "AND (:postAnimalColor IS NULL OR :postAnimalColor = '' OR p.animal.color = :postAnimalColor) " +
            "AND p.type = :postType")
    List<Post> findPostsWithOptionalParams( Integer animalTypeId,
                                            Integer animalBreedId,
                                            String postAnimalSize,
                                            String postAnimalColor,
                                            String postAnimalAge,
                                            String postType);

    @Query("SELECT p.animal.size FROM Post p WHERE " +
            "(:animalTypeId IS NULL OR :animalTypeId = 0 OR p.animal.animalType.id = :animalTypeId) " +
            "AND (:animalBreedId IS NULL OR :animalBreedId = 0 OR p.animal.breed.id = :animalBreedId) " +
            "AND (:postAnimalSize IS NULL OR :postAnimalSize = '' OR p.animal.size = :postAnimalSize) " +
            "AND (:postAnimalAge IS NULL OR :postAnimalAge = '' OR p.animal.age = :postAnimalAge) " +
            "AND (:postAnimalColor IS NULL OR :postAnimalColor = '' OR p.animal.color = :postAnimalColor) " +
            "AND p.type = :postType")
    List<String> findSizesWithOptionalParams(Integer animalTypeId,
                                             Integer animalBreedId,
                                             String postAnimalSize,
                                             String postAnimalAge,
                                             String postAnimalColor,
                                             String postType);
    @Query("SELECT p.animal.age FROM Post p WHERE " +
            "(:animalTypeId IS NULL OR :animalTypeId = 0 OR p.animal.animalType.id = :animalTypeId) " +
            "AND (:animalBreedId IS NULL OR :animalBreedId = 0 OR p.animal.breed.id = :animalBreedId) " +
            "AND (:postAnimalSize IS NULL OR :postAnimalSize = '' OR p.animal.size = :postAnimalSize) " +
            "AND (:postAnimalAge IS NULL OR :postAnimalAge = '' OR p.animal.age = :postAnimalAge) " +
            "AND (:postAnimalColor IS NULL OR :postAnimalColor = '' OR p.animal.color = :postAnimalColor) " +
            "AND p.type = :postType")
    List<String> findAgesWithOptionalParams(Integer animalTypeId,
                                            Integer animalBreedId,
                                            String postAnimalSize,
                                            String postAnimalAge,
                                            String postAnimalColor,
                                            String postType);

    @Query("SELECT p.animal.color FROM Post p WHERE " +
            "(:animalTypeId IS NULL OR :animalTypeId = 0 OR p.animal.animalType.id = :animalTypeId) " +
            "AND (:animalBreedId IS NULL OR :animalBreedId = 0 OR p.animal.breed.id = :animalBreedId) " +
            "AND (:postAnimalSize IS NULL OR :postAnimalSize = '' OR p.animal.size = :postAnimalSize) " +
            "AND (:postAnimalAge IS NULL OR :postAnimalAge = '' OR p.animal.age = :postAnimalAge) " +
            "AND (:postAnimalColor IS NULL OR :postAnimalColor = '' OR p.animal.color = :postAnimalColor) " +
            "AND p.type = :postType")
    List<String> findColorsWithOptionalParams(Integer animalTypeId,
                                              Integer animalBreedId,
                                              String postAnimalSize,
                                              String postAnimalAge,
                                              String postAnimalColor,
                                              String postType);


}