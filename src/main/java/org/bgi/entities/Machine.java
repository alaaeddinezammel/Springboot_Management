package org.bgi.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.validator.internal.util.IgnoreJava6Requirement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "deletel", 
	                              procedureName = "deletel",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "idm", type =Long.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "idl", type = Long.class)
	                              }),
	
	   
	   @NamedStoredProcedureQuery(name = "deletep", 
       procedureName = "deletep",
       parameters = {
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "idm", type =Long.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "idp", type = Long.class)
       }),
	   
	   
	   @NamedStoredProcedureQuery(name = "deleteu", 
       procedureName = "deleteu",
       parameters = {
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "idm", type =Long.class),
          @StoredProcedureParameter(mode = ParameterMode.IN, name = "idu", type = Long.class)
       })
	   
	   
	  
	})



public class Machine implements Serializable {

	@Override
	public String toString() {
		return "Machine [numMachine=" + numMachine + ", typeMachine=" + typeMachine + ", dateAchat=" + dateAchat
				+ ", nomMachine=" + nomMachine + ", numSerieMachine=" + numSerieMachine + ", dateMiseEnService="
				+ dateMiseEnService + ", proc=" + proc + ", socket=" + socket + ", prixMachine=" + prixMachine
				+ ", dateLivraison=" + dateLivraison + ", memoire=" + memoire + ", typeMemoire=" + typeMemoire
				+ ", carteReseaux=" + carteReseaux + ", carteSon=" + carteSon + ", carteMere=" + carteMere
				+ ", typeCmere=" + typeCmere + ", adressIp=" + adressIp + ", adressMac=" + adressMac
				+ ", numPriseMurale=" + numPriseMurale + ", notes=" + notes + ", datelogicieli=" + datelogicieli
				+ ", dateUtilisateurMachine=" + dateUtilisateurMachine + ", dateperepheriquei=" + dateperepheriquei
				+ ", logiciels=" + logiciels + ", utilisateurs=" + utilisateurs + ", perepheriques=" + perepheriques
				+ ", emplacements=" + emplacements + ", carteVideo=" + carteVideo + ", ddur=" + ddur + ", maintenance="
				+ maintenance + ", ecran=" + ecran + ", fournisseur=" + fournisseur + ", marque=" + marque
				+ ", garantie=" + garantie + "]";
	}

	public Long getNumMachine() {
		return numMachine;
	}

	public void setNumMachine(Long numMachine) {
		this.numMachine = numMachine;
	}

	public String getTypeMachine() {
		return typeMachine;
	}

	public void setTypeMachine(String typeMachine) {
		this.typeMachine = typeMachine;
	}

