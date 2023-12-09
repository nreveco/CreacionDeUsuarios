package com.h2.nreveco.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class UserRs {
    private UUID id;
    private String created;
    private String modified;
    private String lastLogin;
    private String token;
    private Boolean isActive;
}
