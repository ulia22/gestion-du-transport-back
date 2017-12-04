/**
 * 
 */
package dev.gestiondutransportback.view;

import java.time.*;
import java.util.Date;

import dev.gestiondutransportback.entity.Reservation;

public class ReservationViewVehicule {

	String marque;
	
	String immatriculation;
	
	String modele;
	
	LocalDateTime  reservation;
	
	LocalDateTime  retour;
	
	public ReservationViewVehicule(){
		super();
	}
	
	public ReservationViewVehicule(ReservationViewVehicule a){
		super();
	}
	
	public ReservationViewVehicule(String marque,String immatriculation,String modele,LocalDateTime  reservation,
			LocalDateTime  retour){
		
		this.marque = marque;
		
		this.immatriculation=immatriculation;
		
		this.modele=modele;
		
		this.reservation=reservation;
		
		this.retour=retour;
		
	}
	
	public static ReservationViewVehicule view(Reservation reservation){
		
		return new ReservationViewVehicule(reservation.getVehicule().getModele().getMarque().getNom(),
				reservation.getVehicule().getImmatriculation(),
				reservation.getVehicule().getModele().getNom(),
				reservation.getDateReserv(),
				reservation.getDateRetour())
				;
	}

	/** getters
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/** Setter
	 * @param marque the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/** getters
	 * @return the immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/** Setter
	 * @param immatriculation the immatriculation to set
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/** getters
	 * @return the modele
	 */
	public String getModele() {
		return modele;
	}

	/** Setter
	 * @param modele the modele to set
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/** getters
	 * @return the reservation
	 */
	public LocalDateTime  getReservation() {
		return reservation;
	}

	/** Setter
	 * @param reservation the reservation to set
	 */
	public void setReservation(LocalDateTime  reservation) {
		this.reservation = reservation;
	}

	/** getters
	 * @return the retour
	 */
	public LocalDateTime  getRetour() {
		return retour;
	}

	/** Setter
	 * @param retour the retour to set
	 */
	public void setRetour(LocalDateTime  retour) {
		this.retour = retour;
	}
	
	
	
}
