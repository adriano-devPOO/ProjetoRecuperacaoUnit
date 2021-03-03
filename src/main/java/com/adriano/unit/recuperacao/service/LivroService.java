package com.adriano.unit.recuperacao.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriano.unit.recuperacao.dominio.Livro;
import com.adriano.unit.recuperacao.exceptions.ObjectNotFoundException;
import com.adriano.unit.recuperacao.repositorios.LivroRepositorio;

@Service
public class LivroService {

	@Autowired
	private LivroRepositorio repositorio;

	public Livro findById(Integer id) {
		Optional<Livro> objeto = repositorio.findById(id);
		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + LivroService.class.getName()));
	}
}
