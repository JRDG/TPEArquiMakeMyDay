package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.*;

import entidades.Actividad;
import entidades.Tipo_Actividad;
import entidades.Usuario;

public class TestCargarActividades {

	static EntityManagerFactory emfactory;
	static EntityManager emanager;
	
	static Tipo_Actividad outdoor;
	static Tipo_Actividad indoor;
	static Tipo_Actividad academico;
	static Tipo_Actividad deporte;
	static Tipo_Actividad ocio;
	
	static Actividad a1;
	static Actividad a2;
	static Actividad a3;
	static Actividad a4;
	static Actividad a5;
	static Actividad a6;
	static Actividad a7;
	static Actividad a8;
	static Actividad a9;
	static Actividad a10;
	
	@BeforeClass
	public static void inicializacion() {
		emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
		
		emanager = emfactory.createEntityManager();
		String jpql = "SELECT t FROM Tipo_Actividad t"; 
		Query query = emanager.createQuery(jpql); 
		List<Tipo_Actividad> resultados = query.getResultList();
		
		outdoor = resultados.get(0);
		indoor = resultados.get(1);
		academico = resultados.get(2);
		deporte = resultados.get(3);
		ocio = resultados.get(4);
		
		//actividades
		a1 = new Actividad("Cazar Pokemon", new ArrayList<Tipo_Actividad>(){{
			add(ocio);
			add(outdoor);
		}});
		a2 = new Actividad("Comer Helado", new ArrayList<Tipo_Actividad>(){{
			add(ocio);
			add(outdoor);
		}});
		a3 = new Actividad("Jugar al futbol", new ArrayList<Tipo_Actividad>(){{
			add(ocio);
			add(outdoor);
			add(deporte);
		}});
		a4 = new Actividad("Trabajar", new ArrayList<Tipo_Actividad>(){{
			add(indoor);
		}});
		a5 = new Actividad("Ir a cursar", new ArrayList<Tipo_Actividad>(){{
			add(indoor);
			add(academico);
		}});
		a6 = new Actividad("Comer facturas", new ArrayList<Tipo_Actividad>(){{
			add(ocio);
			add(indoor);
		}});
		a7 = new Actividad("Hacer el tpe de arqui", new ArrayList<Tipo_Actividad>(){{
			add(indoor);
			add(academico);
		}});
		a8 = new Actividad("Evoluciona pokemones", new ArrayList<Tipo_Actividad>(){{
			add(ocio);
			add(indoor);
		}});
		a9 = new Actividad("Ir al GYM", new ArrayList<Tipo_Actividad>(){{
			add(ocio);
			add(indoor);
		}});
		a10 = new Actividad("Correr", new ArrayList<Tipo_Actividad>(){{
			add(ocio);
			add(outdoor);
			add(deporte);
		}});
	}
	
	@Test
	public void testCargarActividades() {
		emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
		emanager.persist(a1);
		emanager.persist(a2);
		emanager.persist(a3);
		emanager.persist(a4);
		emanager.persist(a5);
		emanager.persist(a6);
		emanager.persist(a7);
		emanager.persist(a8);
		emanager.persist(a9);
		emanager.persist(a10);
		emanager.getTransaction().commit();
		if (emanager != null){
			emanager.close();
		}	
	}
	
	@AfterClass
	public static void cerrarFactory(){
		if (emfactory != null){
			emfactory.close();
		}	
	}


}
