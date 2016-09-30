package recursos;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entidades.Actividad;
import entidades.TipoActividad;
import persistencia.ActividadDAO;
import persistencia.TipoActividadDAO;

@Path("/tipo_actividad")
public class RecursoTipoActividad {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoActividad getActividadById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		TipoActividad tact = TipoActividadDAO.getInstance().findById(id);
		return tact;

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoActividad> getActividadById() {
		List<TipoActividad> act = TipoActividadDAO.getInstance().findAll();
		return act;
	}
	
}
