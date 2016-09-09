package Entidades;
import java.sql.Date;
import javax.persistence.*;

@Entity
public class Historial_Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private Usuario usuario;
	@Column(nullable = false)
	private Actividad actividad;
	@Column(nullable = false)
	private double nivelFelicidad;
	@Column(nullable = false)
	private boolean privado;
	@Column
	private Date fecha_fin;
	
	public Historial_Usuario(Usuario usuario, Actividad actividad, double nivelFelicidad, boolean privado) {
		this.usuario = usuario;
		this.actividad = actividad;
		this.nivelFelicidad = nivelFelicidad;
		this.privado = privado;
	}
	public Date getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Actividad getActividad() {
		return actividad;
	}
	public double getNivelFelicidad() {
		return nivelFelicidad;
	}
	public boolean isPrivado() {
		return privado;
	}
	
}
