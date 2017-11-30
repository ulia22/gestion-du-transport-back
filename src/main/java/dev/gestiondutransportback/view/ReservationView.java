/**
 * 
 */
package dev.gestiondutransportback.view;

import java.time.*;
import java.util.Date;

import dev.gestiondutransportback.entity.Reservation;

public class ReservationView {

	String marque;
	
	String immatriculation;
	
	String modele;
	
	Date reservation;
	
	Date retour;
	
	public ReservationView(){
		
	}
	
	public ReservationView(String marque,String immatriculation,String modele,Date reservation,
			Date retour){
		
		this.marque = marque;
		
		this.immatriculation=immatriculation;
		
		this.modele=modele;
		
		this.reservation=reservation;
		
		this.retour=retour;
		
	}
	
	public static ReservationView view(Reservation reservation){
		
		return new ReservationView(reservation.getVehicule().getModele().getMarque().getNom(),
				reservation.getVehicule().getImmatriculation(),
				reservation.getVehicule().getModele().getNom(),
				Date.from(reservation.getDateReserv().atZone(ZoneId.systemDefault()).toInstant()),
				Date.from(reservation.getDateRetour().atZone(ZoneId.systemDefault()).toInstant()))
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
	public Date getReservation() {
		return reservation;
	}

	/** Setter
	 * @param reservation the reservation to set
	 */
	public void setReservation(Date reservation) {
		this.reservation = reservation;
	}

	/** getters
	 * @return the retour
	 */
	public Date getRetour() {
		return retour;
	}

	/** Setter
	 * @param retour the retour to set
	 */
	public void setRetour(Date retour) {
		this.retour = retour;
	}
	
	
	
}
