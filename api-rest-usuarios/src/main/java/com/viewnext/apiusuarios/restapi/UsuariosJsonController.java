package com.viewnext.apiusuarios.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.entidades.TemaDeUsuario;
import com.viewnext.apiusuarios.entidades.TemaDeUsuarioPK;
import com.viewnext.apiusuarios.entidades.Usuario;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;
import com.viewnext.apiusuarios.model.AlmacenDAOTemasDeUsuarios;
import com.viewnext.apiusuarios.model.AlmacenDAOUsuarios;

@RestController()
@RequestMapping("/api/json/usuarios")
@CrossOrigin(origins = "*")
public class UsuariosJsonController {

	@Autowired
	private AlmacenDAOUsuarios dao;
	
	@Autowired
	private AlmacenDAOTemas daoTemas;
	
	@Autowired
	private AlmacenDAOTemasDeUsuarios daoTemasUsu;
	
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
		daoTemasUsu.deleteByUsuario(id);
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
	
	@GetMapping(value = "/{id}/temas_usu")
	public List<TemaDeUsuario> getTemaDeUsuario(@PathVariable Integer id) {
		return daoTemasUsu.findTemasDeUnUsuario(id);
	}
	
	@PostMapping(value = "/{id}/temas/{idt}")
	public TemaDeUsuario addTemaDeUsuario(@PathVariable Integer id, @PathVariable(name = "idt") Integer idTema) {
		TemaDeUsuario nuevoTema = new TemaDeUsuario(id, idTema);
		return daoTemasUsu.save(nuevoTema);
	}
	
	@DeleteMapping("/{idu}/temas/{idt}")
	public void deleteTemaDeUsuario(@PathVariable Integer idu, @PathVariable Integer idt) {
		TemaDeUsuarioPK tu = new TemaDeUsuarioPK(idu, idt);
		daoTemasUsu.deleteById(tu);
	}
}
