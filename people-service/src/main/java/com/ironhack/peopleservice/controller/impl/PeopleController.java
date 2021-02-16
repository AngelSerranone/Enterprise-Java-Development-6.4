package com.ironhack.peopleservice.controller.impl;

import com.ironhack.peopleservice.controller.interfaces.IPeopleController;
import com.ironhack.peopleservice.dto.PeopleDto;
import com.ironhack.peopleservice.model.People;
import com.ironhack.peopleservice.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PeopleController implements IPeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping("/new-people")
    @ResponseStatus(HttpStatus.CREATED)
    public People newPeople(@RequestBody @Valid PeopleDto peopleDto){
        People people = new People(
                peopleDto.getName(),
                peopleDto.getPhoneNumber()
        );
        return  peopleRepository.save(people);
    }

    @GetMapping("/people-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public People findByName(@PathVariable("name") String name){
        Optional<People> people = peopleRepository.findByName(name);
        if (people.isPresent()){
            return people.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The people you are looking for is in another dimension");
        }
    }

    @GetMapping("/people-by-phone/{phone}")
    @ResponseStatus(HttpStatus.OK)
    public People findByPhoneNumber(@PathVariable("phone") String phone){
        Optional<People> people = peopleRepository.findByPhoneNumber(phone);
        if (people.isPresent()){
            return people.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The people you are looking for is in another dimension");
        }
    }


}
