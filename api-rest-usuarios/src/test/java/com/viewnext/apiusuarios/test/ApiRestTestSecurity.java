package com.viewnext.apiusuarios.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@SpringBootTest
public class ApiRestTestSecurity {

	@Autowired
	private AlmacenDAOUsuarios daoUsu;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuario() {
		Usuario usu = new Usuario();
		usu.setNombre("Esta noche frenadol-cola (soy javi)");
		String passEncript = encoder.encode("321");
		usu.setPassword(passEncript);
		usu.setEmail("frenadol@soyjavi.com");
		Usuario usuGuard = daoUsu.save(usu);
		
		assertEquals(usuGuard.getEmail(), usu.getPassword());
		assertEquals(usuGuard.getPassword(), usu.getPassword());
		assertEquals(daoUsu.findByNombre("german").getNombre(), "german");
		
	}
}
