package recursos;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entidades.Usuario;
import persistencia.UsuarioDAO;
import recursos.autorizacion.Secured;



@Path("/usuario")
public class RecursoUsuario {
	@GET
	@Secured
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getActividadById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Usuario u = UsuarioDAO.getInstance().findById(id);
		return u;
	}
	
	@GET
	@Secured
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getActividadById() {
		List<Usuario> act = UsuarioDAO.getInstance().findAll();
		return act;
	}
}
