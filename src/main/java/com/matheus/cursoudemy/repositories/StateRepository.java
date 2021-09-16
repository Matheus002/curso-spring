package com.matheus.cursoudemy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matheus.cursoudemy.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
