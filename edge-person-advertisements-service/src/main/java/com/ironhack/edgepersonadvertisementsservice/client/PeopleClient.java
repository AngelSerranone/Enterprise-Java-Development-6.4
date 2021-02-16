package com.ironhack.edgepersonadvertisementsservice.client;

import com.ironhack.edgepersonadvertisementsservice.classes.People;
import com.ironhack.edgepersonadvertisementsservice.dto.PeopleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@FeignClient("people-service")
public interface PeopleClient {

    @PostMapping("/new-people")
    @ResponseStatus(HttpStatus.CREATED)
    public People newPeople(@RequestBody @Valid PeopleDto peopleDto);

    @GetMapping("/people-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public People findByName(@PathVariable("name") String name);

    @GetMapping("/people-by-phone/{phone}")
    @ResponseStatus(HttpStatus.OK)
    public People findByPhoneNumber(@PathVariable("phone") String phone);
}
