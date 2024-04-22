package com.lostfound.animalback.business.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.lostfound.animalback.domain.post.Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostFilter implements Serializable {

    private Integer postId;
    private Integer postTimestamp;
    private String postCounty;
    private String animalImageData;
}