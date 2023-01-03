package com.abisoft.abisoft.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
    private String identificacion;
    private Long edad;
    private Date fechaNacimiento;
    private Date fechaInscripcion;
    private Long costo; 
    
    public Usuario(String nombre, String apellido, String identificacion, Long edad, Date fechaNacimiento, Date fechaInscripcion,
    		Long costo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaInscripcion = fechaInscripcion;
		this.costo = costo;
	}
    
    public Usuario() {
		super();
	}


	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Min(value = 4)
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Min(value = 4)
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Size(max=10)
	@JsonProperty("identificacion")
	@Column(name = "identificacion")
	public String getIdentificacion() {
		return identificacion;
	}
	
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	
	@JsonProperty("FechaNacimiento")
    @JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "Fecha_Nacimiento")
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	@JsonProperty("FechaInscripcion")
    @JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "Fecha_Inscripcion")
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	
	
	public Long getCosto() {
		return costo;
	}
	public void setCosto(Long costo) {
		this.costo = costo;
	}
    

}
