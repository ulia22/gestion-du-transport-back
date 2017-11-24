package dev.gestiondutransportback.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Marque {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nom;
	
	@OneToMany(mappedBy="marque")
	private Set<Vehicule> vehicules;
	
	@OneToMany (mappedBy="marque")
	private Set<Modele> modeles;
	
	public Marque() {
		this.modeles=new HashSet<>();
		this.vehicules=new HashSet<>();
		
	}

	public Marque(String nom) {
		super();
		this.nom = nom;
		this.modeles=new HashSet<>();
		this.vehicules=new HashSet<>();
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

	/**Getter for modeles
	 * @return modeles
	 */
	public Set<Modele> getModeles() {
		return modeles;
	}

	/**
	 * @param modeles the modeles to set
	 */
	public void setModeles(Set<Modele> modeles) {
		this.modeles = modeles;
	}
	
	
	
}
