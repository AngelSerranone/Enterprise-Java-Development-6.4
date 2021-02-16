package com.ironhack.exchangeservice.controller.impl;

import com.ironhack.exchangeservice.classes.Price;
import com.ironhack.exchangeservice.controller.interfaces.IExchangeController;
import com.ironhack.exchangeservice.dto.PriceDto;
import com.ironhack.exchangeservice.service.interfaces.IExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExchangeController implements IExchangeController {

    @Autowired
    private IExchangeService exchangeService;

    @PostMapping("/exchange/{currencyToConvert}")
    public Price convert(@RequestBody PriceDto priceDto, @PathVariable String currencyToConvert){
        return exchangeService.convert(priceDto, currencyToConvert);
    }
}
