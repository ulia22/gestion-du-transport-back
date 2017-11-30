/**
 * 
 */
package dev.gestiondutransportback.view;

import java.time.LocalDateTime;

import dev.gestiondutransportback.entity.Reservation;

/**
 * @author ETY9
 *
 */
public class ReservationView {

	private Integer id;
	
	private LocalDateTime dateReserv;
	
	private LocalDateTime dateRetour;
	
	private boolean avecChauffeur;

	/**
	 * 
	 */
	public ReservationView() {
		super();
	}
	
	/**
	 * 
	 */
	public ReservationView(Reservation r) {
		this();
		this.id = r.getId();
		this.dateReserv = r.getDateReserv();
		this.dateRetour = r.getDateRetour();
		this.avecChauffeur = r.isAvecChauffeur();
	}

	/**
	 * @param id
	 * @param dateReserv
	 * @param dateRetour
	 * @param avecChauffeur
	 */
	public ReservationView(Integer id, LocalDateTime dateReserv, LocalDateTime dateRetour,
			boolean avecChauffeur) {
		this();
		this.id = id;
		this.dateReserv = dateReserv;
		this.dateRetour = dateRetour;
		this.avecChauffeur = avecChauffeur;
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
	 * Getter for dateReserv.
	 * @return the dateReserv
	 */
	public LocalDateTime getDateReserv() {
		return dateReserv;
	}

	/**
	 * Setter for dateReserv
	 * @param dateReserv the dateReserv to set
	 */
	public void setDateReserv(LocalDateTime dateReserv) {
		this.dateReserv = dateReserv;
	}

	/**
	 * Getter for dateRetour.
	 * @return the dateRetour
	 */
	public LocalDateTime getDateRetour() {
		return dateRetour;
	}

	/**
	 * Setter for dateRetour
	 * @param dateRetour the dateRetour to set
	 */
	public void setDateRetour(LocalDateTime dateRetour) {
		this.dateRetour = dateRetour;
	}

	/**
	 * Getter for avecChauffeur.
	 * @return the avecChauffeur
	 */
	public boolean isAvecChauffeur() {
		return avecChauffeur;
	}

	/**
	 * Setter for avecChauffeur
	 * @param avecChauffeur the avecChauffeur to set
	 */
	public void setAvecChauffeur(boolean avecChauffeur) {
		this.avecChauffeur = avecChauffeur;
	}
	
}
