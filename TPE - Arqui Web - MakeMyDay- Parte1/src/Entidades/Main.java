package Entidades;

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
			
//			Equipo equipo=new Equipo(1, "River");
//			emanager.persist(equipo);
//			
//			Jugador jugador = new Jugador();
//			jugador.setDni(34287439);
//			jugador.setNombre("Emiliano");
//			jugador.setApellido("Sanchez");
//			jugador.setEquipo(equipo);
//			emanager.persist(jugador);
//			
//			emanager.getTransaction().commit();
//			
//			Equipo result = emanager.find(Equipo.class, 1);
//			System.out.println(result.getNombre());

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
