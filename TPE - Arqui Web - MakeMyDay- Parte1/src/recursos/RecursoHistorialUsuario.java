package recursos;

import java.security.Principal;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import com.sun.security.auth.UserPrincipal;

import entidades.Actividad;
import entidades.HistorialUsuario;
import persistencia.ActividadDAO;
import persistencia.HistorialUsuarioDAO;
import recursos.autorizacion.Secured;
import utils.DatePair;

@Path("/historial_usuario")
public class RecursoHistorialUsuario {
	@Context
	SecurityContext securityContext;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Actividad getActividadById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Actividad act = ActividadDAO.getInstance().findById(id);
		return act;

	}
	
	@POST
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<HistorialUsuario> getActividadesEntreFechas(DatePair datePair){
		Principal up = securityContext.getUserPrincipal();
		String userName = up.getName();
		return HistorialUsuarioDAO.getInstance().buscarEntreFechas(userName,datePair.getFromDate(),datePair.getToDate());
	}
}
