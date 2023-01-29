package com.edix.microservicios.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.microservicios.model.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer>{
	@Query("select p from Pedido p where p.comercial.idComercial = ?1")
	List<Pedido> verPorComercial(int idComercial);

}
