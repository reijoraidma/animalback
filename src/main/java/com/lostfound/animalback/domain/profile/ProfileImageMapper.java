package com.lostfound.animalback.domain.profile;

import org.mapstruct.*;
import util.StringConverter;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {StringConverter.class})
public interface ProfileImageMapper {

    @Mapping(expression = "java(StringConverter.stringToBytes(profileInfo.getImageData()))", target = "imageData")
    byte[] toProfileImage(byte[] profileInfo);
}