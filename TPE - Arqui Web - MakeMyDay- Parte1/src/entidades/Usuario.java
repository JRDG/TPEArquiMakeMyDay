package entidades;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;


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
	private int DNI;
	@Column(nullable = false)
	private GregorianCalendar fechaNacimiento;
	@Column(nullable = false)
	private String password;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellido, int dNI, GregorianCalendar fechaNacimiento, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	public GregorianCalendar getCalendarNacimiento() {
		return fechaNacimiento; 
	}

	public void setEdad(GregorianCalendar fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", DNI=" + DNI
				+ ", fechaNacimiento=" + getFechaNacimiento(fechaNacimiento)  + ", password=" + password + "]";
	}

	private String getFechaNacimiento(GregorianCalendar fechaNacimiento2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setCalendar(fechaNacimiento2);
		return sdf.format(fechaNacimiento2.getTime());
	}

}
