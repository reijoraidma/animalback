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
public class PostFilteredInfo implements Serializable {

    private Integer postId;
    private String title;
    private String postTimestamp;
    private String postCounty;
    private String animalImageData;
}