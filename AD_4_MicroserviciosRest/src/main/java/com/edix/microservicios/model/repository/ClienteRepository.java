package com.edix.microservicios.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edix.microservicios.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
