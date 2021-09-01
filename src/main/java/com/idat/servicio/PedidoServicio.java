package com.idat.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.idat.modelo.Pedido;
import com.idat.modelo.PedidoPlato;
import com.idat.repositorio.PedidoRepository;

@Service
public class PedidoServicio {

	@Autowired
	private PedidoRepository repoPed;

	public PedidoServicio() {
	}
	
	//listado para Web
	public Page<Pedido> listBypags(Pageable pageable){
		return repoPed.findAll(pageable);
	}

	//listado para Android
	public List<Pedido>listPedidos(){
		return repoPed.getlistaPedidosPorPagar();
	}
	
	//Cambiar Estado Listo del pedido
	public Pedido setListo(Integer id) {
		Pedido ped = repoPed.findById(id).get();
		ped.setListo(!ped.isListo());
		repoPed.save(ped);
		return ped;
	}
	
	//Cambiar Estado Pago del pedido
	public Pedido setPago(Integer id) {
		Pedido ped = repoPed.findById(id).get();
		ped.setPago(!ped.isPago());
		repoPed.save(ped);
		return ped;
	}
	
	public List<Pedido> buscarTodo() {
		return repoPed.findAll();
	}	

	public Pedido crear(Pedido pedido) {
		//Asignar Fecha de Hoy al pedido
		Date hoy = new Date();		
		pedido.setFecha(new java.sql.Date(hoy.getTime()));
		
		//Asignar campo ID
		Integer numId= buscarTodo().size()+1;
		Pedido idPedido = new Pedido();
		idPedido.setIdPedido(numId);
		
		//Set False campos de listo y pago
		pedido.setListo(false);
		pedido.setPago(false);
		
		//Asignar Id del pedido a la Tabla M-M (PedidoPlato)		
		List<PedidoPlato> lista = pedido.getPedidoPlatoPed();
		for(PedidoPlato i :lista) {
			i.setPedido(idPedido);
		}		
		return repoPed.save(pedido);
	}

}
