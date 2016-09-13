package utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Actividad;
import entidades.Actividad_Realizada;
import entidades.Historial_Usuario;
import entidades.Tipo_Actividad;
import entidades.Usuario;

public class Servicios {

	private EntityManagerFactory emfactory;
	private EntityManager emanager;
	
	public Servicios(){
		emfactory = null;
		emanager = null;
	}

	public void inicializarFactory(){
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarFactory(){
		if (emfactory != null){
			emfactory.close();
		}	
	}
	
	public void ListarActividadesEntreFechas(){
		emanager = emfactory.createEntityManager();
		String usuario = "tar";
		Calendar fecha1 = new GregorianCalendar(2015,7,1);
		Calendar fecha2 = new GregorianCalendar(2016,4,30);
	    String jpql = "SELECT h.actividad FROM Historial_Usuario h WHERE h.usuario.nombre = ?1 AND (h.actividad.fecha_realizada > ?2 AND h.fecha_fin < ?3)"; 
		Query query = emanager.createQuery(jpql).setParameter(1, usuario).setParameter(2,fecha1).setParameter(3,fecha2); 
	    List<Actividad_Realizada> resultados = query.getResultList();
	    for(Actividad_Realizada  r : resultados) { 
	       	System.out.println(r);
	    } 
		if (emanager != null){
			emanager.close();
		}	
	}
	
	public void Listar_Actividades(){
		emanager = emfactory.createEntityManager();
	    String jpql = "SELECT a FROM Actividad a"; 
	    Query query = emanager.createQuery(jpql); 
	    List<Actividad> resultados = query.getResultList();
	    for(Actividad  r : resultados) { 
	    	System.out.println(r.toString());
	    } 
		if (emanager != null){
			emanager.close();
		}
	}
	
	public void ListarUsuarios(){
		emanager = emfactory.createEntityManager();
	    String jpql = "SELECT u FROM Usuario u"; 
	    Query query = emanager.createQuery(jpql); 
	    List<Usuario> resultados = query.getResultList();
	    for(Usuario  u : resultados) { 
		    System.out.println(u.toString());    
		} 
		if (emanager != null){
			emanager.close();
		}		
	}
	
	public void ObtenerEstadisticas(){
		emanager = emfactory.createEntityManager();
		String jpql = "SELECT AVG(h.nivelFelicidad), MIN(h.nivelFelicidad), MAX(h.nivelFelicidad) FROM Historial_Usuario h WHERE h.usuario.DNI LIKE ?1"; 
		Query query = emanager.createQuery(jpql).setParameter(1, 3); 
		List<Object[]> resultados = query.getResultList();
		System.out.println("Estadisticas del Usuario");
	    System.out.println("Promedio: " + (Double) resultados.get(0)[0]);
	   	System.out.println("Minimo: " + (Double) resultados.get(0)[1]);
	   	System.out.println("Maximo: " + (Double) resultados.get(0)[2]);
		if (emanager != null){
			emanager.close();
		}	
	}
	
	@SuppressWarnings("serial")
	public void cargarDatosEnDB() {
			emanager = emfactory.createEntityManager();
			emanager.getTransaction().begin();
			//usuarios
			Usuario joa = new Usuario("Joa","Quin",35647897,new GregorianCalendar(1994,7,25) ,"2567");
			Usuario san = new Usuario("San","Tiago",38838109,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario vic = new Usuario("Vic","Tor",58938019,new GregorianCalendar(1985,7,25) ,"2567");
			Usuario pe = new Usuario("Pe","Tuto",38698719,new GregorianCalendar(1955,7,25) ,"2567");
			Usuario tar = new Usuario("Tar","ton",3,new GregorianCalendar(1095,7,25) ,"2567");
			Usuario ku = new Usuario("Ku","Be",35585462,new GregorianCalendar(1995,9,5) ,"2567");
			Usuario yo = new Usuario("Yo","Landa",49836019,new GregorianCalendar(1895,7,25) ,"2567");
			Usuario dar = new Usuario("Dar","do",38999019,new GregorianCalendar(1999,7,25) ,"2567");
			Usuario juan = new Usuario("Juan","Se",38838019,new GregorianCalendar(1998,7,25) ,"2567");
			Usuario cue = new Usuario("Cue","Li",39874519,new GregorianCalendar(1997,7,25) ,"2567");

			//tipos
			Tipo_Actividad outdoor = new Tipo_Actividad("outdoor");
			Tipo_Actividad indoor = new Tipo_Actividad("indoor");
			Tipo_Actividad academico = new Tipo_Actividad("academico");
			Tipo_Actividad deporte = new Tipo_Actividad("deporte");
			Tipo_Actividad ocio = new Tipo_Actividad("ocio");



			//actividades
			Actividad a1 = new Actividad("Cazar Pokemon", new ArrayList<Tipo_Actividad>(){{
				add(ocio);
				add(outdoor);
			}});
			Actividad a2 = new Actividad("Comer Helado", new ArrayList<Tipo_Actividad>(){{
				add(ocio);
				add(outdoor);
			}});
			Actividad a3 = new Actividad("Jugar al futbol", new ArrayList<Tipo_Actividad>(){{
				add(ocio);
				add(outdoor);
				add(deporte);
			}});
			Actividad a4 = new Actividad("Trabajar", new ArrayList<Tipo_Actividad>(){{
				add(indoor);
			}});
			Actividad a5 = new Actividad("Ir a cursar", new ArrayList<Tipo_Actividad>(){{
				add(indoor);
				add(academico);
			}});
			Actividad a6 = new Actividad("Comer facturas", new ArrayList<Tipo_Actividad>(){{
				add(ocio);
				add(indoor);
			}});
			Actividad a7 = new Actividad("Hacer el tpe de arqui", new ArrayList<Tipo_Actividad>(){{
				add(indoor);
				add(academico);
			}});
			Actividad a8 = new Actividad("Evoluciona pokemones", new ArrayList<Tipo_Actividad>(){{
				add(ocio);
				add(indoor);
			}});
			Actividad a9 = new Actividad("Ir al GYM", new ArrayList<Tipo_Actividad>(){{
				add(ocio);
				add(indoor);
			}});
			Actividad a10 = new Actividad("Correr", new ArrayList<Tipo_Actividad>(){{
				add(ocio);
				add(outdoor);
				add(deporte);
			}});



			//actividades realizadas
			Actividad_Realizada ar1 = new Actividad_Realizada(a1, new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar2 = new Actividad_Realizada(a1, new GregorianCalendar(2016,5,23,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar3 = new Actividad_Realizada(a2, new GregorianCalendar(2016,6,15,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar4 = new Actividad_Realizada(a2, new GregorianCalendar(2016,5,20,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar5 = new Actividad_Realizada(a3, new GregorianCalendar(2016,7,23,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar6 = new Actividad_Realizada(a3, new GregorianCalendar(2016,1,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar7 = new Actividad_Realizada(a4, new GregorianCalendar(2016,9,3,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar8 = new Actividad_Realizada(a4, new GregorianCalendar(2016,10,13,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar9 = new Actividad_Realizada(a5, new GregorianCalendar(2016,4,30,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar10 = new Actividad_Realizada(a5, new GregorianCalendar(2016,8,3,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar11 = new Actividad_Realizada(a6, new GregorianCalendar(2016,3,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar12 = new Actividad_Realizada(a6, new GregorianCalendar(2016,9,4,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar13 = new Actividad_Realizada(a7, new GregorianCalendar(2016,9,6,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar14 = new Actividad_Realizada(a7, new GregorianCalendar(2016,2,3,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar15 = new Actividad_Realizada(a8, new GregorianCalendar(2016,7,31,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar16 = new Actividad_Realizada(a8, new GregorianCalendar(2016,2,4,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar17 = new Actividad_Realizada(a9, new GregorianCalendar(2016,11,19,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar18 = new Actividad_Realizada(a9, new GregorianCalendar(2016,0,6,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar19 = new Actividad_Realizada(a10, new GregorianCalendar(2016,2,28,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Actividad_Realizada ar20 = new Actividad_Realizada(a10, new GregorianCalendar(2016,6,24,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));

			//historiales de usuario
			Historial_Usuario h1 = new Historial_Usuario(tar, ar1);
			h1.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h1.setNivelFelicidad(4);

			Historial_Usuario h2 = new Historial_Usuario(tar, ar2);
			h2.setFecha_fin(new GregorianCalendar(2016,1,6,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h2.setNivelFelicidad(3);

			Historial_Usuario h3 = new Historial_Usuario(tar, ar3);
			h3.setFecha_fin(new GregorianCalendar(2016,8,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h3.setNivelFelicidad(3);

			Historial_Usuario h4 = new Historial_Usuario(tar, ar4);
			h4.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h4.setNivelFelicidad(4);

			Historial_Usuario h5 = new Historial_Usuario(tar, ar5);
			h5.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h5.setNivelFelicidad(5);

			Historial_Usuario h6 = new Historial_Usuario(tar, ar6);
			h6.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h6.setNivelFelicidad(1);

			Historial_Usuario h7 = new Historial_Usuario(tar, ar7);
			h7.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h7.setNivelFelicidad(2);

			Historial_Usuario h8 = new Historial_Usuario(tar, ar8);
			h8.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h8.setNivelFelicidad(3);

			Historial_Usuario h9 = new Historial_Usuario(tar, ar9);
			h9.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h9.setNivelFelicidad(4);

			Historial_Usuario h10 = new Historial_Usuario(tar, ar10);
			h10.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h10.setNivelFelicidad(5);

			Historial_Usuario h11 = new Historial_Usuario(tar, ar11);
			h11.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h11.setNivelFelicidad(1);

			Historial_Usuario h12 = new Historial_Usuario(tar, ar12);
			h12.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h12.setNivelFelicidad(2);

			Historial_Usuario h13 = new Historial_Usuario(tar, ar13);
			h13.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h13.setNivelFelicidad(3);

			Historial_Usuario h14 = new Historial_Usuario(tar, ar14);
			h14.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h14.setNivelFelicidad(4);

			Historial_Usuario h15 = new Historial_Usuario(tar, ar15);
			h15.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h15.setNivelFelicidad(5);

			Historial_Usuario h16 = new Historial_Usuario(tar, ar16);
			h16.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h16.setNivelFelicidad(1);

			Historial_Usuario h17 = new Historial_Usuario(tar, ar17);
			h17.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h17.setNivelFelicidad(2);

			Historial_Usuario h18 = new Historial_Usuario(tar, ar18);
			h18.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h18.setNivelFelicidad(3);

			Historial_Usuario h19 = new Historial_Usuario(tar, ar19);
			h19.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h19.setNivelFelicidad(4);

			Historial_Usuario h20 = new Historial_Usuario(tar, ar20);
			h20.setFecha_fin(new GregorianCalendar(2016,7,2,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h20.setNivelFelicidad(5);


			//usuarios
			emanager.persist(joa);
			emanager.persist(san);
			emanager.persist(vic);
			emanager.persist(pe);
			emanager.persist(tar);
			emanager.persist(ku);
			emanager.persist(yo);
			emanager.persist(dar);
			emanager.persist(juan);
			emanager.persist(cue);
			//tipos de act
			emanager.persist(indoor);
			emanager.persist(academico);
			emanager.persist(ocio);
			emanager.persist(outdoor);
			emanager.persist(deporte);
			//actividades
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
			//actividades realizadas
			emanager.persist(ar1);
			emanager.persist(ar2);
			emanager.persist(ar3);
			emanager.persist(ar4);
			emanager.persist(ar5);
			emanager.persist(ar6);
			emanager.persist(ar7);
			emanager.persist(ar8);
			emanager.persist(ar9);
			emanager.persist(ar10);
			emanager.persist(ar11);
			emanager.persist(ar12);
			emanager.persist(ar13);
			emanager.persist(ar14);
			emanager.persist(ar15);
			emanager.persist(ar16);
			emanager.persist(ar17);
			emanager.persist(ar18);
			emanager.persist(ar19);
			emanager.persist(ar20);
			//historiales
			emanager.persist(h1);
			emanager.persist(h2);
			emanager.persist(h3);
			emanager.persist(h4);
			emanager.persist(h5);
			emanager.persist(h6);
			emanager.persist(h7);
			emanager.persist(h8);
			emanager.persist(h9);
			emanager.persist(h10);
			emanager.persist(h11);
			emanager.persist(h12);
			emanager.persist(h13);
			emanager.persist(h14);
			emanager.persist(h15);
			emanager.persist(h16);
			emanager.persist(h17);
			emanager.persist(h18);
			emanager.persist(h19);
			emanager.persist(h20);

			emanager.getTransaction().commit();

			if (emanager != null){
				emanager.close();
			}						
	}
	
	public void EliminarDatosDB(){
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

	}
	
}
