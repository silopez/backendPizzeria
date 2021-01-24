package com.pedidos.pizza.backend.application.service;

import java.util.List;

import com.pedidos.pizza.backend.application.DTO.AdicionDTO;
import com.pedidos.pizza.backend.domain.entity.Adicion;

public interface IAdicionService {

	public List<AdicionDTO> obtenerAdiciones();
	
	public String guardar(AdicionDTO adicion) throws Exception;
	
	public Adicion buscarAdicion(String nombre);
	
	public String eliminarAdicion(Long Id);
	
}
