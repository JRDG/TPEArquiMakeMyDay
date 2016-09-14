package tests;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entidades.Actividad;
import entidades.Actividad_Realizada;

public class TestCargarActividadesRealizadas {
	
	private EntityManagerFactory emfactory;
	private EntityManager emanager;

	
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
	
	
	@Before
	public void inicializacion(){
		emfactory = Persistence.createEntityManagerFactory("TPE-MakeMyDay-JPA");
	
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

	}
	
	@Test
	public void testCargarActividadesRealizadas() {
		emanager = emfactory.createEntityManager();
		emanager.getTransaction().begin();
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
		emanager.getTransaction().commit();
		if (emanager != null){
			emanager.close();
		}	
	}
	
	@After
	public void cerrarFactory(){
		if (emfactory != null){
			emfactory.close();
		}	
	}

}
