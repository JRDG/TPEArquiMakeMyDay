package entidades;

import utils.*;

public class Main {

	public static void main(String[] args) {
		Llenar_DB c = new Llenar_DB();
		c.inicializarFactory();
		c.cargar(); //Necesita tener descomentada la linea 36 del persistence 
		c.cerrarFactory();
		/*Search_Utils s = new Search_Utils();
		s.inicializarFactory();
		s.Listar_Actividades();
		s.ListarUsuarios();
		s.ListarActividadesEntreFechas();
		s.ObtenerEstadisticas();
		s.cerrarFactory();*/
	}

}
