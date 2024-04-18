package com.lostfound.animalback.domain.user;

import com.lostfound.animalback.business.login.dto.LoginResponse;

import com.lostfound.animalback.business.register.dto.UserRequest;
import org.mapstruct.*;

import static com.lostfound.animalback.business.Status.ACTIVE;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    @Mapping(constant = ACTIVE, target = "status")
    User toUser(UserRequest userRequest);

}