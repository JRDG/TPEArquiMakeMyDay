package Entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Actividad {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int idTipo;
	
	@Column(nullable=false)
	private String nombre;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn
	private List<Tipo_Actividad> ListadeTipo;

	public Actividad() {
		ListadeTipo = new ArrayList<Tipo_Actividad>();
	}

	public Actividad(String nombre, ArrayList<Tipo_Actividad> listadeTipo) {
		this.nombre = nombre;
		ListadeTipo = listadeTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public ArrayList<Tipo_Actividad> getListadeTipo() {
		return (ArrayList<Tipo_Actividad>) ListadeTipo;
	}

	@Override
	public String toString() {
		return "Actividad [idTipo=" + idTipo + ", nombre=" + nombre + ", ListadeTipo=" + ListadeTipo.toString() + "]";
	}
		
	
}
