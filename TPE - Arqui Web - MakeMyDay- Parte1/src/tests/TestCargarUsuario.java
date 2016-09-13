package tests;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import entidades.Usuario;

public class TestCargarUsuario {

	@Test
	public void test() {
		EntityManagerFactory emfactory;
		EntityManager emanager;
		
		Usuario joa;
		Usuario san;
		Usuario vic;
		Usuario pe;
		Usuario tar;
		Usuario ku;
		Usuario yo;
		Usuario dar;
		Usuario juan;
		Usuario cue;
		
		@Before
		public void inicializacion2(){
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
			
		}	
		
		@Test
		public void testCargarUsuarios2() {
			emanager = emfactory.createEntityManager();
			emanager.getTransaction().begin();
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
			emanager.getTransaction().commit();
			if (emanager != null){
				emanager.close();
			}	
		}	
		
		
		
		
		
		
		
		
		
		
	}

}
