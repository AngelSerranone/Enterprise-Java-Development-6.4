package com.ironhack.advertisementsservice.controller.interfaces;

import com.ironhack.advertisementsservice.dto.AdvertisementDto;
import com.ironhack.advertisementsservice.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestBody;

public interface IAdvertisementController {

    public Advertisement newAd(AdvertisementDto advertisementDto);
    public Advertisement getRandom();
}
