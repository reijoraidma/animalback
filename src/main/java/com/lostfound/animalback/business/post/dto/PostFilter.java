package com.lostfound.animalback.business.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.lostfound.animalback.domain.post.Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostFilter implements Serializable {

    private Integer postId;
    private LocalDateTime postTimestamp;
    private String postCounty;
    private String animalImageData;
}