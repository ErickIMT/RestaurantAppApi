package com.idat.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.idat.modelo.Pedido;
import com.idat.servicio.PedidoServicio;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PedidosController {

	@Autowired
	PedidoServicio servPed;
	
	@GetMapping
	public ResponseEntity<Page<Pedido>> pagCarreras(@RequestParam(defaultValue = "0") int page,
													@RequestParam(defaultValue = "10") int size,
													@RequestParam(defaultValue = "idPedido")String order,
													@RequestParam(defaultValue = "true") boolean asc){
		
		Page<Pedido> pedidos = servPed.listBypags(PageRequest.of(page, size, Sort.by(order)));
		if(!asc)
			pedidos = servPed.listBypags(PageRequest.of(page, size, Sort.by(order).descending()));
		return new ResponseEntity<Page<Pedido>>(pedidos,HttpStatus.OK);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<Object> buscarTodo(){
		List<Pedido> pedidosList = servPed.listPedidos();
		return new ResponseEntity<>(pedidosList,HttpStatus.OK);		
	}	
	
	@PutMapping("/listo/{id}")
	public ResponseEntity<Object> setListo(@PathVariable int id){
		Pedido ped = servPed.setListo(id);
		return new ResponseEntity<>(ped,HttpStatus.OK);
	}
	
	@PutMapping("/pago/{id}")
	public ResponseEntity<Object> setPago(@PathVariable int id){
		Pedido ped = servPed.setPago(id);
		return new ResponseEntity<>(ped,HttpStatus.OK);
	}	
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> grabarPedido(@RequestBody Pedido pedido) {
		Pedido pedidoC = servPed.crear(pedido);
		
		Map<String, String> rpt = new HashMap<>();
		rpt.put("Codigo:", "OK");
		rpt.put("Mensaje", "Nuevo Pedido Creado");
		rpt.put("Num Pedido: ", pedidoC.getIdPedido().toString());
		return new ResponseEntity<>(rpt, HttpStatus.CREATED);
	}
}
