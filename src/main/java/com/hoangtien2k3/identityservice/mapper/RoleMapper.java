package com.hoangtien2k3.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hoangtien2k3.identityservice.dto.request.RoleRequest;
import com.hoangtien2k3.identityservice.dto.response.RoleResponse;
import com.hoangtien2k3.identityservice.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
