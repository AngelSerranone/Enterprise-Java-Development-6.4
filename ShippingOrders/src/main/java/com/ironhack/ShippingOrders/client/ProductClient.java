package com.ironhack.ShippingOrders.client;
import com.ironhack.ShippingOrders.controller.Dto.ProductDto;
import com.ironhack.ShippingOrders.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@FeignClient("products")
public interface ProductClient {

    @GetMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Integer id);

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product registerProduct(@RequestBody @Valid ProductDto productDto);

    @PutMapping("/product-update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product updateProduct(@PathVariable("id") Integer id, @RequestBody @Valid ProductDto productDto);
}
