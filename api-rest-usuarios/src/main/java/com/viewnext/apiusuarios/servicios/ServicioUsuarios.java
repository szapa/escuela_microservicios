package com.viewnext.apiusuarios.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@Service
public class ServicioUsuarios implements UserDetailsService{

	private AlmacenDAOUsuarios daoUsu;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usu = daoUsu.findByNombre(username);
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails detallesUsuario = new User(usu.getNombre(), usu.getPassword(), roles);
		return detallesUsuario;
	}
	
	

}
