package com.h2.nreveco.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;

    /** name */
    @Column(name = "NAME")
    private String name;

    /** email */
    @Column(name = "EMAIL")
    private String email;

    /** pasdword */
    @Column(name = "PASDWORD")
    private String pasdword;

    /** created */
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "CREATED")
    private String created;

    /** modified */
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "MODIFIED")
    private String modified;

    /** lastLogin */
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "LAST_LOGIN")
    private String lastLogin;

    /** token */
    @Column(name = "TOKEN")
    private String token;

    /** isActive */
    @Column(name = "ISACTIVE")
    private Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "USER_ID")
    private List<Phones> phones = new ArrayList<>();

}
