package com.lostfound.animalback.domain.post;

import com.lostfound.animalback.business.post.dto.PostChangeRequest;
import com.lostfound.animalback.business.post.dto.PostFilteredInfo;
import com.lostfound.animalback.business.post.dto.PostInfo;
import com.lostfound.animalback.business.post.dto.PostRequest;
import org.mapstruct.*;
import util.TimestampConverter;

import javax.swing.table.TableStringConverter;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {

    @Named("toPostFilter")
    @Mapping(source = "id", target = "postId")
    @Mapping(source = "timestamp", target = "postTimestamp", qualifiedByName = "localDateTimeToString")
    @Mapping(source = "county", target = "postCounty")
    @Mapping(source = "title", target = "title")
    PostFilteredInfo toPostFilteredInfo(Post post);

    @IterableMapping(qualifiedByName = "toPostFilter")
    List<PostFilteredInfo> toPostFilteredInfos(List<Post> posts);

    @Mapping(source = "postType", target = "type")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "city", target = "city")
    @Mapping(source = "county", target = "county")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "info", target = "info")
    Post toPost(PostRequest postRequest);


    @Mapping(source = "animal.animalType.name", target = "animalTypeName")
    @Mapping(source = "animal.breed.type", target = "animalBreedType")
    @Mapping(source = "animal.size", target = "animalSize")
    @Mapping(source = "animal.color", target = "animalColor")
    @Mapping(source = "animal.age", target = "animalAge")
    @Mapping(source = "county", target = "county")
    @Mapping(source = "animal.gender.type", target = "animalGenderType")
    @Mapping(source = "animal.id", target = "animalId")
    @Mapping(source = "info", target = "info")
    @Mapping(source = "title", target = "title")

    PostInfo toPostInfo(Post post);

    @Mapping(source = "animalTypeId", target = "animalTypeId")
    @Mapping(source = "animalBreedId", target = "animalBreedId")
    @Mapping(source = "animalGenderId", target = "animalGenderId")
    @Mapping(source = "animalSize", target = "animalSize")
    @Mapping(source = "animalAge", target = "animalAge")
    @Mapping(source = "animalColor", target = "animalColor")
    PostRequest toPostRequest(PostChangeRequest postChangeRequest);


    @Named("localDateTimeToString")
    static String localDateTimeToString(LocalDateTime localDateTime){
       return TimestampConverter.localDateTimeToString(localDateTime);
    }
}