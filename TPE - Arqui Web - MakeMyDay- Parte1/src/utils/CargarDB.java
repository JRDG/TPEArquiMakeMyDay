package utils;

public class Main {

	public static void main(String[] args) {
		ConsultasUtil consultas = ConsultasUtil.getInstance();
		consultas.cargarDatosEnDB();
		consultas.listarActividades();
		consultas.listarUsuarios();
		consultas.listarActividadesEntreFechas();
		consultas.obtenerEstadisticas();
		//consultas.eliminarDatosDB();
		consultas.cerrarFactory();
	}

}
