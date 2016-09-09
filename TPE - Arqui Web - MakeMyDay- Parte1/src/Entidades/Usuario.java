package Entidades;
import javax.persistence.*;


@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Column(nullable = false)
	private String DNI;
	@Column(nullable = false)
	private int edad;
	@Column(nullable = false)
	private String password;
	
	public Usuario(int id_usuario, String nombre, String apellido, String dNI, int edad, String password) {
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
		this.edad = edad;
		this.password = password;
	}
	
	

}
