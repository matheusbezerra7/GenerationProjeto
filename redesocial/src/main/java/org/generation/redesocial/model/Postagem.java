package org.generation.redesocial.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max= 500)
	private String postagem;
	
	@Temporal(TemporalType.DATE)
	private Date data= new java.sql.Date(System.currentTimeMillis());
	
	private int curtida;
	
	@URL
	private String imagem;
	
	@URL
	private String linkExterno;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;

	//Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPostagem() {
		return postagem;
	}

	public void setPostagem(String postagem) {
		this.postagem = postagem;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getCurtida() {
		return curtida;
	}

	public void setCurtida(int curtida) {
		this.curtida = curtida;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getLinkExterno() {
		return linkExterno;
	}

	public void setLinkExterno(String linkExterno) {
		this.linkExterno = linkExterno;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
