package Entidades;

import java.sql.Date;

import javax.persistence.*;

@Entity

public class Actividad_Realizada {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id_actividad_realizada;
	@Column(nullable = false)
	private Actividad actividad;
	@Column(nullable = false)
	private Date fecha_realizada;
	
	public Actividad_Realizada(Actividad actividad,Date fecha_realizada){
		this.actividad = actividad;
		this.fecha_realizada = fecha_realizada;
	}

	public int getId_actividad_realizada() {
		return id_actividad_realizada;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Date getFecha_realizada() {
		return fecha_realizada;
	}

	public void setFecha_realizada(Date fecha_realizada) {
		this.fecha_realizada = fecha_realizada;
	}

	@Override
	public String toString() {
		return "Actividad_Realizada [actividad=" + actividad
				+ ", fecha_realizada=" + fecha_realizada + "]";
	}
	
	
}
