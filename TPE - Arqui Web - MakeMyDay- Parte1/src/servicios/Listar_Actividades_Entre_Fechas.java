package servicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Actividad_Realizada;

public class Listar_Actividades_Entre_Fechas {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = null;
		EntityManager emanager = null;
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
			emanager = emfactory.createEntityManager();
			String usuario = "joa";
			Calendar fecha1 = new GregorianCalendar(2015,7,1);
			Calendar fecha2 = new GregorianCalendar(2016,1,1);
	        String jpql = "SELECT h.actividad FROM Historial_Usuario h WHERE h.usuario.nombre = ?1 AND (h.actividad.fecha_realizada > ?2 AND h.fecha_fin < ?3)"; 
			Query query = emanager.createQuery(jpql).setParameter(1, usuario).setParameter(2,fecha1).setParameter(3,fecha2); 
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
