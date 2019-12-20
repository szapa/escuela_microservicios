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

import com.viewnext.apiusuarios.entidades.Tema;
import com.viewnext.apiusuarios.model.AlmacenDAOTemas;

@RestController
@RequestMapping("/api/temas")
public class TemasController {

	@Autowired
	AlmacenDAOTemas daoTemas;
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Tema getTema(@PathVariable Integer id) {
		return daoTemas.findById(id).orElse(null);
	}
	
	@PostMapping()
	public Tema crearTema(@RequestBody Tema tema) {
		return daoTemas.save(tema);
		
	}
	
	@GetMapping
	public List<Tema>listarTemas(@RequestParam(name = "usuario", required = false) Integer idUsuario) {
		List<Tema> temas;
		if (idUsuario==null) {
			temas = daoTemas.findAll();
		} else {
			temas = daoTemas.findTemasPorUsuario(idUsuario);
		}
		return temas;
	}
	
	@DeleteMapping("{id}")
	public void borrarPorId(@PathVariable Integer id) {
		daoTemas.deleteById(id);
	}
	
	@DeleteMapping
	private void borrarTema(@RequestBody Tema tema) {
		daoTemas.delete(tema);
	}
	
	@PutMapping
	public Tema modificarTema(@RequestBody Tema tema) {
		return daoTemas.save(tema);
	}
	
	@PutMapping("{id}")
	public Tema modificarTemaId(@PathVariable Integer id, @RequestBody Tema tema) {
		tema.setId(id);
		return daoTemas.save(tema);
	}
	
	@PostMapping("/listar")
	public List<Tema> crearListado(@RequestBody List<Tema> listTemas) {
		return daoTemas.saveAll(listTemas);
	}
	
}
