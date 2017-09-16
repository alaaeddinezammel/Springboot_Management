package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Utilisateur implements Serializable {

	
	public Long getNumU() {
		return numU;
	}

	public void setNumU(Long numU) {
		this.numU = numU;
	}

	public String getNomU() {
		return nomU;
	}

	public void setNomU(String nomU) {
		this.nomU = nomU;
	}

	public String getPrenomU() {
		return prenomU;
	}

	public void setPrenomU(String prenomU) {
		this.prenomU = prenomU;
	}

	public String getDroitU() {
		return droitU;
	}

	public void setDroitU(String droitU) {
		this.droitU = droitU;
	}

	public Collection<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}

	public Utilisateur(Long numU, String nomU, String prenomU, String droitU, Collection<Machine> machines) {
		super();
		this.numU = numU;
		this.nomU = nomU;
		this.prenomU = prenomU;
		this.droitU = droitU;
		this.machines = machines;
	}

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numU;

	private String username;
	private String password;

	public Utilisateur(Long numU, String username, String password, String nomU, String prenomU, String droitU,
			Collection<Machine> machines) {
		super();
		this.numU = numU;
		this.username = username;
		this.password = password;
		this.nomU = nomU;
		this.prenomU = prenomU;
		this.droitU = droitU;
		this.machines = machines;
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

	private String nomU;

	private String prenomU;

	private String droitU;

	@ManyToMany
	@JoinTable(name = "utilise")
	@JsonIgnoreProperties("utilisateurs")
	private Collection<Machine> machines;

}
