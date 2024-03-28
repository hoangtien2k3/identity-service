package com.hoangtien2k3.identityservice.repository;

import com.hoangtien2k3.identityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u")
    List<User> findAllUser();

    @Query("SELECT u FROM User u WHERE u.id = :id")
    Optional<User> findById(@Param("id") String id);

    @Modifying
    @Query("DELETE FROM User u WHERE u.id = :id")
    void deleteById(@Param("id") String id);
}
