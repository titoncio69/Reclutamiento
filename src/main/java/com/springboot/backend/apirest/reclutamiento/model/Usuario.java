package com.springboot.backend.apirest.reclutamiento.model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.springboot.backend.apirest.reclutamiento.constraint.ValidPassword;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 50, message = "el tamaño tiene que estar entre 4 y 50")
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
//	@Size(min = 8, max = 100, message = "el tamaño tiene que estar entre 8 y 100")
	@ValidPassword
	private String password;

	@Column(name = "repeat_password", nullable = false)
//	@Size(min = 8, max = 100, message = "el tamaño tiene que estar entre 8 y 100")
	@ValidPassword
	private String repeatPassword;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formada")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "enabled")
	private Boolean enabled;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_usuario", "id_rol" }) })
	private List<Rol> roles;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", username=" + username + ", password=" + password + ", nombre="
				+ nombre + ", apellido=" + apellido + ", email=" + email + ", enabled=" + enabled + "]";
	}

}
