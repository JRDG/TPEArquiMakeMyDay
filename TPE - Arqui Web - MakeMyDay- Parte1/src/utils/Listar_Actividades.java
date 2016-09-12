package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Actividad;

public class Listar_Actividades {
	
	public static void main(String[] args) {
		EntityManagerFactory emfactory = null;
		EntityManager emanager = null;
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
			emanager = emfactory.createEntityManager();

	        String jpql = "SELECT a FROM Actividad a"; 
	        Query query = emanager.createQuery(jpql); 
	        List<Actividad> resultados = query.getResultList();
	        for(Actividad  r : resultados) { 
	        	System.out.println(r.toString());
	        } 
			
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
