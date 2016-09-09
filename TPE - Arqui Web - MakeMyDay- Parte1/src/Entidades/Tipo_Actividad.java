package Entidades;


import javax.persistence.*;


@Entity
public class Tipo_Actividad {
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
	
	
}
