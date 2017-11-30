/**
 * 
 */
package dev.gestiondutransportback.view;

import java.time.LocalDateTime;

import dev.gestiondutransportback.entity.AnnonceCovoit;

/**
 * @author ETY9
 *
 */
public class AnnonceCovoitView {

	private Integer id;
	private String addrDepart;
	private String addrArrivee;
	private Integer duree;
	private Integer distance;
	private String immatriculation;
	private String marque;
	private String modele;
	private Integer nbPlace;
	private LocalDateTime dateDepart;
	private LocalDateTime dateDeCreation;
	private boolean isArchive;
	private Integer idPersonne;
	private String prenomChauffeur;
	private String nomChauffeur;
	
	
	/**
	 * 
	 */
	public AnnonceCovoitView() {
		super();
	}
	
	public AnnonceCovoitView(AnnonceCovoit a) {
		this();
		this.id = a.getId();
		this.addrDepart = a.getAddrDepart();
		this.addrArrivee = a.getAddrArrivee();
		this.duree = a.getDistance();
		this.distance = a.getDistance();
		this.immatriculation = a.getImmatriculation();
		this.marque = a.getMarque();
		this.modele = a.getModele();
		this.nbPlace = a.getNbPlace();
		this.dateDepart = a.getDateDepart();
		this.dateDeCreation = a.getDateDeCreation();
		this.isArchive = a.isArchive();
		
		this.idPersonne = a.getPersonne().getId();
		this.nomChauffeur = a.getPersonne().getNom();
		this.prenomChauffeur = a.getPersonne().getPrenom();
	}
	
	
	/**
	 * Getter for id.
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter for id
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter for addrDepart.
	 * @return the addrDepart
	 */
	public String getAddrDepart() {
		return addrDepart;
	}
	/**
	 * Setter for addrDepart
	 * @param addrDepart the addrDepart to set
	 */
	public void setAddrDepart(String addrDepart) {
		this.addrDepart = addrDepart;
	}
	/**
	 * Getter for addrArrivee.
	 * @return the addrArrivee
	 */
	public String getAddrArrivee() {
		return addrArrivee;
	}
	/**
	 * Setter for addrArrivee
	 * @param addrArrivee the addrArrivee to set
	 */
	public void setAddrArrivee(String addrArrivee) {
		this.addrArrivee = addrArrivee;
	}
	/**
	 * Getter for duree.
	 * @return the duree
	 */
	public Integer getDuree() {
		return duree;
	}
	/**
	 * Setter for duree
	 * @param duree the duree to set
	 */
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	/**
	 * Getter for distance.
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}
	/**
	 * Setter for distance
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	/**
	 * Getter for immatriculation.
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}
	/**
	 * Setter for immatriculation
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	/**
	 * Getter for marque.
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}
	/**
	 * Setter for marque
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}
	/**
	 * Getter for modele.
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}
	/**
	 * Setter for modele
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}
	/**
	 * Getter for nbPlace.
	 * @return the nbPlace
	 */
	public Integer getNbPlace() {
		return nbPlace;
	}
	/**
	 * Setter for nbPlace
	 * @param nbPlace the nbPlace to set
	 */
	public void setNbPlace(Integer nbPlace) {
		this.nbPlace = nbPlace;
	}
	/**
	 * Getter for dateDepart.
	 * @return the dateDepart
	 */
	public LocalDateTime getDateDepart() {
		return dateDepart;
	}
	/**
	 * Setter for dateDepart
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(LocalDateTime dateDepart) {
		this.dateDepart = dateDepart;
	}
	/**
	 * Getter for dateDeCreation.
	 * @return the dateDeCreation
	 */
	public LocalDateTime getDateDeCreation() {
		return dateDeCreation;
	}
	/**
	 * Setter for dateDeCreation
	 * @param dateDeCreation the dateDeCreation to set
	 */
	public void setDateDeCreation(LocalDateTime dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}
	/**
	 * Getter for isArchive.
	 * @return the isArchive
	 */
	public boolean isArchive() {
		return isArchive;
	}
	/**
	 * Setter for isArchive
	 * @param isArchive the isArchive to set
	 */
	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	/**
	 * Getter for prenomChauffeur.
	 * @return the prenomChauffeur
	 */
	public String getPrenomChauffeur() {
		return prenomChauffeur;
	}

	/**
	 * Setter for prenomChauffeur
	 * @param prenomChauffeur the prenomChauffeur to set
	 */
	public void setPrenomChauffeur(String prenomChauffeur) {
		this.prenomChauffeur = prenomChauffeur;
	}

	/**
	 * Getter for nomChauffeur.
	 * @return the nomChauffeur
	 */
	public String getNomChauffeur() {
		return nomChauffeur;
	}

	/**
	 * Setter for nomChauffeur
	 * @param nomChauffeur the nomChauffeur to set
	 */
	public void setNomChauffeur(String nomChauffeur) {
		this.nomChauffeur = nomChauffeur;
	}

	/**Getter for idPersonne
	 * @return idPersonne
	 */
	public Integer getIdPersonne() {
		return idPersonne;
	}

	/**
	 * @param idPersonne the idPersonne to set
	 */
	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}
	
	
}
