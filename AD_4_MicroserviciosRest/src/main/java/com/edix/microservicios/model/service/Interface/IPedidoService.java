package com.edix.microservicios.model.service.Interface;

import java.util.List;

import com.edix.microservicios.model.entities.Pedido;

public interface IPedidoService {

	List<Pedido> verPorComercial(int idComercial);
	
}

