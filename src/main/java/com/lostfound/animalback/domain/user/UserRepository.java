package com.lostfound.animalback.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query("select u from User u where u.email = :email and u.password = :password")
    Optional<User> findUserBy(String email, String password);

    @Transactional
    @Modifying
    @Query("delete from User u where u.id = :id")
    int deleteUserBy(Integer id);

}