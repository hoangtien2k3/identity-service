package com.hoangtien2k3.identityservice.mapper;

import org.mapstruct.Mapper;

import com.hoangtien2k3.identityservice.dto.request.PermissionRequest;
import com.hoangtien2k3.identityservice.dto.response.PermissionResponse;
import com.hoangtien2k3.identityservice.entity.Permission;

@Mapper(componentModel = "spring")
public interface PermissionMapper {
    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
