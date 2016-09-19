package entidades;

import javax.persistence.*;


@Entity
public class Tipo_Actividad implements Comparable<Tipo_Actividad> {
	@Column(nullable=false)
	private String nombre;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private int idTipo;
	
	public Tipo_Actividad() {
		// TODO Auto-generated constructor stub
	}
	
	public Tipo_Actividad(String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	public int getId(){
		return idTipo;
	}

	@Override
	public String toString() {
		return "Tipo_Actividad [nombre=" + nombre + ", idTipo=" + idTipo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tipo_Actividad other = (Tipo_Actividad) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	@Override
	public int compareTo(Tipo_Actividad arg0) {
		return this.getNombre().compareTo(arg0.getNombre());
	}
		
	
}
