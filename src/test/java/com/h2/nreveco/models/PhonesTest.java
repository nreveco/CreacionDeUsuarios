package com.h2.nreveco.models;

import com.h2.nreveco.fixture.UsersFixture;
import com.h2.nreveco.repositories.PhonesRespository;
import com.h2.nreveco.repositories.UsersRespository;
import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PhonesTest {
    @Autowired
    private TestEntityManager entityManager;

    private Phones phones;

    private Users users;

    private UsersFixture usersFixture = new UsersFixture();

    @Autowired
    private PhonesRespository phonesRespository;

    @Autowired
    private UsersRespository usersRespository;


    @Test
    @Rollback(value = true)
    public void savePhones() {

        users = usersFixture.getUsers();
        Users savedUsersData = usersRespository.save(users);

        phones = usersFixture.getPhones();
        phones.setUserId(savedUsersData.getId());
        Phones savedPhonesData = phonesRespository.save(phones);

        Assertions.assertNotNull(savedPhonesData.getId());
        assertThat(savedPhonesData.getUserId()).isEqualTo(savedUsersData.getId());
        assertThat(savedPhonesData.getNumber()).isEqualTo("11111111");
        assertThat(savedPhonesData.getCityCode()).isEqualTo("1");
        assertThat(savedPhonesData.getCountryCode()).isEqualTo("11");
        assertThat(savedPhonesData.getCreated()).isEqualTo("08-12-2023");
        entityManager.flush();
    }

    @Test
    @Rollback(value = true)
    public void savePhonesConstructor() {

        users = usersFixture.getUsers();
        Users savedUsersData = usersRespository.save(users);

        phones = usersFixture.getPhones();
        Phones phonesSave = new Phones(phones.getId(), phones.getNumber(), phones.getCityCode(), phones.getCountryCode(), savedUsersData.getId(), phones.getCreated());
        Phones savedPhonesData = phonesRespository.save(phonesSave);

        Assertions.assertNotNull(savedPhonesData.getId());
        assertThat(savedPhonesData.getNumber()).isEqualTo("11111111");
        assertThat(savedPhonesData.getCityCode()).isEqualTo("1");
        assertThat(savedPhonesData.getCountryCode()).isEqualTo("11");
        assertThat(savedPhonesData.getCreated()).isEqualTo("08-12-2023");
        entityManager.flush();
    }

}
