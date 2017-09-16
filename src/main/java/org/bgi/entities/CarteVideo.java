package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CarteVideo implements Serializable {
	public CarteVideo(Long numCarteVideo, String nomCarte, String typeCarte, Collection<Machine> machines) {
		super();
		this.numCarteVideo = numCarteVideo;
		this.nomCarte = nomCarte;
		this.typeCarte = typeCarte;
		this.machines = machines;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numCarteVideo;
	
	private String nomCarte;
	
	private String typeCarte;

	@OneToMany(mappedBy="carteVideo")
	private Collection<Machine> machines;

	public CarteVideo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getNumCarteVideo() {
		return numCarteVideo;
	}

	public void setNumCarteVideo(Long numCarteVideo) {
		this.numCarteVideo = numCarteVideo;
	}

	public String getNomCarte() {
		return nomCarte;
	}

	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

	public String getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(String typeCarte) {
		this.typeCarte = typeCarte;
	}
	@JsonIgnore
	public Collection<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Collection<Machine> machines) {
		this.machines = machines;
	}
	
	
}
