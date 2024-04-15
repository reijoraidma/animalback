package com.lostfound.animalback.domain.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    

    @Query("select p from Profile p where p.id = :ProfileId")
    Profile getProfile(Integer ProfileId);

    @Transactional
    @Modifying
    @Query("delete from Profile p where p.id = :id")
    int deleteProfileBy(Integer id);
}