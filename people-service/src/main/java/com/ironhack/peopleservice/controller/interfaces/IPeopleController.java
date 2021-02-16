package com.ironhack.peopleservice.controller.interfaces;

import com.ironhack.peopleservice.dto.PeopleDto;
import com.ironhack.peopleservice.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

public interface IPeopleController {

    public People newPeople(PeopleDto peopleDto);
    public People findByName(String name);
    public People findByPhoneNumber(String phone);
}
