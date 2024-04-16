package com.lostfound.animalback.domain.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {


    @Query("select p.id from Profile p where p.user.id = :userId")
    Integer getProfileIdBy(Integer userId);
}