	public java.util.Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(java.util.Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public String getNomMachine() {
		return nomMachine;
	}

	public void setNomMachine(String nomMachine) {
		this.nomMachine = nomMachine;
	}

	public long getNumSerieMachine() {
		return numSerieMachine;
	}

	public void setNumSerieMachine(long numSerieMachine) {
		this.numSerieMachine = numSerieMachine;
	}

	public java.util.Date getDateMiseEnService() {
		return dateMiseEnService;
	}

	public void setDateMiseEnService(java.util.Date dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}

	public String getProc() {
		return proc;
	}

	public void setProc(String proc) {
		this.proc = proc;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public double getPrixMachine() {
		return prixMachine;
	}

	public void setPrixMachine(double prixMachine) {
		this.prixMachine = prixMachine;
	}

	public java.util.Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(java.util.Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public String getMemoire() {
		return memoire;
	}

	public void setMemoire(String memoire) {
		this.memoire = memoire;
	}

	public String getTypeMemoire() {
		return typeMemoire;
	}

	public void setTypeMemoire(String typeMemoire) {
		this.typeMemoire = typeMemoire;
	}

	public String getCarteReseaux() {
		return carteReseaux;
	}

	public void setCarteReseaux(String carteReseaux) {
		this.carteReseaux = carteReseaux;
	}

	public String getCarteSon() {
		return carteSon;
	}

	public void setCarteSon(String carteSon) {
		this.carteSon = carteSon;
	}

	public String getCarteMere() {
		return carteMere;
	}

	public void setCarteMere(String carteMere) {
		this.carteMere = carteMere;
	}

	public String getTypeCmere() {
		return typeCmere;
	}

	public void setTypeCmere(String typeCmere) {
		this.typeCmere = typeCmere;
	}

	public String getAdressIp() {
		return adressIp;
	}

	public void setAdressIp(String adressIp) {
		this.adressIp = adressIp;
	}

	public String getAdressMac() {
		return adressMac;
	}

	public void setAdressMac(String adressMac) {
		this.adressMac = adressMac;
	}

	public int getNumPriseMurale() {
		return numPriseMurale;
	}

	public void setNumPriseMurale(int numPriseMurale) {
		this.numPriseMurale = numPriseMurale;
	}

	public int getNotes() {
		return notes;
	}

	public void setNotes(int notes) {
		this.notes = notes;
	}

	public Collection<Logiciels> getLogiciels() {
		return logiciels;
	}

	public void setLogiciels(Collection<Logiciels> logiciels) {
		this.logiciels = logiciels;
	}

	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Collection<Perepherique> getPerepheriques() {
		return perepheriques;
	}

	public void setPerepheriques(Collection<Perepherique> perepheriques) {
		this.perepheriques = perepheriques;
	}

	public Emplacements getEmplacements() {
		return emplacements;
	}

	public void setEmplacements(Emplacements emplacements) {
		this.emplacements = emplacements;
	}

	public CarteVideo getCarteVideo() {
		return carteVideo;
	}

	public void setCarteVideo(CarteVideo carteVideo) {
		this.carteVideo = carteVideo;
	}

	public DDUR getDdur() {
		return ddur;
	}

	public void setDdur(DDUR ddur) {
		this.ddur = ddur;
	}

	public Maintenances getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(Maintenances maintenance) {
		this.maintenance = maintenance;
	}

	public Ecrans getEcran() {
		return ecran;
	}

	public void setEcran(Ecrans ecran) {
		this.ecran = ecran;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Garantie getGarantie() {
		return garantie;
	}

	public void setGarantie(Garantie garantie) {
		this.garantie = garantie;
	}

	public Machine(Long numMachine, String typeMachine, Date dateAchat, String nomMachine, long numSerieMachine,
			Date dateMiseEnService, String proc, String socket, double prixMachine, Date dateLivraison, String memoire,
			String typeMemoire, String carteReseaux, String carteSon, String carteMere, String typeCmere,
			String adressIp, String adressMac, int numPriseMurale, int notes, Collection<Logiciels> logiciels,
			Collection<Utilisateur> utilisateurs, Collection<Perepherique> perepheriques, Emplacements emplacements,
			CarteVideo carteVideo, DDUR ddur, Maintenances maintenance, Ecrans ecran, Fournisseur fournisseur,
			Marque marque, Garantie garantie) {
		super();
		this.numMachine = numMachine;
		this.typeMachine = typeMachine;
		this.dateAchat = dateAchat;
		this.nomMachine = nomMachine;
		this.numSerieMachine = numSerieMachine;
		this.dateMiseEnService = dateMiseEnService;
		this.proc = proc;
		this.socket = socket;
		this.prixMachine = prixMachine;
		this.dateLivraison = dateLivraison;
		this.memoire = memoire;
		this.typeMemoire = typeMemoire;
		this.carteReseaux = carteReseaux;
		this.carteSon = carteSon;
		this.carteMere = carteMere;
		this.typeCmere = typeCmere;
		this.adressIp = adressIp;
		this.adressMac = adressMac;
		this.numPriseMurale = numPriseMurale;
		this.notes = notes;
		this.logiciels = logiciels;
		this.utilisateurs = utilisateurs;
		this.perepheriques = perepheriques;
		this.emplacements = emplacements;
		this.carteVideo = carteVideo;
		this.ddur = ddur;
		this.maintenance = maintenance;
		this.ecran = ecran;
		this.fournisseur = fournisseur;
		this.marque = marque;
		this.garantie = garantie;
	}

	public Machine() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numMachine;

	private String typeMachine;

	private java.util.Date dateAchat;

	private String nomMachine;

	private long numSerieMachine;

	private java.util.Date dateMiseEnService;

	private String proc;

	private String socket;

	private double prixMachine;

	private java.util.Date dateLivraison;

	private String memoire;

	private String typeMemoire;

	private String carteReseaux;

	private String carteSon;

	private String carteMere;

	private String typeCmere;

	private String adressIp;

	private String adressMac;

	private int numPriseMurale;

	private int notes;

	private java.util.Date datelogicieli;



	private java.util.Date dateUtilisateurMachine;

	public java.util.Date getDateUtilisateurMachine() {
		return dateUtilisateurMachine;
	}

	public void setDateUtilisateurMachine(java.util.Date dateUtilisateurMachine) {
		this.dateUtilisateurMachine = dateUtilisateurMachine;
	}

	public java.util.Date getDatelogicieli() {
		return datelogicieli;
	}

	public void setDatelogicieli(java.util.Date datelogicieli) {
		this.datelogicieli = datelogicieli;
	}

	public java.util.Date getDateperepheriquei() {
		return dateperepheriquei;
	}

	public void setDateperepheriquei(java.util.Date dateperepheriquei) {
		this.dateperepheriquei = dateperepheriquei;
	}

	private java.util.Date dateperepheriquei;

	

	@JsonIgnoreProperties("machines")
	@ManyToMany(mappedBy = "machines", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Collection<Utilisateur> utilisateurs;
	
	@JsonIgnoreProperties("machines")
	@ManyToMany(mappedBy = "machines", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Collection<Logiciels> logiciels;

	@JsonIgnoreProperties("machines")
	@ManyToMany(mappedBy = "machines", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Collection<Perepherique> perepheriques;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_EMPLACEMENT")
	private Emplacements emplacements;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_CARTE_VIDEO")
	private CarteVideo carteVideo;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_DD")
	private DDUR ddur;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_MAINTENANCE")
	private Maintenances maintenance;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_ECRAN")
	private Ecrans ecran;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_FOURNISSEUR")

	private Fournisseur fournisseur;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_MARQUE")
	private Marque marque;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "NUM_GARENTIE")
	private Garantie garantie;

}
