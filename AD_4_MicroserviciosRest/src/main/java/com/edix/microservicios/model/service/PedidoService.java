package com.edix.microservicios.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edix.microservicios.model.entities.Pedido;
import com.edix.microservicios.model.repository.PedidoRepository;
import com.edix.microservicios.model.service.Interface.IPedidoService;

@Service
public class PedidoService implements IPedidoService{
	
	@Autowired
	PedidoRepository peRepo;

	/**
	 * Devuelve los pedidos del comercial pasado por id
	 */
	@Override
	public List<Pedido> verPorComercial(int idComercial) {
		return peRepo.verPorComercial(idComercial);
	}

	

}
