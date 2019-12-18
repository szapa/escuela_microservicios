package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Tema implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(unique = true)
	private String nombre;

	@OneToMany(fetch = FetchType.EAGER) // Forma de recuperar. Eager: rapida,al hacer la consulta.
																										// lazy: perezosa
	@JoinColumn(name = "id_tema_preferido")
	//@JsonIgnore
	@JsonBackReference
	private Set<Usuario> usuariosPref;

	@Size(min = 0, max = 500)
	private String descripcion;

	// Información específica de la columna en la bbdd
	@Column(name = "timestamp", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	public Tema() {
		super();
	}

	public Tema(Integer id, @NotNull @Size(min = 1, max = 50) String nombre,
			@Size(min = 0, max = 500) String descripcion, Date timestamp) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.timestamp = timestamp;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Usuario> getUsuariosPref() {
		return usuariosPref;
	}

	public void setUsuariosPref(Set<Usuario> usuariosPref) {
		this.usuariosPref = usuariosPref;
	}

}
