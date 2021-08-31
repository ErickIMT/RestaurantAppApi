package com.idat.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "plato")
public class Plato implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPlato")
	private Integer idPlato;
	@Column(length = 150,name = "nombre")
	private String nombre;
	@Column(length = 255,name = "descripcion")
	private String descripcion;	
	@Column(precision = 5, scale = 2,name = "precio")
	private BigDecimal precio;
	@JoinColumn(name = "tipoplato", referencedColumnName = "idTipoPLato")
	@ManyToOne(optional = false)
	@JsonBackReference(value = "plato_tipoplato")
	private TipoPlato tipoPlato;
	@OneToMany(mappedBy = "platoPed", cascade = CascadeType.ALL)
	@JsonBackReference(value = "plato_pedidoplato")
	private List<PedidoPlato> pedidoPlatoPla;
	
	public Integer getIdPlato() {
		return idPlato;
	}
	public void setIdPlato(Integer idPlato) {
		this.idPlato = idPlato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}		
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TipoPlato getTipoPlato() {
		return tipoPlato;
	}
	public void setTipoPlato(TipoPlato tipoPlato) {
		this.tipoPlato = tipoPlato;
	}
	public List<PedidoPlato> getPedidoPlatoPla() {
		return pedidoPlatoPla;
	}
	public void setPedidoProductosPla(List<PedidoPlato> pedidoPlatoPla) {
		this.pedidoPlatoPla = pedidoPlatoPla;
	}
	
	
	
}
