package com.ironhack.exchangeservice.service.interfaces;

import com.ironhack.exchangeservice.classes.Price;
import com.ironhack.exchangeservice.dto.PriceDto;

import java.util.Currency;

public interface IExchangeService {

    Price convert(PriceDto priceDto, String currency);
}
