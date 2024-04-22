package com.lostfound.animalback.domain.post;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    @Query("select p from Post p where p.animal.animalType.id = :animalTypeId and p.type = :postType")
    List<Post> findPostsByType(Integer animalTypeId, String postType);

    @Query("select p from Post p where p.animal.animalType.id = :animalBreedId and p.type = :postType")
    List<Post> findPostsByBreed(Integer animalBreedId, String postType);


}