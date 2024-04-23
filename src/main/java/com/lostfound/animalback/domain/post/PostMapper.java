package com.lostfound.animalback.domain.post;

import com.lostfound.animalback.business.post.dto.PostFilter;
import com.lostfound.animalback.business.post.dto.PostRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {

    @Named("toPostFilter")
    @Mapping(source = "id", target = "postId")
    @Mapping(source = "timestamp", target = "postTimestamp")
    @Mapping(source = "county", target = "postCounty")
    PostFilter toPostFilter(Post post);

    @IterableMapping(qualifiedByName = "toPostFilter")
    List<PostFilter> toPostFilters(List<Post> posts);

    @Mapping(source = "postType", target = "type")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "county", target = "county")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "info", target = "info")
    Post toPost(PostRequest postRequest);
}