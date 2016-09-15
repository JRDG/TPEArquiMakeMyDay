package tests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import entidades.Tipo_Actividad;

public class TestCargarTipoActividades {

	private static EntityManagerFactory emfactory;
	private EntityManager emanager;
	
	static Tipo_Actividad outdoor;
	static Tipo_Actividad indoor;
	static Tipo_Actividad academico;
	static Tipo_Actividad deporte;
	static Tipo_Actividad ocio;

	
	
	@Before
	public void Before(){
		emanager = emfactory.createEntityManager();
	}
	@After
	public void After(){
		if (emanager != null){
			emanager.close();
		}	
	}

	@BeforeClass
	public static void init(){
		emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
		
		outdoor = new Tipo_Actividad("outdoor");
		indoor = new Tipo_Actividad("indoor");
		academico = new Tipo_Actividad("academico");
		deporte = new Tipo_Actividad("deporte");
		ocio = new Tipo_Actividad("ocio");
	}
	
	
	@Test
	public void test() {
		emanager.getTransaction().begin();		
		emanager.persist(outdoor);
		emanager.persist(indoor);
		emanager.persist(academico);
		emanager.persist(deporte);
		emanager.persist(ocio);
		emanager.getTransaction().commit();
	}
	
	
	@AfterClass
	public static void cerrarFactory(){
		if (emfactory != null){
			emfactory.close();
		}	
	}

}
