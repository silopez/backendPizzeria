package com.pedidos.pizza.backend.domain.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pedidos.pizza.backend.domain.entity.Adicion;

@Repository
public interface IAdicionRepository extends CrudRepository<Adicion, Long> {

	@Query("select a from Adicion a where a.nombre = ?1")
	Adicion findBynombre(String nombre);
	
}
