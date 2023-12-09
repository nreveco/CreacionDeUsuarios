package com.h2.nreveco.dtos;

import com.h2.nreveco.fixture.UsersFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserRqTest {

    private UsersFixture usersFixture = new UsersFixture();

    @Test
    public void testGetUserRs(){
        final UserRq userRq = usersFixture.getUserRq();
        userRq.setName("Jose Canseco1");
        userRq.setEmail("jose.canseco1@gmail.com");
        userRq.setPassword("11111111");
        userRq.setPhones(List.of(usersFixture.getPhonesRq()));

        Assertions.assertNotNull(userRq.getName());
        Assertions.assertNotNull(userRq.getEmail());
        Assertions.assertNotNull(userRq.getPassword());
        Assertions.assertNotNull(userRq.getPhones());
    }
}
