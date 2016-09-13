package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.*;

import entidades.Actividad;
import entidades.Tipo_Actividad;
import entidades.Usuario;

public class TestCargarActividades {

	EntityManagerFactory emfactory;
	EntityManager emanager;
	
	Tipo_Actividad outdoor;
	Tipo_Actividad indoor;
	Tipo_Actividad academico;
	Tipo_Actividad deporte;
	Tipo_Actividad ocio;
	
	Actividad a1;
	Actividad a2;
	Actividad a3;
	Actividad a4;
	Actividad a5;
	Actividad a6;
	Actividad a7;
	Actividad a8;
	Actividad a9;
	Actividad a10;
	
	@Before
	public void inicializacion() {
		emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
		
		//tipos
		outdoor = new Tipo_Actividad("outdoor");
		indoor = new Tipo_Actividad("indoor");
		academico = new Tipo_Actividad("academico");
		deporte = new Tipo_Actividad("deporte");
		ocio = new Tipo_Actividad("ocio");

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

}
