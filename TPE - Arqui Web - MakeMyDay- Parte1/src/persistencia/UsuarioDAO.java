package persistencia;

import entidades.Usuario;

public class UsuarioDAO extends BaseJPADAO<Usuario>{

	private static UsuarioDAO uDao;

	private UsuarioDAO() {
		super(Usuario.class);
	}
	
	public static UsuarioDAO getInstance(){
		if(uDao==null)
			uDao = new UsuarioDAO();
		return uDao;
	}
 
}
