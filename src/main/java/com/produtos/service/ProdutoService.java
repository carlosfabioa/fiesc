package com.produtos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.produtos.model.Categoria;
import com.produtos.model.Produto;
import com.produtos.repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	private final ProdutoRepository produtoRepository;
	private final CategoriaService categoriaService;

	public ProdutoService(ProdutoRepository produtoRepository, CategoriaService categoriaService) {
		this.produtoRepository = produtoRepository;
		this.categoriaService = categoriaService;
	}

	public Produto criar(Produto produto, Long categoriaId) {
		Categoria categoria = categoriaService.buscarPorId(categoriaId);
		produto.setCategoria(categoria);
		return produtoRepository.save(produto);
	}

	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Long id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
	}

	public Produto atualizar(Long id, Produto produtoAtualizado, Long categoriaId) {
		Produto existente = buscarPorId(id);
		Categoria categoria = categoriaService.buscarPorId(categoriaId);

		existente.setNome(produtoAtualizado.getNome());
		existente.setDescricao(produtoAtualizado.getDescricao());
		existente.setPreco(produtoAtualizado.getPreco());
		existente.setCategoria(categoria);

		return produtoRepository.save(existente);
	}

	public void excluir(Long id) {
		Produto existente = buscarPorId(id);
		produtoRepository.delete(existente);
	}

	public List<Produto> listarPorCategoria(Long categoriaId) {
		Categoria categoria = categoriaService.buscarPorId(categoriaId);
		return produtoRepository.findByCategoria(categoria);
	}
}
