package com.adriano.unit.recuperacao.repositorios;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.adriano.unit.recuperacao.dominio.Livro;


@Repository
public interface LivroRepositorio extends JpaRepository<Livro, Integer>{

	@Query("SELECT objeto FROM Livro objeto WHERE objeto.categoria.id = :idCategoria ORDER BY titulo")
	List<Livro> findAllByCategoria(@Param(value = "idCategoria") Integer idCategoria);
		

}
