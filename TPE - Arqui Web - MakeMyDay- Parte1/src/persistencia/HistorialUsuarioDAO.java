package persistencia;


import entidades.HistorialUsuario;

public class HistorialUsuarioDAO extends BaseJPADAO<HistorialUsuario>{

	private static HistorialUsuarioDAO hist;

	private HistorialUsuarioDAO() {
	super(HistorialUsuario.class);
	}
	
	public static HistorialUsuarioDAO getInstance(){
		if(hist==null)
			hist=new HistorialUsuarioDAO();
		return hist;
	}
}
