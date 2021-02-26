package com.adriano.unit.recuperacao.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adriano.unit.recuperacao.dominio.Livro;


@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Integer>{

}
