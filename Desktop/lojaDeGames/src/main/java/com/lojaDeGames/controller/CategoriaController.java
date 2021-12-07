package com.lojaDeGames.controller;

import java.util.List;

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

import com.lojaDeGames.model.Categoria;
import com.lojaDeGames.repository.CategoriaRepository;

@RestController
@RequestMapping("/lojadegames")
@CrossOrigin("*")
public class CategoriaController {
	@Autowired
	private CategoriaRepository repository;
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp)).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID NÃO EXISTENTE"));
	}
	@GetMapping("/tema/{temas}")
	public ResponseEntity<List<Categoria>> GetByTemas(@PathVariable String temas){
		return ResponseEntity.ok(repository.findAllByTemasContainingIgnoreCase(temas));
	}
	@PostMapping("/save")
	
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria){
	return ResponseEntity.status(201).body(repository.save(categoria));
	}
	@PutMapping("/update")
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria){
		return ResponseEntity.status(200).body(repository.save(categoria));
	}
	@DeleteMapping("/remove/{id}")
	
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
