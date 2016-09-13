package entidades;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Historial_Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn
	private Usuario usuario;
	@ManyToOne
	@JoinColumn
	private Actividad_Realizada actividad;
	@Column(nullable = false)
	private double nivelFelicidad;
	@Column(nullable = false)
	private boolean privado;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private GregorianCalendar fecha_fin;
	
	public Historial_Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Historial_Usuario(Usuario usuario, Actividad_Realizada actividad) {
		this.usuario = usuario;
		this.actividad = actividad;
		this.nivelFelicidad = 0.0;
		this.privado = true;
	}
	public GregorianCalendar getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(GregorianCalendar fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public Actividad_Realizada getActividad() {
		return actividad;
	}
	public double getNivelFelicidad() {
		return nivelFelicidad;
	}
	public boolean isPrivado() {
		return privado;
	}
	
	public void setPrivacidad(boolean esPrivado){
		privado = esPrivado;
	}
	
	public void setNivelFelicidad(double nivelFelicidad) {
		this.nivelFelicidad = nivelFelicidad;
	}

	public void setPrivado(boolean privado) {
		this.privado = privado;
	}

	@Override
	public String toString() {
		return "Historial_Usuario [id=" + id + ", usuario=" + usuario + ", actividad=" + actividad + ", nivelFelicidad="
				+ nivelFelicidad + ", privado=" + privado + ", fecha_fin=" + fecha_fin + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historial_Usuario other = (Historial_Usuario) obj;
		if (actividad == null) {
			if (other.actividad != null)
				return false;
		} else if (!actividad.equals(other.actividad))
			return false;
		if (fecha_fin == null) {
			if (other.fecha_fin != null)
				return false;
		} else if (!fecha_fin.equals(other.fecha_fin))
			return false;
		if (Double.doubleToLongBits(nivelFelicidad) != Double.doubleToLongBits(other.nivelFelicidad))
			return false;
		if (privado != other.privado)
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}	
	
	
}
