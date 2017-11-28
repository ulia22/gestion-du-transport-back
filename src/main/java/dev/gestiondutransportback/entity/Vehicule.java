package dev.gestiondutransportback.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Vehicule {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String immatriculation;
	
	@Column
	private String photo;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Statut statut;
	
	@Column
	private String longitude;
	
	@Column
	private String latitude;
	
	@OneToMany (mappedBy="vehicule")
	private Set<Reservation> reservations;
	
	@ManyToOne
	@JoinColumn


	public Vehicule() {
		this.reservations=new HashSet<>();
	}
	
	public Vehicule(String immatriculation, String photo, Statut statut) {
		super();
		this.immatriculation = immatriculation;
		this.photo = photo;
		this.statut = statut;
		this.reservations=new HashSet<>();
	}
	

		super();
		this.immatriculation = immatriculation;
		this.photo = photo;
		this.statut = statut;
		this.reservations=new HashSet<>();

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

	/**Getter for photo
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**Getter for statut
	 * @return statut
	 */
	public Statut getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	/**Getter for longitude
	 * @return longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**Getter for latitude
	 * @return latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**Getter for reservations
	 * @return reservations
	 */
	public Set<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * @param reservations the reservations to set
	 */
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	/**Getter for modele
	 * @return modele
	 */
	public Modele getModele() {
		return modele;
	}

	/**
	 * @param modele the modele to set
	 */
	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public int getNbp() {
		return nbp;
	}

	public void setNbp(int nbp) {
		this.nbp = nbp;
	}
	
	
	
	

}
