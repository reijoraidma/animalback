package com.lostfound.animalback.domain.post;

import com.lostfound.animalback.business.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByStatus(String status);

    @Query("select p from Post p where p.animal.animalType.id = :animalTypeId")
    List<Post> findAllByAnimalTypeId(Integer animalTypeId);


}