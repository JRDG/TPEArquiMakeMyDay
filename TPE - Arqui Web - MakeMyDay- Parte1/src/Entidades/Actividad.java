package Entidades;


import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actividad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int idTipo;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private ArrayList<Tipo_Actividad> ListadeTipo;

	
	public Actividad(String nombre, ArrayList<Tipo_Actividad> listadeTipo) {
		this.nombre = nombre;
		ListadeTipo = listadeTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Tipo_Actividad> getListadeTipo() {
		return ListadeTipo;
	}


	
	
	
}
