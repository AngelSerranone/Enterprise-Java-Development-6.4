package com.ironhack.edgeproductservice.client;
import com.ironhack.edgeproductservice.classes.Price;
import com.ironhack.edgeproductservice.dto.PriceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("exchange-service")
public interface ExchangeClient {

    @PostMapping("/exchange/{currencyToConvert}")
    public Price convert(@RequestBody PriceDto priceDto, @PathVariable String currencyToConvert);
}
