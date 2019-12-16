package com.viewnext.apiusuarios.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api/usuarios")
public class UsuariosController {

	@Autowired
	private AlmacenDAOUsuarios dao;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Usuario getUsuario(@PathVariable Integer id) {
		return dao.findById(id).orElse(null);
	}
	
	@PostMapping()
	public Usuario crearUsuario(@RequestBody Usuario usuario) {
		// Recibe sin ID en el BODY de la petición HTTP y deserializa el JSON a un objeto Usuario
		return dao.save(usuario); // Devuelve con ID
	}
	
	@GetMapping
	public List<Usuario> leerTodos(){
		return dao.findAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteUsuario(@PathVariable Integer id) {
		 dao.deleteById(id);
	}
	
	@DeleteMapping()
	public void deleteUsuario(@RequestBody Usuario usuario) {
		dao.delete(usuario);
	}
	
	@PutMapping(value = "/{id}")
	public Usuario modificarUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
		usuario.setId(id);
		return dao.save(usuario);
	}
	
	@PutMapping()
	public Usuario modificarUsuario(@RequestBody Usuario usuario) {
		return dao.save(usuario);
	}
	 
	@PostMapping(value = "/formulario")
	public Usuario crearUsuarioPorParam(
			@RequestParam (name="nombre") String name, 
			@RequestParam String email, 
			@RequestParam String password) {
		Usuario usu = new Usuario(null, name, email, password);
		return dao.save(usu);
	}
}
