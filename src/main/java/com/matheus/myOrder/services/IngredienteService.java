package com.matheus.myOrder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.matheus.myOrder.domain.Categoria;
import com.matheus.myOrder.domain.Ingrediente;
import com.matheus.myOrder.dto.IngredienteDTO;
import com.matheus.myOrder.repositories.CategoriaRepository;
import com.matheus.myOrder.repositories.IngredienteRepository;
import com.matheus.myOrder.services.exceptions.ObjectNotFoundException;


@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Ingrediente> findAll()
	{
		return repo.findAll();
	}
	
	
	public Ingrediente find(Integer id) {
		Optional<Ingrediente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ingrediente.class.getName()));
	}

	public Ingrediente insert(Ingrediente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Ingrediente update(Ingrediente obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	public Page<Ingrediente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
	return repo.findAll(pageRequest);
	}
	
	public Ingrediente fromDTO(IngredienteDTO objDto) {
		return new Ingrediente(objDto.getId(), objDto.getNome(), 0, null);
	}
	
	
	
}
