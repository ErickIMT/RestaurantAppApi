package com.idat.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.idat.modelo.Plato;
import com.idat.servicio.PlatosServicio;

@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlatosController {
	
	@Autowired
	PlatosServicio servP;
	
	@GetMapping("/lista/{id}")
	public ResponseEntity<Object> getPlatosPorTipo(@PathVariable("id") int id){
		List<Plato> listaPlatos = servP.getPlatosPorTipo(id);
		return new ResponseEntity<>(listaPlatos, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPlatoPorId(@PathVariable("id") int id){
		Plato plato = servP.getPlato(id);
		if(plato == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se Encontro IdPlato");
		}		
		return new ResponseEntity<>(plato,HttpStatus.FOUND);
		
	}
}
