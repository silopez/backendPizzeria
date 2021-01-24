package com.pedidos.pizza.backend.application.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedidos.pizza.backend.application.DTO.AdicionDTO;
import com.pedidos.pizza.backend.application.utils.MessageUtil;
import com.pedidos.pizza.backend.application.utils.ValidadorUtil;
import com.pedidos.pizza.backend.domain.entity.Adicion;
import com.pedidos.pizza.backend.domain.repository.IAdicionRepository;

@Service
public class AdicionServiceImpl implements IAdicionService{

	@Autowired
	private IAdicionRepository adicionRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<AdicionDTO> obtenerAdiciones(){
		List<Adicion> listaAdicion = (List<Adicion>) adicionRepository.findAll();
		List<AdicionDTO> listaAdicionDTO = new ArrayList<>();
		
		listaAdicion.forEach(item -> 
			listaAdicionDTO.add(AdicionDTO.convertirEntidadADTO(item))
		);
		
		return listaAdicionDTO;
	}

	@Override
	public String guardar(AdicionDTO adicion) throws Exception {
		
		Integer valor = ValidadorUtil.validarValorDinero(adicion.getValor());
		
		Adicion adicionEncontrada = buscarAdicion(adicion.getNombre());
		
		String mensajeExito = null;
		
		if(adicionEncontrada == null) {
			Adicion adicionAGuardar = new Adicion(adicion.getNombre(), adicion.getDescripcion(), valor);
			adicionRepository.save(adicionAGuardar);	
			
			mensajeExito = MessageUtil.GUARDADO_EXITOSO_ADICION.getMensaje();
			
		}else {
			//TODO Cuando se va actualizar alguna adicion
		}
		
		return mensajeExito;
	}

	@Override
	@Transactional(readOnly = true)
	public Adicion buscarAdicion(String nombre) {
		return adicionRepository.findBynombre(nombre);
	}
	

	@Override
	public String eliminarAdicion(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
