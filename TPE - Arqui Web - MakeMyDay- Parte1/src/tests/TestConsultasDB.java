package tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utils.Servicios;

public class TestConsultasDB {

	private EntityManagerFactory emfactory;
	private EntityManager emanager;
	
	@Before
	public void inicializacion(){
		emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");}
	
	@Test
	public void test() {}
	
	@After
	public void cerrarFactoryYEliminarTablas(){
		emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();	
		
		String jpql1 = "SELECT CONCAT('alter table ',table_name,' drop foreign key ', constraint_name,';') FROM information_schema.key_column_usage WHERE table_schema = 'makemyday' and not (constraint_name like 'primary');";
		String jpql2 = "SELECT CONCAT('drop table ',table_name,'; ') FROM information_schema.tables WHERE table_schema = 'makemyday';"; 		    
	 
		Query q1 = emanager.createNativeQuery(jpql1);
		Query q2 = emanager.createNativeQuery(jpql2); 
    
		List<String> rFK = q1.getResultList();
		List<String> rT = q2.getResultList();

		System.out.println(rFK);
		System.out.println("");
		System.out.println(rT);
		    
		for(String  r : rFK) { 
			Query qAux = emanager.createNativeQuery(r);  
			qAux.executeUpdate();
		}
		for(String  r : rT) { 
		Query qAux = emanager.createNativeQuery(r);  
			qAux.executeUpdate();
		}
		if (emanager != null){
			emanager.close();
		}
		if (emfactory != null){
			emfactory.close();
		}
		
	}

	
}
