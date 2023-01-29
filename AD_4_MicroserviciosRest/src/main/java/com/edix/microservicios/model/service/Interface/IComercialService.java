package com.edix.microservicios.model.service.Interface;

import java.util.List;

import com.edix.microservicios.model.entities.Comercial;

public interface IComercialService {
	Comercial altaComercial(Comercial comercial) throws Exception;
	void eliminarComercial(int idComercial)  throws Exception;
	Comercial verUno(int idComercial) throws Exception;
	List<Comercial> verPorCliente(int idCliente);
	List<Comercial> verConPedidos();
}
