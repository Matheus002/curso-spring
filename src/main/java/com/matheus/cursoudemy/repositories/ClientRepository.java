package com.matheus.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.cursoudemy.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
