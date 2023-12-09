package com.h2.nreveco.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PhonesRq {
    private String number;
    private String citycode;
    private String countrycode;
}
