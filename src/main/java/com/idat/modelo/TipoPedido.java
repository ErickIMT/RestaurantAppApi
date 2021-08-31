package com.idat.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tipopedido")
public class TipoPedido implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoPedido;
	@Column(length = 15)
	private String nombre;	
	@JsonBackReference
	@OneToMany(mappedBy = "tipoPedido", cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	public Integer getIdTipoPedido() {
		return idTipoPedido;
	}
	public void setIdTipoPedido(Integer idTipoPedido) {
		this.idTipoPedido = idTipoPedido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
