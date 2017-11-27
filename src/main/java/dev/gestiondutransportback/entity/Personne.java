package dev.gestiondutransportback.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Personne {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String permis;
	
	@Column
	private String matricule;
	
	@OneToOne
	@JoinColumn(name="ID_Account")
	private Account account;
	
	@OneToMany(mappedBy="personne")
	private Set<AnnonceCovoit> annonces;
	
	@OneToMany(mappedBy="personne")
	private Set<Reservation> reservations;
	
	@OneToMany(mappedBy="chauffeur")
	private Set<Reservation> reservationsChauffeur;
	
	public Personne() {
		this.annonces= new HashSet<>();
		this.reservations=new HashSet<>();
		this.reservationsChauffeur=new HashSet<>();
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.annonces= new HashSet<>();
		this.reservations=new HashSet<>();
		this.reservationsChauffeur=new HashSet<>();
	}

	public Personne(String nom, String prenom, String permis, String matricule, Account account) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.permis = permis;
		this.matricule = matricule;
		this.account=account;
		this.annonces= new HashSet<>();
		this.reservations=new HashSet<>();
		this.reservationsChauffeur=new HashSet<>();
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

	/**Getter for nom
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter for prenom
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**Getter for permis
	 * @return permis
	 */
	public String getPermis() {
		return permis;
	}

	/**
	 * @param permis the permis to set
	 */
	public void setPermis(String permis) {
		this.permis = permis;
	}

	/**Getter for matricule
	 * @return matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**Getter for account
	 * @return account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**Getter for annonces
	 * @return annonces
	 */
	public Set<AnnonceCovoit> getAnnonces() {
		return annonces;
	}

	/**
	 * @param annonces the annonces to set
	 */
	public void setAnnonces(Set<AnnonceCovoit> annonces) {
		this.annonces = annonces;
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

	/**Getter for reservationsChauffeur
	 * @return reservationsChauffeur
	 */
	public Set<Reservation> getReservationsChauffeur() {
		return reservationsChauffeur;
	}

	/**
	 * @param reservationsChauffeur the reservationsChauffeur to set
	 */
	public void setReservationsChauffeur(Set<Reservation> reservationsChauffeur) {
		this.reservationsChauffeur = reservationsChauffeur;
	}
	
	

}
