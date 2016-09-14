package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entidades.Actividad;
import entidades.Actividad_Realizada;
import entidades.Historial_Usuario;
import entidades.Tipo_Actividad;
import entidades.Usuario;
import utils.Servicios;

public class TestConsultasDB {

	EntityManagerFactory emfactory;
	EntityManager emanager;
	ArrayList usuarios;
	ArrayList actividades;
	
	/*
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
	
	Actividad_Realizada ar1;
	Actividad_Realizada ar2;
	Actividad_Realizada ar3;
	Actividad_Realizada ar4;
	Actividad_Realizada ar5;
	Actividad_Realizada ar6;
	Actividad_Realizada ar7;
	Actividad_Realizada ar8;
	Actividad_Realizada ar9;
	Actividad_Realizada ar10;
	Actividad_Realizada ar11;
	Actividad_Realizada ar12;
	Actividad_Realizada ar13;
	Actividad_Realizada ar14;
	Actividad_Realizada ar15;
	Actividad_Realizada ar16;
	Actividad_Realizada ar17;
	Actividad_Realizada ar18;
	Actividad_Realizada ar19;
	Actividad_Realizada ar20;
	
	Historial_Usuario h1;
	Historial_Usuario h2;
	Historial_Usuario h3;
	Historial_Usuario h4;
	Historial_Usuario h5;
	Historial_Usuario h6;
	Historial_Usuario h7;
	Historial_Usuario h8;
	Historial_Usuario h9;
	Historial_Usuario h10;
	Historial_Usuario h11;
	Historial_Usuario h12;
	Historial_Usuario h13;
	Historial_Usuario h14;
	Historial_Usuario h15;
	Historial_Usuario h16;
	Historial_Usuario h17;
	Historial_Usuario h18;
	Historial_Usuario h19;
	Historial_Usuario h20;
	*/
	@Before
	public void inicializacion(){
		emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
				//usuarios
				usuarios = new ArrayList<Usuario>(){{
					add(new Usuario("Joa","Quin",35647897,new GregorianCalendar(1994,7,25) ,"2567"));
					add(new Usuario("San","Tiago",38838109,new GregorianCalendar(1995,7,25) ,"2567"));
					add(new Usuario("Vic","Tor",58938019,new GregorianCalendar(1985,7,25) ,"2567"));
					add(new Usuario("Pe","Tuto",38698719,new GregorianCalendar(1955,7,25) ,"2567"));
					add(new Usuario("Tar","ton",3,new GregorianCalendar(1095,7,25) ,"2567"));
					add(new Usuario("Ku","Be",35585462,new GregorianCalendar(1995,9,5) ,"2567"));
					add(new Usuario("Yo","Landa",49836019,new GregorianCalendar(1895,7,25) ,"2567"));
					add(new Usuario("Dar","do",38999019,new GregorianCalendar(1999,7,25) ,"2567"));
					add(new Usuario("Juan","Se",38838019,new GregorianCalendar(1998,7,25) ,"2567"));
					add(new Usuario("Cue","Li",39874519,new GregorianCalendar(1997,7,25) ,"2567"));
				}};

				//para los distintos tests
				/*
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



				//actividades realizadas
				ar1 = new Actividad_Realizada(a1, new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar2 = new Actividad_Realizada(a1, new GregorianCalendar(2016,5,23,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar3 = new Actividad_Realizada(a2, new GregorianCalendar(2016,6,15,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar4 = new Actividad_Realizada(a2, new GregorianCalendar(2016,5,20,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar5 = new Actividad_Realizada(a3, new GregorianCalendar(2016,7,23,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar6 = new Actividad_Realizada(a3, new GregorianCalendar(2016,1,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar7 = new Actividad_Realizada(a4, new GregorianCalendar(2016,9,3,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar8 = new Actividad_Realizada(a4, new GregorianCalendar(2016,10,13,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar9 = new Actividad_Realizada(a5, new GregorianCalendar(2016,4,30,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar10 = new Actividad_Realizada(a5, new GregorianCalendar(2016,8,3,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar11 = new Actividad_Realizada(a6, new GregorianCalendar(2016,3,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar12 = new Actividad_Realizada(a6, new GregorianCalendar(2016,9,4,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar13 = new Actividad_Realizada(a7, new GregorianCalendar(2016,9,6,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar14 = new Actividad_Realizada(a7, new GregorianCalendar(2016,2,3,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar15 = new Actividad_Realizada(a8, new GregorianCalendar(2016,7,31,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar16 = new Actividad_Realizada(a8, new GregorianCalendar(2016,2,4,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar17 = new Actividad_Realizada(a9, new GregorianCalendar(2016,11,19,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar18 = new Actividad_Realizada(a9, new GregorianCalendar(2016,0,6,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar19 = new Actividad_Realizada(a10, new GregorianCalendar(2016,2,28,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				ar20 = new Actividad_Realizada(a10, new GregorianCalendar(2016,6,24,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));

				//historiales de usuario
				h1 = new Historial_Usuario(tar, ar1);
				h1.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h1.setNivelFelicidad(4);
				h2 = new Historial_Usuario(tar, ar2);
				h2.setFecha_fin(new GregorianCalendar(2016,1,6,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h2.setNivelFelicidad(3);
				h3 = new Historial_Usuario(tar, ar3);
				h3.setFecha_fin(new GregorianCalendar(2016,8,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h3.setNivelFelicidad(3);
				h4 = new Historial_Usuario(tar, ar4);
				h4.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h4.setNivelFelicidad(4);
				h5 = new Historial_Usuario(tar, ar5);
				h5.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h5.setNivelFelicidad(5);
				h6 = new Historial_Usuario(tar, ar6);
				h6.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h6.setNivelFelicidad(1);
				h7 = new Historial_Usuario(tar, ar7);
				h7.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h7.setNivelFelicidad(2);
				h8 = new Historial_Usuario(tar, ar8);
				h8.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h8.setNivelFelicidad(3);
				h9 = new Historial_Usuario(tar, ar9);
				h9.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h9.setNivelFelicidad(4);
				h10 = new Historial_Usuario(tar, ar10);
				h10.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h10.setNivelFelicidad(5);
				h11 = new Historial_Usuario(tar, ar11);
				h11.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h11.setNivelFelicidad(1);
				h12 = new Historial_Usuario(tar, ar12);
				h12.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h12.setNivelFelicidad(2);
				h13 = new Historial_Usuario(tar, ar13);
				h13.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h13.setNivelFelicidad(3);
				h14 = new Historial_Usuario(tar, ar14);
				h14.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h14.setNivelFelicidad(4);
				h15 = new Historial_Usuario(tar, ar15);
				h15.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h15.setNivelFelicidad(5);
				h16 = new Historial_Usuario(tar, ar16);
				h16.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h16.setNivelFelicidad(1);
				h17 = new Historial_Usuario(tar, ar17);
				h17.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h17.setNivelFelicidad(2);
				h18 = new Historial_Usuario(tar, ar18);
				h18.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h18.setNivelFelicidad(3);
				h19 = new Historial_Usuario(tar, ar19);
				h19.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h19.setNivelFelicidad(4);
				h20 = new Historial_Usuario(tar, ar20);
				h20.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
				h20.setNivelFelicidad(5);
		*/
		}
	
	@Test
	public void ListarUsuarios(){
		emanager = emfactory.createEntityManager();
		String jpql = "SELECT u FROM Usuario u"; 
		Query query = emanager.createQuery(jpql); 
		List<Usuario> resultados = query.getResultList();
		System.out.println(usuarios.size());
		System.out.println(resultados);
		for (int i = 0; i < resultados.size(); i++) {
			assertEquals(usuarios.get(i), resultados.get(i));
		}
		
	}
	
	
	
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
