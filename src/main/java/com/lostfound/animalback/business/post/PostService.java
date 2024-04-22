package com.lostfound.animalback.business.post;

import com.lostfound.animalback.domain.animal.animalimage.AnimalImageRepository;
import com.lostfound.animalback.domain.post.Post;
import com.lostfound.animalback.domain.post.PostMapper;
import com.lostfound.animalback.domain.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import util.StringConverter;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final AnimalImageRepository animalImageRepository;
    private final PostMapper postMapper;

    public List<PostFilter> getInitialInfoBy(Integer animalTypeId) {

        List<Post> oneTypeAnimalPosts = postRepository.findAllByAnimalTypeId(animalTypeId);
        List<PostFilter> postFilters = postMapper.toPostFilters(oneTypeAnimalPosts);

        for (Post post : oneTypeAnimalPosts){
            Integer animalId = post.getAnimal().getId();
            String animalImage = StringConverter.bytesToString(animalImageRepository.getAnimalImagesByAnimal_Id(animalId).getFirst().getImageData());
            for(PostFilter postFilter: postFilters){
                if(postFilter.getPostId().equals(post.getId())){
                    postFilter.setAnimalImageData(animalImage);
                }
            }
        }
        return postFilters;
    }
}
