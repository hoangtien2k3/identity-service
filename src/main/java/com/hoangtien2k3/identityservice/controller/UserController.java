package com.hoangtien2k3.identityservice.controller;

import com.hoangtien2k3.identityservice.dto.UserCreationRequest;
import com.hoangtien2k3.identityservice.dto.UserUpdateRequest;
import com.hoangtien2k3.identityservice.entity.User;
import com.hoangtien2k3.identityservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    private User createUser(@RequestBody UserCreationRequest userCreationRequest) {
        return userService.createRequest(userCreationRequest);
    }

    @GetMapping
    private List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    private User getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    private User updateUser(@RequestBody UserUpdateRequest userUpdateRequest,
                            @PathVariable("id") String id) {
        return userService.updateUser(userUpdateRequest, id);
    }

    @DeleteMapping("/{id}")
    private void deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
    }

}
