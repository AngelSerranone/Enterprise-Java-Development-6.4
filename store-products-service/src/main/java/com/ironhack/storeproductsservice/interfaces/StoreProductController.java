package com.ironhack.storeproductsservice.interfaces;

import com.ironhack.storeproductsservice.model.StoreProduct;
import org.springframework.web.bind.annotation.PathVariable;

public interface StoreProductController {

    public StoreProduct getProduct(Integer id);
}
