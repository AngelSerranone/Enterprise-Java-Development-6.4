package com.ironhack.exchangeservice.controller.interfaces;

import com.ironhack.exchangeservice.classes.Price;
import com.ironhack.exchangeservice.dto.PriceDto;

import java.util.Currency;

public interface IExchangeController {

    public Price convert(PriceDto priceDto, String currencyToConvert);
}
