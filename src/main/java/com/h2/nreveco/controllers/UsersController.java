package com.h2.nreveco.controllers;

import com.h2.nreveco.dtos.UserRq;
import com.h2.nreveco.dtos.UserRs;
import com.h2.nreveco.models.Users;
import com.h2.nreveco.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "Api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsersController {

    private final UsersService usersService;

    @Operation(summary = "Register users", description = "Register users in the system. Users object response contains id: UUID)\n" +
            "created: user creation date\n" +
            "modified: date of last user update\n" +
            "last_login: of the last login (in the case of a new user, it will coincide with the creation date)\n" +
            "token: JWT API access token\n" +
            "isactive: Indicates if the user is still enabled within the system.", tags = { "Register users by receiving parameters" })
    @ApiResponses({@ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = UserRs.class), mediaType = "application/json") }), @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }), @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/register")
    public ResponseEntity registerUsers(@RequestBody final UserRq userRq) {
        return usersService.registerUsers(userRq);
    }

    @Operation(summary = "Get user", description = "Obtains a user registered in the system. The service response is a users model", tags = { "Get a user by UUID identifier" })
    @ApiResponses({@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Users.class), mediaType = "application/json") }), @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }), @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @ResponseStatus(value = HttpStatus.CREATED)
    @GetMapping("/find/{uuid}")
    public ResponseEntity getuserByUuid(@PathVariable final UUID uuid){
        return usersService.getuserByUuid(uuid);
    }

}
