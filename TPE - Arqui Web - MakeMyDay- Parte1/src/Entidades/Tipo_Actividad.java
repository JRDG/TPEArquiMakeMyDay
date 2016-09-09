package Entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tipo_Actividad {
	
	private String nombre;
	
	@id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int idTipo;
	
	
	public Tipo_Actividad(String nombre){

		
		
		@Column(nullable=false)
		this.nombre=nombre;
	}
	
	
	
}
