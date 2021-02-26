package com.adriano.unit.recuperacao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adriano.unit.recuperacao.dominio.Categoria;
import com.adriano.unit.recuperacao.dominio.Livro;
import com.adriano.unit.recuperacao.repositorios.CategoriaRepositorio;
import com.adriano.unit.recuperacao.repositorios.LivroRepositorio;

@SpringBootApplication
public class ProjetoPosApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	
	@Autowired
	private LivroRepositorio livroRepositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoPosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria = new Categoria(null, "informatica", "Livros de TI");
		Livro livro = new Livro(null, "Clean code", "Robert Martins", "Lorem ipsum", categoria);
		
		categoria.getLivro().addAll(Arrays.asList(livro));
		
		this.categoriaRepositorio.saveAll(Arrays.asList(categoria));
		this.livroRepositorio.saveAll(Arrays.asList(livro));
		
		
	}

}
