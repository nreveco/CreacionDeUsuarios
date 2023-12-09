package com.h2.nreveco.models;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Assertions;
import com.h2.nreveco.fixture.UsersFixture;
import com.h2.nreveco.repositories.UsersRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@DataJpaTest
public class    UsersTest {
    @Autowired
    private TestEntityManager entityManager;

    private Users users;

    private UsersFixture usersFixture = new UsersFixture();

    @Autowired
    private UsersRespository usersRespository;


    @Test
    @Rollback(value = true)
    public void saveUsers() {
        users = usersFixture.getUsers();
        Users savedUsersData = usersRespository.save(users);

        Assertions.assertNotNull(savedUsersData.getId());
        assertThat(savedUsersData.getName()).isEqualTo("Jose canseco");
        assertThat(savedUsersData.getEmail()).isEqualTo("Jose.canseco@gmail.com");
        assertThat(savedUsersData.getPasdword()).isEqualTo("Mipass");
        assertThat(savedUsersData.getCreated()).isEqualTo("08-12-2023");
        assertThat(savedUsersData.getModified()).isEqualTo(null);
        assertThat(savedUsersData.getLastLogin()).isEqualTo("08-12-2023");
        assertThat(savedUsersData.getToken()).isEqualTo("sdkfjbjksdfbsdkfb");
        Assertions.assertTrue(savedUsersData.getIsActive());
        Assertions.assertNotNull(savedUsersData.getPhones());
        entityManager.flush();
    }

    @Test
    @Rollback(value = true)
    public void saveUsersConstructor() {
        users = usersFixture.getUsers();
        Users usersSave = new Users(users.getId(),users.getName(), users.getEmail(), users.getPasdword(), users.getCreated()
                , users.getModified(), users.getLastLogin(), users.getToken(), users.getIsActive(), users.getPhones());
        Users savedUsersData = usersRespository.save(usersSave);

        Assertions.assertNotNull(savedUsersData.getId());
        assertThat(savedUsersData.getName()).isEqualTo("Jose canseco");
        assertThat(savedUsersData.getEmail()).isEqualTo("Jose.canseco@gmail.com");
        assertThat(savedUsersData.getPasdword()).isEqualTo("Mipass");
        assertThat(savedUsersData.getCreated()).isEqualTo("08-12-2023");
        assertThat(savedUsersData.getModified()).isEqualTo(null);
        assertThat(savedUsersData.getLastLogin()).isEqualTo("08-12-2023");
        assertThat(savedUsersData.getToken()).isEqualTo("sdkfjbjksdfbsdkfb");
        Assertions.assertTrue(savedUsersData.getIsActive());
        Assertions.assertNotNull(savedUsersData.getPhones());
        entityManager.flush();
    }

}
