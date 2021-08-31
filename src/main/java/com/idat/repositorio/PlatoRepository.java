package com.idat.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.idat.modelo.Plato;

@Repository
public interface PlatoRepository extends JpaRepository<Plato, Integer> {
	
	@Query("select p from Plato p where p.tipoPlato.idTipoPlato = :idTipoPlato")
	public List<Plato> getPlatos (int idTipoPlato);

}
