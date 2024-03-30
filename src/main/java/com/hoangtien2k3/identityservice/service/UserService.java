package com.hoangtien2k3.identityservice.service;

import com.hoangtien2k3.identityservice.dto.request.UserCreationRequest;
import com.hoangtien2k3.identityservice.dto.request.UserUpdateRequest;
import com.hoangtien2k3.identityservice.dto.response.UserResponse;
import com.hoangtien2k3.identityservice.entity.User;
import com.hoangtien2k3.identityservice.enums.Role;
import com.hoangtien2k3.identityservice.exception.payload.AppException;
import com.hoangtien2k3.identityservice.exception.EnumConfig.ErrorCode;
import com.hoangtien2k3.identityservice.mapper.UserMapper;
import com.hoangtien2k3.identityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;

    public UserResponse createRequest(UserCreationRequest userCreationRequest) {
        if (userRepository.existsByUsername(userCreationRequest.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

        User user = userMapper.toUser(userCreationRequest);
        user.setPassword(passwordEncoder.encode(userCreationRequest.getPassword()));

        HashSet<String> role = new HashSet<>();
        role.add(Role.USER.name());

        user.setRoles(role);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<User> getAllUser() {
        return userRepository.findAllUser();
    }

    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND)));
    }

    public UserResponse updateUser(UserUpdateRequest userUpdateRequest, String id) {
        User currentUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        userMapper.updateUser(currentUser, userUpdateRequest);

        return userMapper.toUserResponse(userRepository.save(currentUser));
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

}
