package utils;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Actividad;
import entidades.Actividad_Realizada;
import entidades.Usuario;

public class Search_Utils {

	private EntityManagerFactory emfactory;
	private EntityManager emanager;
	
	public Search_Utils(){
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
	
}
