package com.idat.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.modelo.Plato;
import com.idat.repositorio.PlatoRepository;

@Service
public class PlatosServicio {
	
	@Autowired
	private PlatoRepository repoP;
	
	public PlatosServicio() {}
	
	public List<Plato> getPlatosPorTipo(Integer idTipoPlato){
		return repoP.getPlatos(idTipoPlato);
	}
	
	public Plato getPlato(Integer id) {
		return repoP.findById(id).get();
	}

}
