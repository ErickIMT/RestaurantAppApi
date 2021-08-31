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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tipoplato")
public class TipoPlato implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name="idTipoPlato")
	private Integer idTipoPlato;
	@Column(length = 100, name = "nombre")
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoPlato")
	private List<Plato> platos;
	
	public Integer getIdTipoPlato() {
		return idTipoPlato;
	}
	public void setIdTipoPlato(Integer idTipoPlato) {
		this.idTipoPlato = idTipoPlato;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Plato> getPlatoList() {
		return platos;
	}
	public void setPlatoList(List<Plato> platos) {
		this.platos = platos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
