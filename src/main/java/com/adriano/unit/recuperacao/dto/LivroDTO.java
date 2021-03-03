package com.adriano.unit.recuperacao.dto;

import java.io.Serializable;

import com.adriano.unit.recuperacao.dominio.Livro;

public class LivroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;

	public LivroDTO() {
		super();
	}

	public LivroDTO(Livro objeto) {
		super();
		this.id = objeto.getId();
		this.titulo = objeto.getTitulo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
