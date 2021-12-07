package com.lojaDeGames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "categoria")
public class Categoria {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private @NotNull String generos;

	private @NotNull String seccoesEspeciais;

	private @NotNull String temas;

	private @NotNull String modosDeJogador;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.REMOVE)
	private List<Produto> produto = new ArrayList<>();
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGeneros() {
		return generos;
	}

	public void setGeneros(String generos) {
		this.generos = generos;
	}

	public String getSeccoesEspeciais() {
		return seccoesEspeciais;
	}

	public void setSeccoesEspeciais(String seccoesEspeciais) {
		this.seccoesEspeciais = seccoesEspeciais;
	}

	public String getTemas() {
		return temas;
	}

	public void setTemas(String temas) {
		this.temas = temas;
	}

	public String getModosDeJogador() {
		return modosDeJogador;
	}

	public void setModosDeJogador(String modosDeJogador) {
		this.modosDeJogador = modosDeJogador;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	
}
