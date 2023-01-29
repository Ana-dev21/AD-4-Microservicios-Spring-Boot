package com.edix.microservicios.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.microservicios.model.entities.Cliente;
import com.edix.microservicios.model.repository.ClienteRepository;
import com.edix.microservicios.model.service.Interface.IClienteService;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private ClienteRepository cliRepo;

	/**
	 * Comprueba si el cliente existe. Si existe lo devuelve, sino lanza una excepción
	 * @throws Exception si el cliente indicado no existe
	 */
	@Override
	public Cliente verUno(int idCliente) throws Exception {
		Cliente cliente = cliRepo.findById(idCliente).orElse(null);
		if (cliente == null) throw new Exception("El cliente indicado no existe");
		return cliente;
	}
	
	
}
