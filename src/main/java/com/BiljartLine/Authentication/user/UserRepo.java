package com.BiljartLine.Authentication.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<BiljartLineUser, Long> {
    Optional<BiljartLineUser> findByUsername(String username);
    boolean existsByUsername(String username);
}
