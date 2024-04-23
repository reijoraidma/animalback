package com.lostfound.animalback.domain.animal.animaltype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Integer> {

    @Query("select (count(a) > 0) from AnimalType a where upper(a.name) = upper(:animalTypeName)")
    Boolean existsAnimalTypeByName(String animalTypeName);

    @Query("select a from AnimalType a where a.status = :status or a.user.id = :userId order by a.name")
    List<AnimalType> findAnimalTypesByEither(String status, Integer userId);

}