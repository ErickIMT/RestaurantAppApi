package com.idat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idat.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.usuario = :usuario")
	public Usuario getUsuarioPorUsuario(@Param("usuario") String usuario);

}
