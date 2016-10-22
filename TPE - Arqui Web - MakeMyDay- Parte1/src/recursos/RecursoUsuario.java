package recursos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import entidades.Usuario;
import persistencia.UsuarioDAO;
import recursos.autorizacion.Secured;



@Path("/usuario")
public class RecursoUsuario {
	@Context
	SecurityContext securityContext;
	
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getActividadById() {
		System.out.println(securityContext.getUserPrincipal().getName());
		int id = UsuarioDAO.getInstance().findIdByName(securityContext.getUserPrincipal().getName());
		Usuario u = UsuarioDAO.getInstance().findById(id);
		return u;
	}
	
	/*
	@GET
	//@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getActividadById() {
		List<Usuario> act = UsuarioDAO.getInstance().findAll();
		return act;
	}
	*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registrarUsuario(Usuario u){
		UsuarioDAO.getInstance().persist(u);
		return Response.status(Response.Status.OK).build();
	}
	
	@PUT
	@Secured
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizarUsuario(Usuario u){
		int id = UsuarioDAO.getInstance().findIdByName(securityContext.getUserPrincipal().getName());
		UsuarioDAO.getInstance().update(u,id);
		return Response.status(Response.Status.OK).build();
	}
	
}
