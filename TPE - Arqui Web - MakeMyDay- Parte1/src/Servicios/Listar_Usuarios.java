package Servicios;

import java.util.List;

import javax.persistence.*;

import Entidades.*;

public class Listar_Usuarios {
	
	
//	comentar linea 34 en persistence para utilizar el servicio
	
	public static void main(String[] args) {
		EntityManagerFactory emfactory = null;		
		EntityManager emanager = null;
	
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
			emanager = emfactory.createEntityManager();
	
			emanager.getTransaction().begin();	
	
	 
		    String jpql = "SELECT u FROM Usuario u"; 
		    Query query = emanager.createQuery(jpql); 
		    List<Usuario> resultados = query.getResultList();
		    for(Usuario  u : resultados) { 
		    	System.out.println(u.toString());    
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
