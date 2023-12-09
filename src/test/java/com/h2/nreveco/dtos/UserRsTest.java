package com.h2.nreveco.dtos;

import com.h2.nreveco.fixture.UsersFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UserRsTest {

    private UsersFixture usersFixture = new UsersFixture();

    @Test
    public void testGetUserRs(){
        final UserRs userRs = usersFixture.getUserRs();
        userRs.setId(UUID.randomUUID());
        userRs.setCreated("08-12-2023");
        userRs.setModified("08-12-2023");
        userRs.setLastLogin("08-12-2023");
        userRs.setToken("sjfñsahfsdoñhf");
        userRs.setIsActive(true);
        Assertions.assertNotNull(userRs.getId());
        Assertions.assertNotNull(userRs.getCreated());
        Assertions.assertNotNull(userRs.getModified());
        Assertions.assertNotNull(userRs.getLastLogin());
        Assertions.assertNotNull(userRs.getToken());
        Assertions.assertTrue(userRs.getIsActive());
    }
}
