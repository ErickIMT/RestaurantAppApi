package com.idat.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "pedidoplato")
public class PedidoPlato implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedidoPlato")
	private Integer idPedidoPlato;
	@Column(name = "cantidad")
	private int cantidad;
	@ManyToOne
	@JoinColumn(name = "pedido", referencedColumnName = "idPedido")
	@JsonBackReference(value = "pedidoplato_pedido")
	private Pedido pedido;
	@ManyToOne
	@JoinColumn(name = "plato", referencedColumnName = "idPlato")
	private Plato platoPed;
	
	public PedidoPlato() {
		// TODO Auto-generated constructor stub
	}
	
	public PedidoPlato(Pedido pedido) {
		super();
		this.pedido = pedido;
	}
	public Integer getIdPedidoPlato() {
		return idPedidoPlato;
	}
	public void setIdPedidoPlato(Integer idPedidoPlato) {
		this.idPedidoPlato = idPedidoPlato;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Plato getPlatoPed() {
		return platoPed;
	}
	public void setPlatoPed(Plato platoPed) {
		this.platoPed = platoPed;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
