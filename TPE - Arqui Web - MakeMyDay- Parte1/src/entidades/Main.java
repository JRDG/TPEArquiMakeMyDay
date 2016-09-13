package entidades;

import utils.*;

public class Main {

	public static void main(String[] args) {
		Servicios s = new Servicios();
		s.inicializarFactory();
		s.cargarDatosEnDB(); //Necesita tener descomentada la linea 36 del persistence 
		s.Listar_Actividades();
		s.ListarUsuarios();
		s.ListarActividadesEntreFechas();
		s.ObtenerEstadisticas();
		s.EliminarDatosDB();
		s.cerrarFactory();
	}

}
