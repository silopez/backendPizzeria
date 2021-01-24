package com.pedidos.pizza.backend.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pedidos.pizza.backend.domain.entity.Pizza;

@Repository
public interface IPizzaRepository extends CrudRepository<Pizza, Long> {

}
