package com.h2.nreveco.services;

import com.h2.nreveco.dtos.UserRq;
import com.h2.nreveco.fixture.UsersFixture;
import com.h2.nreveco.models.Phones;
import com.h2.nreveco.models.Users;
import com.h2.nreveco.repositories.PhonesRespository;
import com.h2.nreveco.repositories.UsersRespository;
import com.h2.nreveco.services.impl.UsersServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.UUID;

public class UsersServiceImplTest {

    private UsersFixture usersFixture = new UsersFixture();

    @Mock
    private UsersRespository usersRespository;

    @Mock
    private PhonesRespository phonesRespository;

    @Mock
    private UsersService usersService;

    @InjectMocks
    private UsersServiceImpl usersServiceImpl;

    @SuppressWarnings("deprecation")
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Rollback(value = true)
    @Test
    void testRegisterUsers(){
        final Users users = usersFixture.getUsers2();
        final Phones phones = usersFixture.getPhones();
        Mockito.when(usersRespository.save(users)).thenReturn(usersFixture.getUsers2());
        Mockito.when(phonesRespository.save(phones)).thenReturn(usersFixture.getPhones());
        final UserRq userRq = usersFixture.getUserRq2();
        Assertions.assertNotNull(usersServiceImpl.registerUsers(userRq));
    }

    @Rollback(value = true)
    @Test
    void testRegisterUsersValidateParams(){
        final Users users = usersFixture.getUsers();
        Mockito.when(usersRespository.save(users)).thenReturn(usersFixture.getUsers2());
        final UserRq userRq = usersFixture.getUserRq();
        Assertions.assertNotNull(usersServiceImpl.registerUsers(userRq));
    }

    @Test
    void testRegisterUsersValidateParams2(){
        final UserRq userRq = usersFixture.getUserRq3();
        Assertions.assertNotNull(usersServiceImpl.registerUsers(userRq));
    }

    @Test
    void testGetUserByUuid(){
        final Users users = usersFixture.getUsers2();
        Assertions.assertNotNull(usersServiceImpl.getuserByUuid(users.getId()));
    }

    @Test
    void testGetUserByUuidException(){
        Assertions.assertNotNull(usersServiceImpl.getuserByUuid(null));
    }

}
