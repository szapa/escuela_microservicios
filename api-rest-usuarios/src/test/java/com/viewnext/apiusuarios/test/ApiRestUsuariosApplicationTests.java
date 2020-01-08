package com.viewnext.apiusuarios.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@SpringBootTest
class ApiRestUsuariosApplicationTests {

	// Spring hace un DaoTemas = new AlmacenDAOTemas();
	// Y lo asigna automaticamente a esta variable
	// Esto es lo que se llama Inyeccion de dependencias
	@Autowired
	private AlmacenDAOTemas daoTemas;
	
	@Autowired
	private AlmacenDAOUsuarios daoUsu;
	
	// TODO: Estos test no sriven porque  usan IDs fijos
	// Por eso se desactivan (comentario @Test)
	//@Test
	void contextLoads() {
		Tema tema = daoTemas.findById(1).orElse(null);
		assertEquals(1, tema.getId());
		assertNotEquals(0, tema.getNombre().length());
		
		Usuario usu = daoUsu.findById(1).orElse(null);
		// No sólo busca el registro de usuario e instancia un new usuario
		// mapeando los campos de la tabla en las
		// variables miembro(propiedades), hace lo mismo, en esta llamada
		// con la propiedad usu.temaPreferido de Tema, por las anotaciones
		// @ManyToOne y @JoinColumn
		// es decir, hace otro SELECT * FROM tema WHERE...,
		// e instancia un New Tema() y mapea...
		assertNotNull(usu);
		usu.setIdTemaPreferido(tema.getId());
		
		usu = daoUsu.save(usu);
		Integer idTemaPref = usu.getIdTemaPreferido();
		assertEquals(tema.getId(), idTemaPref);
		
		Tema temaPref = usu.getTemaPreferido();
		assertEquals(tema.getNombre(), temaPref.getNombre());
		
		Set<Usuario> usuariosPref = tema.getUsuariosPref();
		for (Usuario usuario : usuariosPref) {
			System.out.println("Usuario " + usuario.getNombre() + "prefiere" + tema.getNombre());
		}
		assertEquals(1, usuariosPref.size());
	}

}
