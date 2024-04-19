package com.lostfound.animalback.domain.animal;

import com.lostfound.animalback.domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}