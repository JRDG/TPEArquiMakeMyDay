package servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Eliminar_Datos_DB {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = null;	
		EntityManager emanager = null;
	
		try {
			
			emfactory = Persistence.createEntityManagerFactory("objectdb:makemyday.sql;drop");
			emanager = emfactory.createEntityManager();
			
			emanager.getTransaction().begin();		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (emanager != null)
				emanager.close();
			if (emfactory != null)
				emfactory.close();
		}
	}			
		
		
		

}


