package com.lostfound.animalback.domain.post;

import com.lostfound.animalback.business.Status;
import com.lostfound.animalback.business.post.PostInfo;
import com.lostfound.animalback.business.register.dto.UserRequest;
import com.lostfound.animalback.domain.user.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(constant = Status.DEACTIVATED, target = "status")
    User toUser(UserRequest userRequest);

    List<Post> toPosts
}