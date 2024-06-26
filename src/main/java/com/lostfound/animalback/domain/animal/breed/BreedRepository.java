package com.lostfound.animalback.domain.animal.breed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BreedRepository extends JpaRepository<Breed, Integer> {


    @Query("select b from Breed b where b.status = ?1 and b.animalType.id = ?2")
    List<Breed> getBreedsBy(String status, Integer animalTypeId);

    @Query("select (count(b) > 0) from Breed b where b.type = ?1 and b.animalType.id = ?2")
    boolean breedExistsBy(String type, Integer animalTypeId);

    @Query("select (count(b) > 0) from Breed b where b.id = ?1")
    boolean breedIdExists(Integer id);


}