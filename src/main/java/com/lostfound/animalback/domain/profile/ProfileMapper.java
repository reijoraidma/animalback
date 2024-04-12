package com.lostfound.animalback.domain.profile;

import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import org.mapstruct.*;
import util.StringConverter;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    Profile profile = new  Profile();

    @Mapping(source = "name", target = "name")
    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(expression = "java(StringConverter.bytesToString(profile.getImageData()))", target = "imageData")
    ProfileInfo toProfileInfo(Profile profile);
}