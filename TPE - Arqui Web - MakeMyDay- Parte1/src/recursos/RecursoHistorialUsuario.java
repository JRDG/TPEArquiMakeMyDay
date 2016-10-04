package recursos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entidades.Actividad;
import persistencia.ActividadDAO;

@Path("/historial_usuario")
public class RecursoHistorialUsuario {
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Actividad getActividadById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Actividad act = ActividadDAO.getInstance().findById(id);
		return act;

	}
	
	
	
}
