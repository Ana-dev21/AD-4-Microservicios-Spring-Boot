package com.edix.microservicios.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edix.microservicios.model.entities.Comercial;

public interface ComercialRepository extends JpaRepository<Comercial, Integer>{

	@Query(value="select distinct c.* from pedidos P "
			+ "join comerciales C on p.id_comercial=c.id_comercial "
			+ "where p.id_cliente = ?1", nativeQuery=true)
	List<Comercial> verPorCliente(int idCliente);
	
	@Query("select distinct c from Comercial c, Pedido p where p.comercial.idComercial = c")
	List<Comercial> verConPedidos();
}
