package com.hoangtien2k3.identityservice.controller;

import com.hoangtien2k3.identityservice.constant.Constants;
import com.hoangtien2k3.identityservice.dto.response.ApiResponse;
import com.hoangtien2k3.identityservice.dto.request.UserCreationRequest;
import com.hoangtien2k3.identityservice.dto.request.UserUpdateRequest;
import com.hoangtien2k3.identityservice.dto.response.UserResponse;
import com.hoangtien2k3.identityservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;

    @PostMapping("/signup")
    private ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest userCreationRequest) {
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setMessage(Constants.SUCCESS);
        apiResponse.setResult(userService.createRequest(userCreationRequest));

        return apiResponse;
    }

    @GetMapping
    private ApiResponse<Object> getAllUser() {

        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> {
            log.info("Role: {}", grantedAuthority.getAuthority());
        });


        return ApiResponse.builder()
                .code(200)
                .message(Constants.SUCCESS)
                .result(userService.getAllUser())
                .build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<Object> getUserById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping("/{id}")
    private UserResponse updateUser(@RequestBody UserUpdateRequest userUpdateRequest,
                                    @PathVariable("id") String id) {
        return userService.updateUser(userUpdateRequest, id);
    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
    }

}
