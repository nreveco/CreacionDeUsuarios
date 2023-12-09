package com.h2.nreveco.controllers;

import com.h2.nreveco.dtos.UserRq;
import com.h2.nreveco.fixture.UsersFixture;
import com.h2.nreveco.services.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

@ExtendWith(SpringExtension.class)
public class UsersControllerTest {

    private UsersFixture usersFixture = new UsersFixture();
    @Mock
    private UsersService usersService;
    @InjectMocks
    private UsersController usersController;

    @Test
    void testRegisterUsers(){
        final UserRq userRq = usersFixture.getUserRq();
        final ResponseEntity responseEntity = new ResponseEntity(usersFixture.getUserRs(), HttpStatus.CREATED);
        Mockito.when(this.usersService.registerUsers(userRq)).thenReturn(responseEntity);
        Assertions.assertNotNull(this.usersController.registerUsers(userRq));
    }

    @Test
    void testGetuserByUuid(){
        final UUID uuid = UUID.randomUUID();
        final ResponseEntity responseEntity = new ResponseEntity(usersFixture.getUsers(), HttpStatus.OK);
        Mockito.when(this.usersService.getuserByUuid(uuid)).thenReturn(responseEntity);
        Assertions.assertNotNull(this.usersController.getuserByUuid(uuid));
    }
}
