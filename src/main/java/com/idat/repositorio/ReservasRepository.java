package com.idat.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.modelo.Reservas;

@Repository
public interface ReservasRepository extends JpaRepository<Reservas, Integer> {

}
