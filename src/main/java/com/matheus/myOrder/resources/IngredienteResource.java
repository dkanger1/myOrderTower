package com.matheus.myOrder.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.myOrder.domain.Categoria;
import com.matheus.myOrder.domain.Ingrediente;
import com.matheus.myOrder.dto.CategoriaDTO;
import com.matheus.myOrder.dto.IngredienteDTO;
import com.matheus.myOrder.services.IngredienteService;

@RestController
@RequestMapping(value="/ingredientes")
public class IngredienteResource {

	@Autowired
	private IngredienteService service;
		
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<IngredienteDTO>> findAll() {
		List<Ingrediente> list = service.findAll();
		List<IngredienteDTO> listDto = list.stream().map(obj -> new IngredienteDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
}
