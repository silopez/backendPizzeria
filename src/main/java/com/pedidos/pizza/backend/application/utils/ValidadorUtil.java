package com.pedidos.pizza.backend.application.utils;

public class ValidadorUtil {
		
	public static Integer validarValorDinero(String valorDinero) throws Exception{
		Integer valor;
		
		try {
			valor = Integer.valueOf(valorDinero);
		}catch (Exception e) {
			throw new Exception(MessageUtil.FORMATO_VALOR_DINERO.getMensaje());
		}
		
		
		if(valor < 0) {
			throw new Exception(MessageUtil.VALOR_MENOR_CERO.getMensaje());
		}
		
		return valor;
	}

}
