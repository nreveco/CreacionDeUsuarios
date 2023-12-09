package com.h2.nreveco.dtos;

import com.h2.nreveco.fixture.UsersFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MessageRsTest {

    private UsersFixture usersFixture = new UsersFixture();

    @Test
    public void testGetMessageRs(){
        final MessageRs messageRs = usersFixture.getMessageRs();
        messageRs.setMessage("Error an register user");
        Assertions.assertNotNull(messageRs.getMessage());
    }
}
