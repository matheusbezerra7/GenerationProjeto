package org.generation.redesocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tema")

public class Tema {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Size(max = 200)
	private long id;
	
	@NotNull
	@Size(min= 10, max= 200)
	private String tema;
	
	@NotNull
	@Size(min= 10, max= 200)
	private String categoria;
	
	
	@NotNull
	@Size(min= 2, max= 2)
	private String estado;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getTema() {
		return tema;
	}


	public void setTema(String tema) {
		this.tema = tema;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
}



