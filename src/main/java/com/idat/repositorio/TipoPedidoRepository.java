package com.idat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.modelo.TipoPedido;

@Repository
public interface TipoPedidoRepository extends JpaRepository<TipoPedido, Integer> {

}
