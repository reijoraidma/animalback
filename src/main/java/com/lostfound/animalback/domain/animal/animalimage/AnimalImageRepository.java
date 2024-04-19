package com.lostfound.animalback.domain.animal.animalimage;

import com.lostfound.animalback.business.animal.animalimage.dto.AnimalImageInfo;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalImageRepository extends JpaRepository<AnimalImage, Integer> {

    @Query("select a from AnimalImage a where a.animal.id = :animalId")
    List<AnimalImage> getAnimalImagesByAnimal_Id(Integer animalId);


}