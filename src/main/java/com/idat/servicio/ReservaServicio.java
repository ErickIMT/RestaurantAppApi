package com.idat.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.modelo.Reservas;
import com.idat.repositorio.ReservasRepository;

@Service
public class ReservaServicio {
	
	@Autowired
	ReservasRepository repoR;

	public List<Reservas> getLisReserva(){
		List<Reservas> lista = repoR.findAll();
		return lista;
	}
	
	public Reservas grabarReserva(Reservas reserva) {
		
		return repoR.save(reserva); 
	}
}
