package com.matheus.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.cursoudemy.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
