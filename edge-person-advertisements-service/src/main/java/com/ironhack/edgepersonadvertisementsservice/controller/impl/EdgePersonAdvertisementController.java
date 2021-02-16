package com.ironhack.edgepersonadvertisementsservice.controller.impl;

import com.ironhack.edgepersonadvertisementsservice.classes.Advertisement;
import com.ironhack.edgepersonadvertisementsservice.classes.People;
import com.ironhack.edgepersonadvertisementsservice.client.AdvertisementClient;
import com.ironhack.edgepersonadvertisementsservice.client.PeopleClient;
import com.ironhack.edgepersonadvertisementsservice.controller.interfaces.IEdgePersonAdvertisementController;
import com.ironhack.edgepersonadvertisementsservice.dto.AdvertisementDto;
import com.ironhack.edgepersonadvertisementsservice.dto.PeopleDto;
import com.ironhack.edgepersonadvertisementsservice.dto.PersonWithAdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class EdgePersonAdvertisementController implements IEdgePersonAdvertisementController {

    @Autowired
    private AdvertisementClient advertisementClient;
    @Autowired
    private PeopleClient peopleClient;

    @GetMapping("/person-by-name/{name}")
    @ResponseStatus(HttpStatus.OK)
    public PersonWithAdDto getByName(@PathVariable("name") String name){

        Advertisement ad = advertisementClient.getRandom();
        People people = peopleClient.findByName(name);

        PersonWithAdDto personWithAdDto = new PersonWithAdDto();
        personWithAdDto.setName(name);
        personWithAdDto.setPhoneNumber(people.getPhoneNumber());
        personWithAdDto.setVendor(ad.getVendor());
        personWithAdDto.setText(ad.getText());

        return personWithAdDto;
    }

    @GetMapping("/person-by-phone/{phoneNumber}")
    @ResponseStatus(HttpStatus.OK)
    public PersonWithAdDto getByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber){

        Advertisement ad = advertisementClient.getRandom();
        People people = peopleClient.findByPhoneNumber(phoneNumber);

        PersonWithAdDto personWithAdDto = new PersonWithAdDto();
        personWithAdDto.setName(people.getName());
        personWithAdDto.setPhoneNumber(phoneNumber);
        personWithAdDto.setVendor(ad.getVendor());
        personWithAdDto.setText(ad.getText());

        return personWithAdDto;

    }

    @PostMapping("/new-people-created")
    @ResponseStatus(HttpStatus.CREATED)
    public People createPeople(@RequestBody @Valid PeopleDto peopleDto){
        return peopleClient.newPeople(peopleDto);
    }

    @PostMapping("/new-ad-created")
    @ResponseStatus(HttpStatus.CREATED)
    public Advertisement createAd(@RequestBody @Valid AdvertisementDto advertisementDto){
        return advertisementClient.newAd(advertisementDto);
    }
}
