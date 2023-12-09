package com.h2.nreveco.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PHONES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phones {

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    /** number */
    @Column(name = "NUMBER")
    private String number;

    /** cityCode */
    @Column(name = "CITY_CODE")
    private String cityCode;

    /** countryCode */
    @Column(name = "COUNTRY_CODE")
    private String countryCode;

    /** userId */
    @Column(name = "USER_ID")
    private UUID userId;

    /** created */
    @Column(name = "CREATED")
    private String created;
}
