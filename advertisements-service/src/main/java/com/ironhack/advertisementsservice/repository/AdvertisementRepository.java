package com.ironhack.advertisementsservice.repository;

import com.ironhack.advertisementsservice.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

}
