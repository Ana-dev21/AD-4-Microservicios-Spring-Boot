package com.edix.microservicios.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edix.microservicios.model.Response;
import com.edix.microservicios.model.entities.Comercial;
import com.edix.microservicios.model.entities.Pedido;
import com.edix.microservicios.model.manager.GestionManager;
import com.edix.microservicios.model.service.Interface.IComercialService;
import com.edix.microservicios.utils.StatusCrudEntity;

@RestController
@RequestMapping("/comercial")
public class GestionRestController {
	
	@Autowired 
	private IComercialService coService;
		
	@Autowired
	private GestionManager geManager;
	
	/**
	 * Dar de alta el comercial
	 * @param Comercial
	 * @return Comercial
	 */
	@PostMapping("/alta")
	public Response<Comercial> altaComercial(@RequestBody Comercial comercial) {
		Comercial comercialAux = null;
		Response<Comercial> rs = new Response<>();
		
		try {	
			comercialAux = coService.altaComercial(comercial);
			rs.setData(comercialAux);
			rs.setStatus(StatusCrudEntity.OK.name());			
		}catch (Exception e) {
			rs.setStatus(StatusCrudEntity.Error.name());
			rs.setMessage(e.getMessage()); 
		}
		 		
		return rs;
	}
	
	/**
	 * Eliminar de la bbdd el comercial cuyo id coincida
	 * @param idComercial
	 * @return true si se ha podido eliminar, false si no existe el comercial
	 */
	@GetMapping("/eliminar/{id}")
	public Response<String> eliminar(@PathVariable("id") int idComercial) {
		Response<String> rs = new Response<>();	
		try {
			coService.eliminarComercial(idComercial);
			rs.setStatus(StatusCrudEntity.OK.name());
			rs.setMessage("El comercial se ha eliminado correctamente");
				
		} catch (Exception e) {
			rs.setStatus(StatusCrudEntity.Error.name());
			rs.setMessage(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * Devolver los datos del comercial cuyo id coincida
	 * @param idComercial
	 * @return Comercial
	 * @throws Exception Si el comercial no existe
	 */
	@GetMapping("/uno/{id}")
	public 	Response<Comercial> verComercial(@PathVariable("id") int idComercial) throws Exception{
		
		Response<Comercial> rs = new Response<>();	
		try {
			Comercial comercial = coService.verUno(idComercial);
			rs.setStatus(StatusCrudEntity.OK.name());
			rs.setData(comercial);
				
		} catch (Exception e) {
			rs.setStatus(StatusCrudEntity.Error.name());
			rs.setMessage(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * Devuelve la lista de los comerciales que han atendido pedidos del 
	 * cliente que coincida con ese id.
	 * @param idCliente
	 * @return lista de comerciales 
	 */
	@GetMapping("bycliente/{id}")
	public Response<List<Comercial>> verComercialPorCliente(@PathVariable("id") int idCliente){
		
		Response<List<Comercial>> rs = new Response<>();	
		try {
			List<Comercial> comerciales = geManager.verPorCliente(idCliente);
			rs.setStatus(StatusCrudEntity.OK.name());
			rs.setData(comerciales);
				
		} catch (Exception e) {
			rs.setStatus(StatusCrudEntity.Error.name());
			rs.setMessage(e.getMessage());
		}
		return rs;
	}
	
	/**
	 * Devolver la lista de comerciales que han atendido algún pedido
	 * @return Lista de Comerciales con pedidos
	 */
	@GetMapping("/conpedidos")
	public Response<List<Comercial>> verComercialesConPedidos(){
		
		Response<List<Comercial>> rs = new Response<>();	
		try {
			List<Comercial> comerciales = geManager.verConPedidos();
			rs.setStatus(StatusCrudEntity.OK.name());
			rs.setData(comerciales);				
		} catch (Exception e) {
			rs.setStatus(StatusCrudEntity.Error.name());
			rs.setMessage(e.getMessage());
		}
		return rs;
			
		
	}
	
	/**
	 * Devuelve la lista de pedidos gestionados por el comercial 
	 * que coincida con ese id.
	 * @param idComercial
	 * @return lista de pedidos
	 */
	@GetMapping("/pedidos/{id}")
	public Response<List<Pedido>> verPedidosPorComercial(@PathVariable("id") int idComercial){
		Response<List<Pedido>> rs = new Response<>();	
		try {
			List<Pedido> pedidos = geManager.verPedidosPorComercial(idComercial);
			rs.setStatus(StatusCrudEntity.OK.name());
			rs.setData(pedidos);
				
		} catch (Exception e) {
			rs.setStatus(StatusCrudEntity.Error.name());
			rs.setMessage(e.getMessage());
		}
		return rs;
				
	}
	
	
	
	
	
	

}
