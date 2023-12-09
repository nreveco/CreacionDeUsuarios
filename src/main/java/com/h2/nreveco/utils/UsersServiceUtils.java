package com.h2.nreveco.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsersServiceUtils {

    private static final String SECRET = "38045F34RHN3U4HR4938H9348HR9384HR9834HR9834HR8934HH3R98H4R";
    /**
     * Create
     *
     * @param claims {@link Map}
     * @param userEmail {@link String}
     * @return string {@link String}
     */
    public String createToken(Map<String, Object> claims, String userEmail) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userEmail)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(this.getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    /**
     * Return key
     *
     * @return key {@link Key}
     */
    public Key getSignKey() {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Allows to validate an email.
     *
     * @param email {@link String}
     * @return boolean
     */
    public boolean validateEmail(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    /**
     * Allows to validate an password.
     *
     * @param password {@link String}
     * @return boolean
     */
    public boolean validatePassdword(String password){
        Pattern pattern = Pattern
                .compile("^([A-Z])([a-z]+)([0-9]{2})$");
        Matcher mather = pattern.matcher(password);
        return mather.find();
    }
}
