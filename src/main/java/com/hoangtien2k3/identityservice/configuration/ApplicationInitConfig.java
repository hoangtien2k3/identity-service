package com.hoangtien2k3.identityservice.configuration;

import com.hoangtien2k3.identityservice.entity.User;
import com.hoangtien2k3.identityservice.enums.Role;
import com.hoangtien2k3.identityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@Slf4j
@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository repository) {
        return args -> {
            if (repository.findByUsername("admin").isEmpty()) {
                var role = new HashSet<String>();
                role.add(Role.ADMIN.name());
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .roles(role)
                        .build();

                repository.save(user);
                log.warn("admin user has bean create with default password: admin, please change it");
            }
        };
    }

}
