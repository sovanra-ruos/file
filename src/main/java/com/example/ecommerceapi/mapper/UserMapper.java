package com.example.ecommerceapi.mapper;

import com.example.ecommerceapi.domain.User;
import com.example.ecommerceapi.feature.user.dto.UserProfileResponse;
import com.example.ecommerceapi.feature.user.dto.UserRequest;
import com.example.ecommerceapi.feature.user.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "role", source = "role.name")
    @Mapping(target = "is_Deleted", source = "deleted")
    UserResponse toUserResponse(User user);
    @Mapping(target = "role.name", source = "roleName")
    User toUser(UserRequest userRequest);
    @Mapping(target = "orders", source = "orders")
    UserProfileResponse toUserProfileResponse(User user);


    default String map(List<String> value) {
        return String.join(",", value);
    }

}
