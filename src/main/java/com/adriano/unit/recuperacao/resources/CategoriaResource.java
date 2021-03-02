package com.adriano.unit.recuperacao.resources;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.validator.internal.util.logging.formatter.CollectionOfObjectsToStringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriano.unit.recuperacao.dominio.Categoria;
import com.adriano.unit.recuperacao.dto.CategoriaDTO;
import com.adriano.unit.recuperacao.service.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id){
		Categoria objeto = service.findById(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = service.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(objeto -> new CategoriaDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}

//localhost:8080/categorias/1