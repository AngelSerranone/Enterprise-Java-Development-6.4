package com.ironhack.edgepersonadvertisementsservice.controller.interfaces;

import com.ironhack.edgepersonadvertisementsservice.classes.Advertisement;
import com.ironhack.edgepersonadvertisementsservice.classes.People;
import com.ironhack.edgepersonadvertisementsservice.dto.AdvertisementDto;
import com.ironhack.edgepersonadvertisementsservice.dto.PeopleDto;
import com.ironhack.edgepersonadvertisementsservice.dto.PersonWithAdDto;

public interface IEdgePersonAdvertisementController {

    public PersonWithAdDto getByName(String name);
    public PersonWithAdDto getByPhoneNumber(String phoneNumber);
    public People createPeople(PeopleDto peopleDto);
    public Advertisement createAd(AdvertisementDto advertisementDto);

}
