package com.ironhack.peopleservice.repository;
import com.ironhack.peopleservice.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<People, Integer> {

    public Optional<People> findByName(String name);
    public Optional<People> findByPhoneNumber(String phone);
}
