package com.lostfound.animalback.business.post;

import com.lostfound.animalback.business.post.dto.PostFilter;
import com.lostfound.animalback.business.post.dto.PostInfo;
import com.lostfound.animalback.domain.animal.animalimage.AnimalImage;
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

    public List<PostFilter> getFilteredInfosBy(String postType) {

        List<Post> AnimalPosts = postRepository.findPostsBy(postType);
        List<PostFilter> filteredInfos = postMapper.toPostFilters(AnimalPosts);
        addFirstAnimalImage(AnimalPosts, filteredInfos);
        return filteredInfos;
    }
    public List<PostFilter> getSameAnimalTypeFilteredInfosBy(Integer animalTypeId, String postType ) {

        List<Post> sameAnimalTypePosts = postRepository.findSameAnimalTypePostsBy(animalTypeId, postType);
        List<PostFilter> filteredInfos = postMapper.toPostFilters(sameAnimalTypePosts);
        addFirstAnimalImage(sameAnimalTypePosts, filteredInfos);
        return filteredInfos;
    }
    public List<PostFilter> getSameAnimalBreedFilteredInfosBy(Integer animalBreedId,String postType) {

        List<Post> sameAnimalBreedPosts = postRepository.findSameAnimalBreedPostsBy(animalBreedId, postType);
        List<PostFilter> filteredInfos = postMapper.toPostFilters(sameAnimalBreedPosts);
        addFirstAnimalImage(sameAnimalBreedPosts, filteredInfos);
        return filteredInfos;
    }

    private void addFirstAnimalImage(List<Post> animalPosts, List<PostFilter> filteredInfos) {
        for (Post post : animalPosts){
            Integer animalId = post.getAnimal().getId();
            String animalImage = StringConverter.bytesToString(animalImageRepository.getAnimalImagesByAnimal_Id(animalId).getFirst().getImageData());
            for(PostFilter postFilter: filteredInfos){
                if(postFilter.getPostId().equals(post.getId())){
                    postFilter.setAnimalImageData(animalImage);
                }
            }
        }
    }


    public PostInfo getPost(Integer postId) {
        Post post = postRepository.getReferenceById(postId);
        return postMapper.toPostInfo(post);
    }
}
