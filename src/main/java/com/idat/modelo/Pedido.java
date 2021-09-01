package com.idat.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "pedido")
public class Pedido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido")
	private Integer idPedido;
	@Column(length = 50, name = "numDoc")
	private String numDoc;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "total")
	private BigDecimal total;
	@Column(name = "mesa")
	private Integer mesa;
	@Column(name = "listo")
	private boolean listo;
	@Column(name = "pago")
	private boolean pago;
	@ManyToOne
	@JoinColumn(name = "tipopedido", referencedColumnName = "idTipoPedido")
	private TipoPedido tipoPedido;	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<PedidoPlato> pedidoPlatoPed;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(Integer idPedido) {
		super();
		this.idPedido = idPedido;
	}
	
	public Integer getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public List<PedidoPlato> getPedidoPlatoPed() {
		return pedidoPlatoPed;
	}
	public void setPedidoPlatoPed(List<PedidoPlato> pedidoPlatoPed) {
		this.pedidoPlatoPed = pedidoPlatoPed;
	}
	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public boolean isListo() {
		return listo;
	}

	public void setListo(boolean listo) {
		this.listo = listo;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}
	
	
	

}
