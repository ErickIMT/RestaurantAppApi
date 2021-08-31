package com.idat.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.modelo.Usuario;
import com.idat.repositorio.UsuarioRepository;

@Service
public class UsuarioServicio {
	
	@Autowired
	private UsuarioRepository repoU;

	public UsuarioServicio() {}
	
	public List<Usuario> buscarTodo(){
		return repoU.findAll();
	}
	
	public Usuario buscarPorId(Integer id) {
		return repoU.findById(id).get();
	}
	
	public Usuario crear(Usuario usuario) {
		return repoU.save(usuario);
	}
	
	public Usuario actualizar(Usuario usuario) {
		Usuario usuarioActual = repoU.findById(usuario.getIdUsuario()).get();
		usuarioActual.setIdUsuario(usuario.getIdUsuario());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setUsuario(usuario.getUsuario());
		usuarioActual.setPassword(usuario.getPassword());
		usuarioActual.setLoggedIn(usuario.isLoggedIn());
		Usuario usuarioActualizado = repoU.save(usuarioActual);
		return usuarioActualizado;
	}
	
	public Usuario buscarPorUsuario(String usuario) {
		return repoU.getUsuarioPorUsuario(usuario);
	}
	
	
}
