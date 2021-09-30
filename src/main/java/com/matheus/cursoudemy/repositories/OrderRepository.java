package com.matheus.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.cursoudemy.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
