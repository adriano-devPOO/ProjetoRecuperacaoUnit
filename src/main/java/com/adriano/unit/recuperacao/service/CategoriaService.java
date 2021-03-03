package com.adriano.unit.recuperacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.adriano.unit.recuperacao.dominio.Categoria;
import com.adriano.unit.recuperacao.dto.CategoriaDTO;
import com.adriano.unit.recuperacao.exceptions.DataIntegratyViolationException;
import com.adriano.unit.recuperacao.exceptions.ObjectNotFoundException;
import com.adriano.unit.recuperacao.repositorios.CategoriaRepositorio;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepositorio repositorio;

	public Categoria findById(Integer id) {
		Optional<Categoria> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repositorio.findAll();
	}

	public Categoria create(Categoria objeto) {
		objeto.setId(null);
		return repositorio.save(objeto);
	}

	public Categoria update(Integer id, CategoriaDTO objetoDTO) {
		Categoria objeto = findById(id);
		objeto.setNome(objetoDTO.getNome());
		objeto.setDescricao(objetoDTO.getDescricao());
		return repositorio.save(objeto);
	}

	public void delete(Integer id) {
		findById(id);

		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegratyViolationException("Categoria não pode ser deletado! Possui livros associados.");
		}

	}
}
