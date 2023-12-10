package com.h2.nreveco.services.impl;

import com.h2.nreveco.dtos.MessageRs;
import com.h2.nreveco.dtos.PhonesRq;
import com.h2.nreveco.dtos.UserRq;
import com.h2.nreveco.dtos.UserRs;
import com.h2.nreveco.models.Phones;
import com.h2.nreveco.models.Users;
import com.h2.nreveco.repositories.PhonesRespository;
import com.h2.nreveco.repositories.UsersRespository;
import com.h2.nreveco.services.UsersService;
import com.h2.nreveco.utils.UsersServiceUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRespository usersRespository;

    private final PhonesRespository phonesRespository;

    public static final String SECRET = "38045F34RHN3U4HR4938H9348HR9384HR9834HR9834HR8934HH3R98H4R";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private static String message;

    private final UsersServiceUtils usersServiceUtils = new UsersServiceUtils();

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity registerUsers(UserRq userRq) {

        try{

            if(!this.validateParams(userRq)){
                throw new Exception(this.message);
            }

            ZonedDateTime zonedDateTime = ZonedDateTime.now();
            final var date = zonedDateTime.format(formatter);
            Map<String, Object> claims = new HashMap<>();

            final Users users = new Users();
            users.setName(userRq.getName());
            users.setEmail(userRq.getEmail());
            users.setPasdword(userRq.getPassword());
            users.setCreated(date);
            users.setLastLogin(date);
            users.setToken(this.usersServiceUtils.createToken(claims, userRq.getEmail()));
            users.setIsActive(true);
            Users userSaved = this.usersRespository.save(users);
            this.savePhonesUser(userRq, userSaved.getId(), date);

            return new ResponseEntity(this.getUserRs(userSaved), HttpStatus.CREATED);
        } catch (Exception ex) {

            MessageRs messageRs = new MessageRs();
            messageRs.setMessage(ex.getMessage());
            return new ResponseEntity(messageRs, HttpStatus.BAD_REQUEST);

        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResponseEntity getuserByUuid(UUID id) {
        try{
            return new ResponseEntity(this.usersRespository.findById(id), HttpStatus.OK);
        } catch (Exception ex){
            MessageRs messageRs = new MessageRs();
            messageRs.setMessage(ex.getMessage());
            return new ResponseEntity(messageRs, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Register phones of a user
     *
     * @param userRq {@link UserRq}
     * @param id {@link UUID}
     * @param date {@link String}
     */
    private void savePhonesUser(UserRq userRq, UUID id, String date){
        for (PhonesRq phone : userRq.getPhones() ) {
            final Phones phones = new Phones();
            phones.setNumber(phone.getNumber());
            phones.setCityCode(phone.getCitycode());
            phones.setCountryCode(phone.getCountrycode());
            phones.setUserId(id);
            phones.setCreated(date);
            this.phonesRespository.save(phones);
        }
    }

    /**
     * Returns the response dto UserRs
     *
     * @param userSaved {@link Users}
     * @return userRs {@link UserRs}
     */
    private UserRs getUserRs(Users userSaved){
        final UserRs userRs = new UserRs();
        userRs.setId(userSaved.getId());
        userRs.setCreated(userSaved.getCreated());
        userRs.setModified(userSaved.getModified());
        userRs.setLastLogin(userSaved.getLastLogin());
        userRs.setToken(userSaved.getToken());
        userRs.setIsActive(userSaved.getIsActive());
        return userRs;
    }

    /**
     * Validate the parameters for creating a user, based on business rules.
     *
     * @param userRq {@link UserRq}
     * @return boolean
     */
    private boolean validateParams(UserRq userRq){
        boolean isValid = true;

        if(!this.usersServiceUtils.validateEmail(userRq.getEmail())){
            this.message = "El correo no es valido";
            isValid = false;
        }else {
            Optional<Users> userFind =this.usersRespository.findByEmail(userRq.getEmail());
            if(userFind.isPresent()){
                this.message = "El correo ya registrado";
                isValid = false;
            }

            if(!this.usersServiceUtils.validatePassdword(userRq.getPassword())){
                this.message = "La password no es valida";
                isValid = false;
            }
        }
        return isValid;
    }
}
