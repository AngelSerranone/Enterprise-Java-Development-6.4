package com.ironhack.edgepersonadvertisementsservice.client;

import com.ironhack.edgepersonadvertisementsservice.classes.Advertisement;
import com.ironhack.edgepersonadvertisementsservice.dto.AdvertisementDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;

@FeignClient("advertisement-service")
public interface AdvertisementClient {

    @PostMapping("/new-ad")
    @ResponseStatus(HttpStatus.CREATED)
    public Advertisement newAd(@RequestBody @Valid AdvertisementDto advertisementDto);

    @GetMapping("/random-ad")
    @ResponseStatus(HttpStatus.OK)
    public Advertisement getRandom();

}
