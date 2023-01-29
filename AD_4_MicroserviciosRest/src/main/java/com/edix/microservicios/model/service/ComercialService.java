package com.edix.microservicios.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edix.microservicios.model.entities.Comercial;
import com.edix.microservicios.model.repository.ComercialRepository;
import com.edix.microservicios.model.service.Interface.IComercialService;


@Service
public class ComercialService implements IComercialService{
	
	@Autowired
	ComercialRepository coRepo;

	/**
	 * Da de alta un comercial con los datos pasados por parámetro
	 * @throws Exception Si no se indican los datos obligatorios del Comercial (Nombre y Apellido1)
	 */
	@Override
	public Comercial altaComercial(Comercial comercial) throws Exception {
		if ( comercial.getApellido1() != null 
			&& comercial.getNombre() != null){
			return coRepo.save(comercial);
		}else {
			throw new Exception("Faltan campos obligatorios del Comercial. Nombre y Apellido1 son obligatorios");
		}
	}		
		
	/**
	 * Elimina un comercial con los datos pasados por parámetro
	 * @throws Exception si el comercial indicado no existe
	 */
	@Override
	public void eliminarComercial(int idComercial) throws Exception {
		verUno(idComercial); 
		coRepo.deleteById(idComercial);	
	}

	/**
	 * Comprueba si el comercial existe. Si existe lo devuelve, sino lanza una excepción
	 * @throws Exception si el comercial indicado no existe
	 */
	@Override
	public Comercial verUno(int idComercial) throws Exception {
		
		Comercial comercial = coRepo.findById(idComercial).orElse(null);
		if (comercial == null) throw new Exception("El comecial indicado no existe");
		return comercial;
		
	}

	/**
	 * Devolver la lista de los comerciales que han atendido pedidos 
	 * del cliente que coincida con ese id.
	 * @param idCliente
	 * @return lista de comerciales
	 */
	@Override
	public List<Comercial> verPorCliente(int idCliente) {
		
		return coRepo.verPorCliente(idCliente);
	}

	/**
	 * Devolver la lista de comerciales que han atendido algún pedido
	 * @return
	 */
	@Override
	public List<Comercial> verConPedidos() {
		
		return coRepo.verConPedidos();
	}

}
