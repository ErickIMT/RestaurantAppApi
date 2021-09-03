package com.idat.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.modelo.Reservas;
import com.idat.servicio.ReservaServicio;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins="*",allowedHeaders = "*")
public class ReservaController {

	@Autowired
	ReservaServicio servR;
	
	@GetMapping("/lista")
	public ResponseEntity<Object> listaReservas(){
		List<Reservas> lista = servR.getLisReserva();
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@PostMapping("/grabar")
	public ResponseEntity<Object> grabarReserva(@RequestBody Reservas reserva){
		Reservas reserv = servR.grabarReserva(reserva);
		
		return new ResponseEntity<>(reserv, HttpStatus.OK);
	}
	
}
