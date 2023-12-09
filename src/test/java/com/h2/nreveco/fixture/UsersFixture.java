package com.h2.nreveco.fixture;

import com.h2.nreveco.dtos.MessageRs;
import com.h2.nreveco.dtos.PhonesRq;
import com.h2.nreveco.dtos.UserRq;
import com.h2.nreveco.dtos.UserRs;
import com.h2.nreveco.models.Phones;
import com.h2.nreveco.models.Users;

import java.util.List;
import java.util.UUID;

public class UsersFixture {

    public UserRs getUserRs(){
        final UserRs userRs = new UserRs();
        userRs.setId(UUID.randomUUID());
        userRs.setCreated("07-12-2023");
        userRs.setModified("07-12-2023");
        userRs.setLastLogin("07-12-2023");
        userRs.setToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJucmV2ZWNvLnJzQGdtYWlsLmNvbSIsImlhdCI6MTcwMTk2ODQxNSwiZXhwIjoxNzAxOTcwMjE1fQ.lITLM1BXasemwNqaw5j7Lf0TKbkrHRa8SNXLojk5F_s");
        userRs.setIsActive(true);
        return  userRs;
    }

    public UserRq getUserRq(){
        final UserRq userRq = new UserRq();
        userRq.setName("Jose Canseco");
        userRq.setEmail("jose.canseco@gmail.com");
        userRq.setPassword("123456789");
        userRq.setPhones(List.of(getPhonesRq()));
        return  userRq;
    }

    public PhonesRq getPhonesRq(){
        final PhonesRq phones = new PhonesRq();
        phones.setNumber("11111111");
        phones.setCitycode("1");
        phones.setCountrycode("52");
        return phones;
    }

    public MessageRs getMessageRs(){
        final MessageRs messageRs = new MessageRs();
        messageRs.setMessage("El correo ya registrado");
        return  messageRs;
    }

    public Users getUsers(){
        final UUID id = UUID.randomUUID();
        final Users users = new Users();
        users.setId(id);
        users.setName("Jose canseco");
        users.setEmail("Jose.canseco@gmail.com");
        users.setPasdword("Mipass");
        users.setCreated("08-12-2023");
        users.setModified(null);
        users.setLastLogin("08-12-2023");
        users.setToken("sdkfjbjksdfbsdkfb");
        users.setIsActive(true);
        users.setPhones(List.of(getPhones()));
        return users;
    }

    public Users getUsers2(){
        final UUID id = UUID.randomUUID();
        final Users users = new Users();
        users.setId(id);
        users.setName("Jose canseco2");
        users.setEmail("Jose.canseco2@gmail.com");
        users.setPasdword("Mipass12");
        users.setCreated("08-12-2023");
        users.setModified(null);
        users.setLastLogin("08-12-2023");
        users.setToken("sdkfjbjksdfbsdkfb");
        users.setIsActive(true);
        users.setPhones(List.of(getPhones()));
        return users;
    }

    public Phones getPhones(){
        final Phones phones = new Phones();
        phones.setId(1);
        phones.setNumber("11111111");
        phones.setCityCode("1");
        phones.setCountryCode("11");
        phones.setCreated("08-12-2023");
        return phones;
    }


    public UserRq getUserRq2(){
        final UserRq userRq = new UserRq();
        userRq.setName("Jose Canseco");
        userRq.setEmail("jose.canseco2@gmail.com");
        userRq.setPassword("Mipass12");
        userRq.setPhones(List.of(getPhonesRq()));
        return  userRq;
    }

    public UserRq getUserRq3(){
        final UserRq userRq = new UserRq();
        userRq.setName("Jose Canseco");
        userRq.setEmail("jose.canseco2");
        userRq.setPassword("Mipass12");
        userRq.setPhones(List.of(getPhonesRq()));
        return  userRq;
    }

}
