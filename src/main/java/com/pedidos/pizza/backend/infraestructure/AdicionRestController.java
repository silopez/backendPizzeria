package com.pedidos.pizza.backend.infraestructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pedidos.pizza.backend.application.DTO.AdicionDTO;
import com.pedidos.pizza.backend.application.service.IAdicionService;

@RestController
@RequestMapping("/api/adicion")
public class AdicionRestController {
	
	@Autowired
	private IAdicionService adicionService;
	
	@GetMapping("/adiciones")
	@ResponseStatus(HttpStatus.OK)
	public List<AdicionDTO> obtenerAdiciones(){
		return adicionService.obtenerAdiciones();
	}
	
	@PostMapping("/adicion")
	public ResponseEntity<Object> guardar(@RequestBody AdicionDTO adicion){
		
		Map<String, String> respuesta = new HashMap<>();
		
		try {
			String mensajeExito = adicionService.guardar(adicion);
			respuesta.put("respuesta", mensajeExito);
		} catch (Exception e) {
			respuesta.put("respuesta", e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
		}			
		
		return ResponseEntity.status(HttpStatus.OK).body(respuesta);
	}
	
}
