package com.adriano.unit.recuperacao.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adriano.unit.recuperacao.dominio.Categoria;
import com.adriano.unit.recuperacao.dominio.Livro;
import com.adriano.unit.recuperacao.repositorios.CategoriaRepositorio;
import com.adriano.unit.recuperacao.repositorios.LivroRepositorio;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private LivroRepositorio livroRepositorio;

	public void instanciaBaseDados() {
		
		Categoria categoriaA = new Categoria(null, "Informatica", "Livros de TI");
		Categoria categoriaB = new Categoria(null, "Ficção", "Livros de ficção");
		Categoria categoriaC = new Categoria(null, "Biografia", "Livros de biografia");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martins", "Lorem ipsum", categoriaA);
		Livro l2 = new Livro(null, "Engenharia de software", "Louis V", "Lorem ipsum", categoriaA);
		Livro l3 = new Livro(null, "The time machine", "Paulo Pedro", "Lorem ipsum", categoriaB);
		Livro l4 = new Livro(null, "The war of the world", "Robert Patrício", "Lorem ipsum", categoriaB);
		Livro l5 = new Livro(null, "A psicóloga", "Fabiola Tatiane", "Lorem ipsum", categoriaC);
		
		categoriaA.getLivro().addAll(Arrays.asList(l1,l2));
		categoriaB.getLivro().addAll(Arrays.asList(l3,l4));
		categoriaC.getLivro().addAll(Arrays.asList(l5));
		
		this.categoriaRepositorio.saveAll(Arrays.asList(categoriaA, categoriaB, categoriaC));
		this.livroRepositorio.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
	}
}
