package com.hoangtien2k3.identityservice.controller;

import com.hoangtien2k3.identityservice.config.Constants;
import com.hoangtien2k3.identityservice.dto.request.AuthenticationRequest;
import com.hoangtien2k3.identityservice.dto.response.ApiResponse;
import com.hoangtien2k3.identityservice.dto.response.AuthenticationResponse;
import com.hoangtien2k3.identityservice.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .code(200)
                .message(Constants.SUCCESS)
                .result(result)
                .build();
    }

}
