package com.matheus.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.cursoudemy.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
