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
import com.springboot.backend.apirest.reclutamiento.enums.NivelEnum;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerfil;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "nivel")
	private NivelEnum nivel;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "perfil_skill", joinColumns = @JoinColumn(name = "id_perfil", referencedColumnName = "idPerfil"), inverseJoinColumns = @JoinColumn(name = "id_skill", referencedColumnName = "idSkill"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "id_perfil", "id_skill" }) })
	private List<Skill> skills;

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public NivelEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelEnum nivel) {
		this.nivel = nivel;
	}
}
