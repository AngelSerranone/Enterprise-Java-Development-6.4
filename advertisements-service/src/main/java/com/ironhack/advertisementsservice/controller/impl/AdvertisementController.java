package com.ironhack.advertisementsservice.controller.impl;
import com.ironhack.advertisementsservice.controller.interfaces.IAdvertisementController;
import com.ironhack.advertisementsservice.dto.AdvertisementDto;
import com.ironhack.advertisementsservice.model.Advertisement;
import com.ironhack.advertisementsservice.repository.AdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@RestController
public class AdvertisementController implements IAdvertisementController {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @PostMapping("/new-ad")
    @ResponseStatus(HttpStatus.CREATED)
    public Advertisement newAd(@RequestBody @Valid AdvertisementDto advertisementDto){
        Advertisement advertisement = new Advertisement(
                advertisementDto.getVendor(),
                advertisementDto.getText()
        );
        return advertisementRepository.save(advertisement);
    }

    @GetMapping("/random-ad")
    @ResponseStatus(HttpStatus.OK)
    public Advertisement getRandom() {
        List<Advertisement> adList = advertisementRepository.findAll();
        Random random = new Random();
        return adList.get(random.nextInt(adList.size()));
    }

}
