package com.h2.nreveco.repositories;

import com.h2.nreveco.models.Phones;
import com.h2.nreveco.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhonesRespository extends JpaRepository<Phones, Integer> {

}
