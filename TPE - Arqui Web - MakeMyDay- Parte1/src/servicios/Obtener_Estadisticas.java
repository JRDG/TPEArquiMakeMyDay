package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Usuario;

public class Obtener_Estadisticas {

//	comentar linea 34 en persistence para utilizar el servicio
	
	public static void main(String[] args) {
		EntityManagerFactory emfactory = null;		
		EntityManager emanager = null;
	
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
			emanager = emfactory.createEntityManager();
	
			emanager.getTransaction().begin();	
	
	 
		    String jpql = "SELECT AVG(h.nivelFelicidad), MIN(h.nivelFelicidad), MAX(h.nivelFelicidad) FROM Historial_Usuario h WHERE h.usuario.DNI LIKE ?1"; 
		    
		    Query query = emanager.createQuery(jpql).setParameter(1, 58938019); 
		    List<Object[]> resultados = query.getResultList();
		    System.out.println("Estadisticas del Usuario");
	    	System.out.println("Promedio: " + (Double) resultados.get(0)[0]);
	    	System.out.println("Minimo: " + (Double) resultados.get(0)[1]);
	    	System.out.println("Maximo: " + (Double) resultados.get(0)[2]);
 
		    
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
