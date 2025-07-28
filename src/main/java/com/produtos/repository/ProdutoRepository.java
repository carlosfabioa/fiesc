package com.produtos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.model.Categoria;
import com.produtos.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findByCategoria(Categoria categoria);
}
