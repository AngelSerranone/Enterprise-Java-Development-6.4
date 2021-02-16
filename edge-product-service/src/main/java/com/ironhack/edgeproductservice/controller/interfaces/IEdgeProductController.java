package com.ironhack.edgeproductservice.controller.interfaces;

import com.ironhack.edgeproductservice.classes.StoreProduct;

import java.util.Currency;

public interface IEdgeProductController {

    StoreProduct productInOtherCurrency(Integer productId, Currency currency);
}
