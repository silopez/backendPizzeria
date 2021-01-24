package com.pedidos.pizza.backend.application.utils;

public enum MessageUtil {
	
	FORMATO_VALOR_DINERO(1,"Formato de valor no es el correcto"),
	VALOR_MENOR_CERO(2,"No es posible poner un valor menor a cero"),
	GUARDADO_EXITOSO_ADICION(3, "Se ha guardado exitosamente una nueva adicion");
	
	private final String mensaje;
	
	MessageUtil(int id, String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
		
}
