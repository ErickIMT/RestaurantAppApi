package com.idat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.modelo.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
