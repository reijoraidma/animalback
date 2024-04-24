package com.lostfound.animalback.domain.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {


    @Query("select p from Post p where p.type = :postType")
    List<Post> findPostsBy(String postType);

    @Query("select p from Post p where p.animal.animalType.id = :animalTypeId and p.type = :postType")
    List<Post> findSameAnimalTypePostsBy(Integer animalTypeId, String postType);

    @Query("select p from Post p where p.animal.breed.id = :animalBreedId and p.type = :postType")
    List<Post> findSameAnimalBreedPostsBy(Integer animalBreedId, String postType);

    @Query("SELECT p FROM Post p WHERE " +
            "(:postAnimalSize IS NULL OR :postAnimalSize = '' OR p.animal.size = :postAnimalSize) " +
            "AND (:postAnimalColor IS NULL OR :postAnimalColor = '' OR p.animal.color = :postAnimalColor) " +
            "AND (:postAnimalAge IS NULL OR :postAnimalAge = '' OR p.animal.age = :postAnimalAge) " +
            "AND p.type = :postType")
    List<Post> findPostsWithOptionalParams( String postAnimalSize,
                                            String postAnimalColor,
                                            String postAnimalAge,
                                            String postType);

}