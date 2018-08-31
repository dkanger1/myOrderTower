package com.matheus.myOrder.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class Ingrediente implements Serializable{
	private static final long serialVersionUID = 1L;
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double valor;
	private Integer quantidade;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "INGREDIENTE_CATEGORIA",
				joinColumns = @JoinColumn(name = "ingrediente_id"),
				inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	
	public Ingrediente() {
		super();
	}




	public Ingrediente(Integer id, String nome, double valor, Integer quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}



	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + "]";
	}


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingrediente other = (Ingrediente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




	public List<Categoria> getCategorias() {
		return categorias;
	}




	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	
	
}
