package com.produtos.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.produtos.model.Produto;
import com.produtos.service.ProdutoService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	 private final ProdutoService produtoService;

	    public ProdutoController(ProdutoService produtoService) {
	        this.produtoService = produtoService;
	    }

	    @PostMapping
	    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, @RequestParam Long categoriaId) {
	        Produto criado = produtoService.criar(produto, categoriaId);
	        return ResponseEntity.created(URI.create("/produtos/" + criado.getId())).body(criado);
	    }

	    @GetMapping
	    public ResponseEntity<List<Produto>> listarTodos() {
	        return ResponseEntity.ok(produtoService.listarTodos());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
	        return ResponseEntity.ok(produtoService.buscarPorId(id));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Produto> atualizar(
	            @PathVariable Long id,
	            @Valid @RequestBody Produto produto,
	            @RequestParam Long categoriaId) {
	        return ResponseEntity.ok(produtoService.atualizar(id, produto, categoriaId));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluir(@PathVariable Long id) {
	        produtoService.excluir(id);
	        return ResponseEntity.noContent().build();
	    }
}
