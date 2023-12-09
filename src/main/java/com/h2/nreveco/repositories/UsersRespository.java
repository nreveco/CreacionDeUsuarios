package com.h2.nreveco.repositories;

import com.h2.nreveco.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsersRespository extends JpaRepository<Users, UUID> {

    Optional<Users> findByEmail(String email);
}
