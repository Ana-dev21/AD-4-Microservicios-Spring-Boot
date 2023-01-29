package com.edix.microservicios.model.service.Interface;

import com.edix.microservicios.model.entities.Cliente;

public interface IClienteService {
	
	Cliente verUno(int idCliente) throws Exception; 

}
