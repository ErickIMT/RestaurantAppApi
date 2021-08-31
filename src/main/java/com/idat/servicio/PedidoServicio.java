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
	
	public Page<Pedido> listBypags(Pageable pageable){
		return repoPed.findAll(pageable);
	}

	public List<Pedido> buscarTodo() {
		return repoPed.findAll();
	}

	public Pedido crear(Pedido pedido) {
		Date hoy = new Date();
		
		pedido.setFecha(new java.sql.Date(hoy.getTime()));
		Integer numId= buscarTodo().size()+1;
		
		Pedido idPedido = new Pedido();
		idPedido.setIdPedido(numId);		
		
		List<PedidoPlato> lista = pedido.getPedidoPlatoPed();
		for(PedidoPlato i :lista) {
			i.setPedido(idPedido);
		}
		
		return repoPed.save(pedido);
	}

}
