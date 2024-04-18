package com.lostfound.animalback.domain.animal.animaltype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Integer> {
    List<AnimalType> findAnimalTypeByStatus(String status);
}