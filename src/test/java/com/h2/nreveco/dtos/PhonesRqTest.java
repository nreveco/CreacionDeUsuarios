package com.h2.nreveco.dtos;

import com.h2.nreveco.fixture.UsersFixture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhonesRqTest {

    private UsersFixture usersFixture = new UsersFixture();

    @Test
    public void testGetPhonesRq(){
        final PhonesRq phonesRq = usersFixture.getPhonesRq();
        phonesRq.setNumber("11111111");
        phonesRq.setCitycode("1");
        phonesRq.setCountrycode("11");
        Assertions.assertNotNull(phonesRq.getNumber());
        Assertions.assertNotNull(phonesRq.getCitycode());
        Assertions.assertNotNull(phonesRq.getCountrycode());
    }
}
