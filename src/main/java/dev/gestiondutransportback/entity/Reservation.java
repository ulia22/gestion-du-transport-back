package dev.gestiondutransportback.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private LocalDateTime dateReserv;
	
	@Column
	private LocalDateTime dateRetour;
	
	@Column
	private boolean avecChauffeur;
	
	@ManyToOne
	@JoinColumn(name="ID_personne")
	private Personne personne;
	
	@ManyToOne
	@JoinColumn(nullable=true)
	private Personne chauffeur;
	
	@ManyToOne
	@JoinColumn
	private Vehicule vehicule;
	
	public Reservation() {
		
	}

	public Reservation(LocalDateTime dateReserv, LocalDateTime dateRetour, boolean avecChauffeur) {
		super();
		this.dateReserv = dateReserv;
		this.dateRetour = dateRetour;
		this.avecChauffeur = avecChauffeur;
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

	/**Getter for dateReserv
	 * @return dateReserv
	 */
	public LocalDateTime getDateReserv() {
		return dateReserv;
	}

	/**
	 * @param dateReserv the dateReserv to set
	 */
	public void setDateReserv(LocalDateTime dateReserv) {
		this.dateReserv = dateReserv;
	}

	/**Getter for dateRetour
	 * @return dateRetour
	 */
	public LocalDateTime getDateRetour() {
		return dateRetour;
	}

	/**
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(LocalDateTime dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**Getter for avecChauffeur
	 * @return avecChauffeur
	 */
	public boolean isAvecChauffeur() {
		return avecChauffeur;
	}

	/**
	 * @param avecChauffeur the avecChauffeur to set
	 */
	public void setAvecChauffeur(boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
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

	/**Getter for chauffeur
	 * @return chauffeur
	 */
	public Personne getChauffeur() {
		return chauffeur;
	}

	/**
	 * @param chauffeur the chauffeur to set
	 */
	public void setChauffeur(Personne chauffeur) {
		this.chauffeur = chauffeur;
	}

	/**Getter for vehicule
	 * @return vehicule
	 */
	public Vehicule getVehicule() {
		return vehicule;
	}

	/**
	 * @param vehicule the vehicule to set
	 */
	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}
	
	
}
