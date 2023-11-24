package com.mikko.mmback.mappers;

import com.mikko.mmback.dtos.SignUpDto;
import com.mikko.mmback.entities.User;
import com.mikko.mmback.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper (componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);

    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDto signUpDto);

}
