package dev.gestiondutransportback.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Modele {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private String nom;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn
	private Marque marque;
	
	@OneToMany(mappedBy="modele")
	private Set<Vehicule> vehicules;
	
	public Modele() {
		
	}

	public Modele(String nom, Categorie categorie) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.vehicules= new HashSet<>();
	}
	public Modele(String nom, Categorie categorie, Marque marque) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.marque=marque;
		this.vehicules= new HashSet<>();
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

	/**Getter for categorie
	 * @return categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	/**Getter for marque
	 * @return marque
	 */
	public Marque getMarque() {
		return marque;
	}

	/**
	 * @param marque the marque to set
	 */
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	/**Getter for vehicules
	 * @return vehicules
	 */
	public Set<Vehicule> getVehicules() {
		return vehicules;
	}

	/**
	 * @param vehicules the vehicules to set
	 */
	public void setVehicules(Set<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}
	
	
}
