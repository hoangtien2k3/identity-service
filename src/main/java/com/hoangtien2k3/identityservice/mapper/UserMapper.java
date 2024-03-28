package com.hoangtien2k3.identityservice.mapper;

import com.hoangtien2k3.identityservice.dto.request.UserCreationRequest;
import com.hoangtien2k3.identityservice.dto.request.UserUpdateRequest;
import com.hoangtien2k3.identityservice.dto.response.UserResponse;
import com.hoangtien2k3.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserCreationRequest userCreationRequest);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest userUpdateRequest);

}
