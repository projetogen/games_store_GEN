package com.lojaDeGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lojaDeGames.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	public List<Categoria> findAllByTemasContainingIgnoreCase (String temas);
}