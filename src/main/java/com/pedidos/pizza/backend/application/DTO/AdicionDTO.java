package com.pedidos.pizza.backend.application.DTO;

import com.pedidos.pizza.backend.domain.entity.Adicion;

public class AdicionDTO {

	private Long id;
	private String nombre;
	private String descripcion;
	private String valor;
	
	public AdicionDTO() {}
	
	public AdicionDTO(String nombre, String descripcion, String valor) {		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}
	
	public static AdicionDTO convertirEntidadADTO(Adicion adicion) {
		String valor = Integer.toString(adicion.getValor());
		return new AdicionDTO(adicion.getNombre(), adicion.getDescripcion(), valor);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
