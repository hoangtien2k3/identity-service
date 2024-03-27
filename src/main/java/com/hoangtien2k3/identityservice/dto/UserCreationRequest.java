package com.hoangtien2k3.identityservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UserCreationRequest {
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
}
