package com.lostfound.animalback.domain.post;

import com.lostfound.animalback.business.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByStatus(String status);
}