package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min = 1, max = 50)
	private String nombre;
	
	@NonNull
	@Size(min = 3, max = 500)
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
	@Column(unique = true)
	private String email;
	
	// Información específica de la columna en la bbdd
	@Column(name = "timestamp", nullable = false, updatable = false,
			insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@Size(min = 2, max = 500)
	private String password;
	
	@Column(name = "id_tema_preferido", nullable = true, insertable = true, updatable = true)
	private Integer idTemaPreferido;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "id_tema_preferido", referencedColumnName = "id",  nullable = true, insertable = false, updatable = false)
	@JsonProperty("preferido_tema")
	private Tema temaPreferido;
	
	public Usuario(Integer id, String nombre, String email, String password) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

	public Usuario() {
		super();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getIdTemaPreferido() {
		return idTemaPreferido;
	}
	public void setIdTemaPreferido(Integer idTemaPreferido) {
		this.idTemaPreferido = idTemaPreferido;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Tema getTemaPreferido() {
		return temaPreferido;
	}

	public void setTemaPreferido(Tema tema) {
		this.temaPreferido = tema;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
