package com.viewnext.apiusuarios.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tema_de_usuario")
public class TemaDeUsuario implements Serializable {

	private static final long serialVersionUID = 6461805933407064256L;

	@EmbeddedId
	private TemaDeUsuarioPK idspk;
	
	// Información específica de la columna en la bbdd
		@Column(name = "timestamp", nullable = false, updatable = false,
				insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
		@Temporal(TemporalType.TIMESTAMP)
		private Date timestamp;
		
//		@ManyToOne
//		@JoinColumn(name = "id_usuario", referencedColumnName = "id", insertable = false, updatable = false)
//		private Usuario usuario;
//		
//		@ManyToOne
//		@JoinColumn(name = "id_tema", referencedColumnName = "id", insertable = false, updatable = false)
//		private Tema tema;
		
		public TemaDeUsuario() {
			super();
		}
		
		public TemaDeUsuario(int idUsuario, int idTema) {
			this.idspk = new TemaDeUsuarioPK(idUsuario, idTema);
		}

		public TemaDeUsuarioPK getIdspk() {
			return idspk;
		}

		public void setIdspk(TemaDeUsuarioPK idspk) {
			this.idspk = idspk;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

}
