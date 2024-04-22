package com.lostfound.animalback.domain.post;

import com.lostfound.animalback.business.post.PostFilter;
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
    List<PostFilter> toPostFilters(List<Post> Posts);
}