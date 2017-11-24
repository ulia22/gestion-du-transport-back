package dev.gestiondutransportback.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class AnnonceCovoit {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String addrDepart;
	
	@Column
	private String addrArrivee;
	
	@Column
	private Integer duree;
	
	@Column
	private Integer distance;
	
	@Column
	private String immatriculation;
	
	@Column
	private String marque;
	
	@Column
	private String modele;
	
	@Column
	private Integer nbPlace;
	
	@Column
	private LocalDateTime dateDepart;
	
	@Column
	private LocalDateTime dateDeCreation;
	
	@Column
	private boolean isArchive;
	
	@ManyToOne
	@JoinColumn(name="ID_Personne")
	private Personne personne;
	
	@ManyToMany
	@JoinColumn(name="ID_Covoitureur")
	private Set<Personne> covoitureurs;
	
	public AnnonceCovoit() {
		this.covoitureurs=new HashSet<>();
		
	}

	public AnnonceCovoit(String addrDepart, String addrArrivee, String immatriculation, String marque, String modele,
			Integer nbPlace, LocalDateTime dateDepart, LocalDateTime dateDeCreation) {
		super();
		this.addrDepart = addrDepart;
		this.addrArrivee = addrArrivee;
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.modele = modele;
		this.nbPlace = nbPlace;
		this.dateDepart = dateDepart;
		this.dateDeCreation = dateDeCreation;
		this.covoitureurs=new HashSet<>();
	}

	/**Getter for id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**Getter for addrDepart
	 * @return addrDepart
	 */
	public String getAddrDepart() {
		return addrDepart;
	}

	/**
	 * @param addrDepart the addrDepart to set
	 */
	public void setAddrDepart(String addrDepart) {
		this.addrDepart = addrDepart;
	}

	/**Getter for addrArrivee
	 * @return addrArrivee
	 */
	public String getAddrArrivee() {
		return addrArrivee;
	}

	/**
	 * @param addrArrivee the addrArrivee to set
	 */
	public void setAddrArrivee(String addrArrivee) {
		this.addrArrivee = addrArrivee;
	}

	/**Getter for duree
	 * @return duree
	 */
	public Integer getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	/**Getter for distance
	 * @return distance
	 */
	public Integer getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	/**Getter for immatriculation
	 * @return immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**Getter for marque
	 * @return marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**Getter for modele
	 * @return modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**Getter for nbPlace
	 * @return nbPlace
	 */
	public Integer getNbPlace() {
		return nbPlace;
	}

	/**
	 * @param nbPlace the nbPlace to set
	 */
	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}

	/**Getter for dateDepart
	 * @return dateDepart
	 */
	public LocalDateTime getDateDepart() {
		return dateDepart;
	}

	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}

	/**Getter for dateDeCreation
	 * @return dateDeCreation
	 */
	public LocalDateTime getDateDeCreation() {
		return dateDeCreation;
	}

	/**
	 * @param dateDeCreation the dateDeCreation to set
	 */
	public void setDateDeCreation(LocalDateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	/**Getter for isArchive
	 * @return isArchive
	 */
	public boolean isArchive() {
		return isArchive;
	}

	/**
	 * @param isArchive the isArchive to set
	 */
	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	/**Getter for personne
	 * @return personne
	 */
	public Personne getPersonne() {
		return personne;
	}

	/**
	 * @param personne the personne to set
	 */
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	/**Getter for covoitureurs
	 * @return covoitureurs
	 */
	public Set<Personne> getCovoitureurs() {
		return covoitureurs;
	}

	/**
	 * @param covoitureurs the covoitureurs to set
	 */
	public void setCovoitureurs(Set<Personne> covoitureurs) {
		this.covoitureurs = covoitureurs;
	}


	
	
	
}
