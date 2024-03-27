package com.hoangtien2k3.identityservice.service;

import com.hoangtien2k3.identityservice.dto.UserCreationRequest;
import com.hoangtien2k3.identityservice.dto.UserUpdateRequest;
import com.hoangtien2k3.identityservice.entity.User;
import com.hoangtien2k3.identityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createRequest(UserCreationRequest userCreationRequest) {

        User user = new User();
        user.setUsername(userCreationRequest.getUsername());
        user.setPassword(userCreationRequest.getPassword());
        user.setFirstname(userCreationRequest.getFirstname());
        user.setLastname(userCreationRequest.getLastname());
        user.setDob(userCreationRequest.getDob());

        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAllUser();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found Exception."));
    }

    public User updateUser(UserUpdateRequest userUpdateRequest, String id) {
        User currentUser = getUserById(id);

        currentUser.setPassword(userUpdateRequest.getPassword());
        currentUser.setFirstname(userUpdateRequest.getFirstname());
        currentUser.setLastname(userUpdateRequest.getLastname());
        currentUser.setDob(userUpdateRequest.getDob());

        return userRepository.save(currentUser);
    }

    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

}
