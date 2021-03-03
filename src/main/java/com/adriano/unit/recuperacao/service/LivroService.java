package com.adriano.unit.recuperacao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriano.unit.recuperacao.dominio.Categoria;
import com.adriano.unit.recuperacao.dominio.Livro;
import com.adriano.unit.recuperacao.exceptions.ObjectNotFoundException;
import com.adriano.unit.recuperacao.repositorios.LivroRepositorio;

@Service
public class LivroService {

	@Autowired
	private LivroRepositorio repositorio;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> objeto = repositorio.findById(id);
		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + LivroService.class.getName()));
	}

	public List<Livro> findAll() {
		return repositorio.findAll();
	}

	public Livro update(Integer id, Livro objeto) {
		Livro novoObjeto = findById(id);
		updateData(novoObjeto, objeto);
//		objeto.setId(objeto.getId());
//		objeto.setTitulo(objeto.getTitulo());
		return repositorio.save(novoObjeto);

	}

	private void updateData(Livro novoObjeto, Livro objeto) {
		novoObjeto.setTitulo(objeto.getTitulo());
		novoObjeto.setNomeAutor(objeto.getNomeAutor());
		novoObjeto.setTexto(objeto.getTexto());
	}

	public Livro create(Integer idCat, Livro objeto) {
		objeto.setId(null);
		Categoria cat = categoriaService.findById(idCat);
		objeto.setCategoria(cat);
		return repositorio.save(objeto);
	}

	public void delete(Integer id) {
		Livro obj = findById(id);
		repositorio.delete(obj);	
	}

}
