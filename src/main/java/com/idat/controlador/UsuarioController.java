package com.idat.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.modelo.StatusUsuario;
import com.idat.modelo.Usuario;
import com.idat.servicio.UsuarioServicio;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	@Autowired
	private UsuarioServicio servU;
	
	@GetMapping
	public ResponseEntity<Object> buscarTodo(){
		List<Usuario> usuariosList = servU.buscarTodo();
		return new ResponseEntity<>(usuariosList,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id){
		Usuario usuario = servU.buscarPorId(id);
			if(usuario == null) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el usuario");
			}
			return new ResponseEntity<>(usuario,HttpStatus.FOUND);
	}
	
	@PostMapping("/login")
	public StatusUsuario login(@Valid @RequestBody Usuario usuario) {
		System.out.println(usuario.getUsuario() +":"+usuario.getPassword());
		Usuario usuarioEncontrado = servU.buscarPorUsuario(usuario.getUsuario());
		
		if(usuarioEncontrado != null) {
			if(usuario.getPassword().equals(usuarioEncontrado.getPassword())) {
				usuarioEncontrado.setLoggedIn(true);
				servU.actualizar(usuarioEncontrado);
				return StatusUsuario.EXITOSO;
			}
			return StatusUsuario.PASSWORD_ERRADO;
		}
		return StatusUsuario.USUARIO_NO_ENCONTRADO;
		
	}
	
	@PostMapping("/logout")
	public StatusUsuario logout(@Valid @RequestBody Usuario usuario) {
		Usuario usuarioEncontrado = servU.buscarPorUsuario(usuario.getUsuario());
		
		if(usuarioEncontrado != null) {
			if(usuario.getPassword().equals(usuarioEncontrado.getPassword())) {
				usuarioEncontrado.setLoggedIn(false);
				servU.actualizar(usuarioEncontrado);
				return StatusUsuario.EXITOSO;
			}
		}			
		return StatusUsuario.FALLIDO;
	}

}
