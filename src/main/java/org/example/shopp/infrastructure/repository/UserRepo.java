package org.example.shopp.infrastructure.repository;

import org.example.shopp.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    User findByFirstName(String firstName);
}
