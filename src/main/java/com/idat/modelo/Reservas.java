package com.idat.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservas")
public class Reservas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idReserva")
	private Integer idReserva;
	@Column(name="mesa")
	private Integer mesa;
	@Column(name="fechaHora")
	private Date fechaHora;
	@Column(length = 150, name = "nombreCliente")
	private String nombreCliente;
	
	public Integer getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}
	public Integer getMesa() {
		return mesa;
	}
	public void setMesa(Integer mesa) {
		this.mesa = mesa;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
