package entidades;

import utils.Llenar_DB;

public class Main {

	public static void main(String[] args) {
		Llenar_DB c = new Llenar_DB();
		c.cargar(args); //Necesita tener descomentada la linea 36 del persistence 
	}

}
