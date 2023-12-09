package com.h2.nreveco.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class UserRq {

    private String name;
    private String email;
    private String password;
    private List<PhonesRq> phones;
}
