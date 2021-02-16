package com.ironhack.ShippingOrders.controller.impl;
import com.ironhack.ShippingOrders.client.ProductClient;
import com.ironhack.ShippingOrders.controller.Dto.ProductDto;
import com.ironhack.ShippingOrders.controller.Dto.ShippingOrderDto;
import com.ironhack.ShippingOrders.model.Product;
import com.ironhack.ShippingOrders.model.ShippingOrder;
import com.ironhack.ShippingOrders.repository.ShippingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ShippingOrderController {

    @Autowired
    private ShippingOrderRepository shippingOrderRepository;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private ProductClient productClient;


    @GetMapping("/shipping-order/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ShippingOrder getShippingOrderById(@PathVariable Integer id) {
        Optional<ShippingOrder> shippingOrder = shippingOrderRepository.findById(id);
        if (shippingOrder.isPresent()) {
            return shippingOrder.get();
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "The shipping order you are looking for doesn't exists");
        }
    }

    @PostMapping("/shipping-order")
    @ResponseStatus(HttpStatus.CREATED)
    public ShippingOrder registerProduct(@RequestBody @Valid ShippingOrderDto shippingOrderDto) {

        System.out.println("paso1");
        Product product = productClient.getProductById(shippingOrderDto.getProductId());

        System.out.println("paso2");
        if (product.getInventoryCount() < shippingOrderDto.getQuantity()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "We dont have enough stock");
        }
        product.setProductId(shippingOrderDto.getProductId());
        product.setInventoryCount(product.getInventoryCount()-shippingOrderDto.getQuantity());

        System.out.println("paso3");

        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(product.getProductName());
        productDto.setProductPrice(product.getProductPrice());
        productDto.setInventoryCount(product.getInventoryCount());

        System.out.println("paso4");

        productClient.updateProduct(productDto.getProductId(), productDto);

        System.out.println("paso5");

        ShippingOrder shippingOrder = new ShippingOrder();
        shippingOrder.setProductId(shippingOrderDto.getProductId());
        shippingOrder.setQuantity(shippingOrderDto.getQuantity());

        return shippingOrderRepository.save(shippingOrder);

    }
}
