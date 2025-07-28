package com.produtos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.produtos.model.Categoria;
import com.produtos.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

	
	public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria criar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada com ID: " + id));
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {
        Categoria existente = buscarPorId(id);
        existente.setNome(categoriaAtualizada.getNome());
        return categoriaRepository.save(existente);
    }

    public void excluir(Long id) {
        Categoria existente = buscarPorId(id);
        categoriaRepository.delete(existente);
    }
}
