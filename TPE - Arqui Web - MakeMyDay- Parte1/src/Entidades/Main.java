package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = null;
		EntityManager emanager = null;
		try {
			emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
			emanager = emfactory.createEntityManager();

			emanager.getTransaction().begin();
			
			Usuario joa = new Usuario("Joa","Quin",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario san = new Usuario("San","Tiago",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario vic = new Usuario("Vic","Tor",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario pe = new Usuario("Pe","Tuto",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario tar = new Usuario("Tar","ton",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario ku = new Usuario("Ku","Be",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario yo = new Usuario("Yo","Landa",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario dar = new Usuario("Dar","do",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario juan = new Usuario("Juan","Se",38838019,new GregorianCalendar(1995,7,25) ,"2567");
			Usuario cue = new Usuario("Cue","Li",38838019,new GregorianCalendar(1995,7,25) ,"2567");

			
			Tipo_Actividad t1 = new Tipo_Actividad("outdoor");
			ArrayList<Tipo_Actividad> tipos = new ArrayList<Tipo_Actividad>();
			tipos.add(t1);
			Actividad a1 = new Actividad("cazar pokemon", tipos);
			Actividad_Realizada ar1 = new Actividad_Realizada(a1, new GregorianCalendar(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			Historial_Usuario h1 = new Historial_Usuario(tar, ar1);
			h1.setFecha_fin(new GregorianCalendar(Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH,Calendar.HOUR,Calendar.MINUTE,Calendar.SECOND));
			h1.setNivelFelicidad(5);
			
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
			emanager.persist(t1);
			emanager.persist(a1);
			emanager.persist(ar1);
			emanager.persist(h1);
			emanager.getTransaction().commit();


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
