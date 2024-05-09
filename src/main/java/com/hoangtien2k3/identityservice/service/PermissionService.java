package com.hoangtien2k3.identityservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hoangtien2k3.identityservice.dto.request.PermissionRequest;
import com.hoangtien2k3.identityservice.dto.response.PermissionResponse;
import com.hoangtien2k3.identityservice.entity.Permission;
import com.hoangtien2k3.identityservice.mapper.PermissionMapper;
import com.hoangtien2k3.identityservice.repository.PermissionRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public List<PermissionResponse> getAll() {
        var permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
