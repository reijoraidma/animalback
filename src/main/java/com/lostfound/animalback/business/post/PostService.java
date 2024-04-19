package com.lostfound.animalback.business.post;

import com.lostfound.animalback.domain.post.Post;
import com.lostfound.animalback.domain.post.PostMapper;
import com.lostfound.animalback.domain.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    public List<PostInfo> getPostInfos(String postType) {
        List<Post> postsByType = postRepository.findAllByStatus(postType);
    }
}
