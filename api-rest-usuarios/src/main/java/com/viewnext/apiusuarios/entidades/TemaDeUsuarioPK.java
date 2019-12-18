package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

// Permite que sea usada como Embebida en otra clase
@Embeddable
public class TemaDeUsuarioPK implements Serializable{

	private static final long serialVersionUID = 7036631629856008260L;

	@Column(name = "id_usuario")
	@NotNull
	private Integer idUsuario;
	
	@Column(name = "id_tema", nullable = false)
	private Integer idTema;

	public TemaDeUsuarioPK() {
		super();
	}

	public TemaDeUsuarioPK(@NotNull Integer usuario, Integer tema) {
		super();
		this.idUsuario = usuario;
		this.idTema = tema;
	}
	
	public Integer getUsuario() {
		return idUsuario;
	}

	public void setUsuario(Integer usuario) {
		this.idUsuario = usuario;
	}

	public Integer getTema() {
		return idTema;
	}

	public void setTema(Integer tema) {
		this.idTema = tema;
	}
	
}
