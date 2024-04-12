package com.lostfound.animalback.domain.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {


    @Query("select r from Role r where r.id = :id")
    Role findRoleById(Integer id);
}