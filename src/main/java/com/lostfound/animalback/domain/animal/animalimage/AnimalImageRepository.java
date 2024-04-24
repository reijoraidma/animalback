package com.lostfound.animalback.domain.animal.animalimage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalImageRepository extends JpaRepository<AnimalImage, Integer> {

    @Query("select a from AnimalImage a where a.animal.id = :animalId")
    List<AnimalImage> getAnimalImagesBy(Integer animalId);


}