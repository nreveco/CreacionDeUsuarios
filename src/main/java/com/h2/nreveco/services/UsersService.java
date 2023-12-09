package com.h2.nreveco.services;

import com.h2.nreveco.dtos.UserRq;
import com.h2.nreveco.dtos.UserRs;
import com.h2.nreveco.models.Users;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

public interface UsersService {

    /**
     * Register a user and return a response of type Dto UserRs
     * @param userRq {@link UserRq}
     * @return user {@link UserRs}
     */
    ResponseEntity registerUsers(UserRq userRq);

    /**
     * Get a user and return a response of type User Model
     * @param id {@link UUID}
     * @return user {@link ResponseEntity}
     */
    ResponseEntity getuserByUuid(UUID id);
}
