package com.springboot.backend.apirest.reclutamiento.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.backend.apirest.reclutamiento.enums.SexoEnum;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 50, message = "el tamaño tiene que estar entre 4 y 50")
	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellidoP")
	private String apellidoP;

	@Column(name = "apellidoM")
	private String apellidoM;

	@Column(name = "fechaNacimiento")
	private Date fechaNacimiento;

	@Column(name = "sexo")
	private SexoEnum sexo;

	@Email(message = "no es una dirección de correo bien formada")
	@Column(name = "email")
	private String email;

	@Column(name = "enabled")
	private Boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "perfil_empleado", joinColumns = @JoinColumn(name = "id_empleado", referencedColumnName = "idEmpleado"), inverseJoinColumns = @JoinColumn(name = "id_perfil", referencedColumnName = "idPerfil"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_perfil", "id_empleado" }) })
	private List<Perfil> perfiles;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_proyecto")
	@JsonIgnore
	private Proyecto proyecto;

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	public Integer getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Integer idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
