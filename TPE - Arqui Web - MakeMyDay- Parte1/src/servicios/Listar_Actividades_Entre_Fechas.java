package servicios;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import entidades.Actividad;
import entidades.Actividad_Realizada;
import entidades.Historial_Usuario;

public class Listar_Actividades_Entre_Fechas {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = null;
		EntityManager emanager = null;
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
			emanager = emfactory.createEntityManager();

	        //String jpql = "SELECT h.actividad FROM Historial_Usuario h WHERE h.usuario.nombre = ?1 AND (h.actividad.fecha_realizada > ?2 AND h.fecha_fin < ?3)"; 
			String jpql = "SELECT h.actividad FROM Historial_Usuario h WHERE h.fecha_fin < ?1"; 
			//Query query = emanager.createQuery(jpql).setParameter(1, "Joa").setParameter(2,new GregorianCalendar(2015,5,1)).setParameter(3,new GregorianCalendar(2015,8,1)); 
			Query query = emanager.createQuery(jpql).setParameter(1,new GregorianCalendar(2015,4,1));
	        List<Actividad_Realizada> resultados = query.getResultList();
	        for(Actividad_Realizada  r : resultados) { 
	        	System.out.println(r);
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
