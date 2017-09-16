package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Emplacements implements Serializable {
	public Long getNumEmplacement() {
		return numEmplacement;
	}

	public void setNumEmplacement(Long numEmplacement) {
		this.numEmplacement = numEmplacement;
	}

	public String getNomEmplacement() {
		return nomEmplacement;
	}

	public void setNomEmplacement(String nomEmplacement) {
		this.nomEmplacement = nomEmplacement;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}

	public Emplacements(Long numEmplacement, String nomEmplacement, String service, Collection<Machine> machines) {
		super();
		this.numEmplacement = numEmplacement;
		this.nomEmplacement = nomEmplacement;
		this.service = service;
		this.machines = machines;
	}

	public Emplacements() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numEmplacement;
	
	private String nomEmplacement;
	
	private String service;
	
	@OneToMany(mappedBy="emplacements", cascade = CascadeType.ALL)
	private Collection<Machine> machines;
}
