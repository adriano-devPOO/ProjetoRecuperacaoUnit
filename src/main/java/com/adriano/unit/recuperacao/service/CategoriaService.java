package com.adriano.unit.recuperacao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriano.unit.recuperacao.dominio.Categoria;
import com.adriano.unit.recuperacao.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepositorio repositorio;

	public Categoria findById(Integer id) {
		Optional<Categoria> objeto = repositorio.findById(id);
		
		return objeto.orElse(null);
	}
}
