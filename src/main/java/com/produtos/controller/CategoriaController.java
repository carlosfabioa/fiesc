package com.produtos.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.produtos.model.Categoria;
import com.produtos.model.Produto;
import com.produtos.service.CategoriaService;
import com.produtos.service.ProdutoService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	private final CategoriaService categoriaService;
    private final ProdutoService produtoService;

    public CategoriaController(CategoriaService categoriaService, ProdutoService produtoService) {
        this.categoriaService = categoriaService;
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria) {
        Categoria criada = categoriaService.criar(categoria);
        return ResponseEntity.created(URI.create("/categorias/" + criada.getId())).body(criada);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodas() {
        return ResponseEntity.ok(categoriaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @Valid @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.atualizar(id, categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        categoriaService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/produtos")
    public ResponseEntity<List<Produto>> listarProdutosPorCategoria(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.listarPorCategoria(id));
    }
}
