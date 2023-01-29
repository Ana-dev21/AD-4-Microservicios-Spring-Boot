package com.edix.microservicios.model.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edix.microservicios.model.Response;
import com.edix.microservicios.model.entities.Comercial;
import com.edix.microservicios.model.entities.Pedido;
import com.edix.microservicios.model.service.Interface.IClienteService;
import com.edix.microservicios.model.service.Interface.IComercialService;
import com.edix.microservicios.model.service.Interface.IPedidoService;
import com.edix.microservicios.utils.StatusCrudEntity;

/**
 * La función de esta clase es contenter las comprobaciones requeridas por la lógica 
 * de negocio en las que tenga que intervenir más de un Service de una entidad distinta
 *
 */
@Component
public class GestionManager {
	
	@Autowired
	IPedidoService peService;
	
	@Autowired
	IComercialService coService;
	
	@Autowired
	IClienteService cliService;
	
	/**
	 * Devolver los datos del comercial cuyo id coincida
	 * @param idComercial
	 * @return Comercial
	 */
	public Response<Comercial> verUno(int idComercial) {
			
		Response<Comercial> rs = new Response<Comercial>();
			
		try {				
			Comercial comercial = coService.verUno(idComercial);
			rs.setData(comercial);
			rs.setStatus(StatusCrudEntity.OK.name());
				
		}catch (Exception e) {
			rs.setStatus(StatusCrudEntity.Error.name());
			rs.setMessage(e.getMessage());
		}
			
		return rs;
			
	}
	
	/**
	 * Comprueba si el comercial existe. Si existe devuelve la lista de pedidos gestionados por ese comercial 
	 * si no existe, devuelve una excepción controlada 
	 * @param idComercial
	 * @return Response con Lista de pedidos si el comercial pasado por parámetro existe
	 * @throws Exception 
	 */
	public List<Pedido> verPedidosPorComercial(int idComercial) throws Exception {		
		coService.verUno(idComercial);
		List<Pedido> pedidos = peService.verPorComercial(idComercial);
		return pedidos;		
	}
	
	/**
	 * Devolver la lista de los comerciales que han atendido pedidos 
	 * del cliente que coincida con ese id.
	 * @param idCliente
	 * @return
	 * @throws Exception 
	 */
	public List<Comercial> verPorCliente(int idCliente) throws Exception {
		cliService.verUno(idCliente); 
		List<Comercial> comerciales = coService.verPorCliente(idCliente);						
		return comerciales;
	}

	/**
	 * Devolver la lista de comerciales que han atendido algún pedido
	 * @return
	 */
	public List<Comercial> verConPedidos() {

		return  coService.verConPedidos();

	}
	
	
}
