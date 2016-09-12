package servicios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Usuario;


public class Eliminar_Datos_DB {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = null;		
		EntityManager emanager = null;
	
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
			emanager = emfactory.createEntityManager();
	
			emanager.getTransaction().begin();	
	
	 
		    String jpql1 = "SELECT CONCAT('drop table ',table_name,'; ') FROM information_schema.tables WHERE table_schema = 'makemyday';"; 
//		    String jpql2 = "SELECT CONCAT('alter table ' ,table_name, ' DROP INDEX 'tablename FROM information_schema.keycolumnusage WHERE referencedtablename ='$t'"
		    
		    Query query = emanager.createNativeQuery(jpql1); 
		    List<String> resultados = query.getResultList(); 
		    for(String  r : resultados) { 
		    	Query query2 = emanager.createNativeQuery(r);  
		    	query2.executeUpdate();
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


