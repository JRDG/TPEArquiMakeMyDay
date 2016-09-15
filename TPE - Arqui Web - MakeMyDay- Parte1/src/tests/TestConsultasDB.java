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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entidades.Actividad;
import entidades.Actividad_Realizada;
import entidades.Historial_Usuario;
import entidades.Tipo_Actividad;
import entidades.Usuario;
import utils.Servicios;

public class TestConsultasDB {

	private static EntityManagerFactory emfactory;
	private static EntityManager emanager;
	
	static 	ArrayList usuarios;
	static 	ArrayList actividades;
	static 	ArrayList estadisticas;
	static 	ArrayList actividadesEntreFechas;
	static 	double min;
	static 	double max;
	static 	double avg;
	
	
	static 	Usuario joa;
	static 	Usuario san;
	static 	Usuario vic;
	static 	Usuario pe;
	static 	Usuario tar;
	static 	Usuario ku;
	static 	Usuario yo;
	static 	Usuario dar;
	static	Usuario juan;
	static 	Usuario cue;
	
	static 	Tipo_Actividad outdoor;
	static	Tipo_Actividad indoor;
	static 	Tipo_Actividad academico;
	static 	Tipo_Actividad deporte;
	static 	Tipo_Actividad ocio;
	
	static 	Actividad a1;
	static 	Actividad a2;
	static 	Actividad a3;
	static 	Actividad a4;
	static 	Actividad a5;
	static 	Actividad a6;
	static 	Actividad a7;
	static 	Actividad a8;
	static 	Actividad a9;
	static 	Actividad a10;
	
	static 	Actividad_Realizada ar1;
	static 	Actividad_Realizada ar2;
	static 	Actividad_Realizada ar3;
	static 	Actividad_Realizada ar4;
	static 	Actividad_Realizada ar5;
	static 	Actividad_Realizada ar6;
	static 	Actividad_Realizada ar7;
	static 	Actividad_Realizada ar8;
	static 	Actividad_Realizada ar9;
	static 	Actividad_Realizada ar10;
	static 	Actividad_Realizada ar11;
	static 	Actividad_Realizada ar12;
	static 	Actividad_Realizada ar13;
	static 	Actividad_Realizada ar14;
	static 	Actividad_Realizada ar15;
	static 	Actividad_Realizada ar16;
	static 	Actividad_Realizada ar17;
	static 	Actividad_Realizada ar18;
	static 	Actividad_Realizada ar19;
	static 	Actividad_Realizada ar20;
	
	static 	Historial_Usuario h1;
	static 	Historial_Usuario h2;
	static 	Historial_Usuario h3;
	static 	Historial_Usuario h4;
	static 	Historial_Usuario h5;
	static 	Historial_Usuario h6;
	static 	Historial_Usuario h7;
	static 	Historial_Usuario h8;
	static 	Historial_Usuario h9;
	static 	Historial_Usuario h10;
	static	Historial_Usuario h11;
	static 	Historial_Usuario h12;
	static 	Historial_Usuario h13;
	static 	Historial_Usuario h14;
	static	Historial_Usuario h15;
	static 	Historial_Usuario h16;
	static	Historial_Usuario h17;
	static	Historial_Usuario h18;
	static	Historial_Usuario h19;
	static	Historial_Usuario h20;
	
	@BeforeClass
	public static void inicializacion(){
		emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
				//usuarios
				joa = new Usuario("Joa","Quin",35647897,new GregorianCalendar(1994,7,25) ,"2567");
				san = new Usuario("San","Tiago",38838109,new GregorianCalendar(1995,7,25) ,"2567");
				vic = new Usuario("Vic","Tor",58938019,new GregorianCalendar(1985,7,25) ,"2567");
				pe = new Usuario("Pe","Tuto",38698719,new GregorianCalendar(1955,7,25) ,"2567");
				tar = new Usuario("Tar","ton",3,new GregorianCalendar(1095,7,25) ,"2567");
				ku = new Usuario("Ku","Be",35585462,new GregorianCalendar(1995,9,5) ,"2567");
				yo = new Usuario("Yo","Landa",49836019,new GregorianCalendar(1895,7,25) ,"2567");
				dar = new Usuario("Dar","do",38999019,new GregorianCalendar(1999,7,25) ,"2567");
				juan = new Usuario("Juan","Se",38838019,new GregorianCalendar(1998,7,25) ,"2567");
				cue = new Usuario("Cue","Li",39874519,new GregorianCalendar(1997,7,25) ,"2567");
				usuarios = new ArrayList<Usuario>();
				usuarios.add(joa);
				usuarios.add(san);
				usuarios.add(vic);
				usuarios.add(pe);
				usuarios.add(tar);
				usuarios.add(ku);
				usuarios.add(yo);
				usuarios.add(dar);
				usuarios.add(juan);
				usuarios.add(cue);
				//para los distintos tests
				
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
				actividades = new ArrayList<Actividad>();
				actividades.add(a1);
				actividades.add(a2);
				actividades.add(a3);
				actividades.add(a4);
				actividades.add(a5);
				actividades.add(a6);
				actividades.add(a7);
				actividades.add(a8);
				actividades.add(a9);
				actividades.add(a10);
				


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
				
				min = 1;
				max = 5;
				avg = 3.2;
				
				actividadesEntreFechas = new ArrayList<Actividad_Realizada>();
				actividadesEntreFechas.add(ar2);
		}
	
	@Test
	public void ListarUsuarios(){
		emanager = emfactory.createEntityManager();
		String jpql = "SELECT u FROM Usuario u"; 
		Query query = emanager.createQuery(jpql); 
		List<Usuario> resultados = query.getResultList();
		assertEquals(usuarios, resultados);
	}
	
	public void Listar_Actividades(){
	    emanager = emfactory.createEntityManager();
		String jpql = "SELECT a FROM Actividad a"; 
		Query query = emanager.createQuery(jpql); 
		List<Actividad> resultados = query.getResultList();
		assertEquals(actividades, resultados);
	}
	
	public void ListarActividadesEntreFechas(){
		emanager = emfactory.createEntityManager();
		String usuario = "tar";
		Calendar fecha1 = new GregorianCalendar(2015,7,1);
		Calendar fecha2 = new GregorianCalendar(2016,4,30);
		String jpql = "SELECT h.actividad FROM Historial_Usuario h WHERE h.usuario.nombre = ?1 AND (h.actividad.fecha_realizada > ?2 AND h.fecha_fin < ?3)"; 
		Query query = emanager.createQuery(jpql).setParameter(1, usuario).setParameter(2,fecha1).setParameter(3,fecha2); 
		List<Actividad_Realizada> resultados = query.getResultList();
		assertEquals(actividadesEntreFechas, resultados);
	}
	
	public void ObtenerEstadisticas(){
		emanager = emfactory.createEntityManager();
		String jpql = "SELECT AVG(h.nivelFelicidad), MIN(h.nivelFelicidad), MAX(h.nivelFelicidad) FROM Historial_Usuario h WHERE h.usuario.DNI LIKE ?1"; 
		Query query = emanager.createQuery(jpql).setParameter(1, 3); 
		List<Object[]> resultados = query.getResultList();
		
		assertEquals((Double)resultados.get(0)[0], avg,1e-6);
		assertEquals((Double)resultados.get(0)[1], min,1e-6);
		assertEquals((Double)resultados.get(0)[2], max,1e-6);
	}
	
	
	@AfterClass
	public static void cerrarFactoryYEliminarTablas(){
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
