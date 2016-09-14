package entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.eclipse.persistence.jpa.config.Cascade;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actividad other = (Actividad) obj;
		if (ListadeTipo == null) {
			if (other.ListadeTipo != null)
				return false;
		} else if (!ListadeTipo.equals(other.ListadeTipo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
			
	
}
