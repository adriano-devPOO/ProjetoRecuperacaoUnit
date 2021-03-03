package com.adriano.unit.recuperacao.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriano.unit.recuperacao.dominio.Livro;
import com.adriano.unit.recuperacao.dto.LivroDTO;
import com.adriano.unit.recuperacao.service.LivroService;

@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	
	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro objeto = service.findById(id);
		return ResponseEntity.ok().body(objeto);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAll(){
		List<Livro> list = service.findAll();
		List<LivroDTO> listDTO = list.stream().map(objeto -> new LivroDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro objeto){
		Livro novoObjeto = service.update(id, objeto);
		return ResponseEntity.ok().body(novoObjeto);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro objeto){
		Livro novoObjeto = service.update(id, objeto);
		return ResponseEntity.ok().body(novoObjeto);
	}

}
