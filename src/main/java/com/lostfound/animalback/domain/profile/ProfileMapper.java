package com.lostfound.animalback.domain.profile;

import com.lostfound.animalback.business.profile.dto.ProfileInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import util.StringConverter;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {StringConverter.class})
public interface ProfileMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "user.email", target = "userEmail")
    @Mapping(expression = "java(StringConverter.bytesToString(profile.getImageData()))", target = "imageData")
    ProfileInfo toProfileInfo(Profile profile);

}