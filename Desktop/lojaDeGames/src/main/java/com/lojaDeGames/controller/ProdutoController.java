package com.lojaDeGames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.lojaDeGames.model.Produto;
import com.lojaDeGames.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtosdegames")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<Produto>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID NÃO EXISTENTE"));
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> GetByTemas(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping("/save")

	public ResponseEntity<Produto> post(@Valid @RequestBody Produto titulo) {
		return ResponseEntity.status(201).body(repository.save(titulo));
	}

	@PutMapping("/update")
	public ResponseEntity<Produto> put(@Valid @RequestBody Produto titulo) {
		return ResponseEntity.status(200).body(repository.save(titulo));
	}

	@DeleteMapping("/remove/{id}")

	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
