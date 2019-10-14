package com.github.steed777.nextApplication.repos;

import com.github.steed777.nextApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}