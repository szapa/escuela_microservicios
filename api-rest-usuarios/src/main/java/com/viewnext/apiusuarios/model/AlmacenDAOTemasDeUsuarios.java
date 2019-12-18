package com.viewnext.apiusuarios.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.TemaDeUsuarioPK;

public interface AlmacenDAOTemasDeUsuarios extends JpaRepository<TemaDeUsuario, TemaDeUsuarioPK>{
	
	@Query(value = "SELECT tu.* FROM db_usuarios.tema_de_usuario as tu inner join db_usuarios.usuario as u on u.id = tu.id_usuario\r\n" + 
			"where tu.id_usuario = ?1 ;", nativeQuery = true)
	List<TemaDeUsuario> findTemasDeUnUsuario(Integer idUsuario);

}
