package com.ironhack.storeproductsservice.repository;
import com.ironhack.storeproductsservice.model.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreProductRepository extends JpaRepository<StoreProduct, Integer> {
}
