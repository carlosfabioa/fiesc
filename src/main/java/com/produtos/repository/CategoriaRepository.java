package com.produtos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	boolean existsByNome(String nome);
}
