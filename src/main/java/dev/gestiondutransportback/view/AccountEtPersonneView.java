/**
 * 
 */
package dev.gestiondutransportback.view;

import dev.gestiondutransportback.entity.Account;
import dev.gestiondutransportback.entity.Personne;
import dev.gestiondutransportback.entity.Roles;

/**
 * @author ETY9
 *
 */
public class AccountEtPersonneView {

	private String email;

	private Roles role;

	private Integer idPersonne;
	
	private String nom;

	private String prenom;

	private String permis;

	private String matricule;

	/**
	 * 
	 */
	public AccountEtPersonneView() {
		super();
	}

	/**
	 * 
	 */
	public AccountEtPersonneView(Account a, Personne p) {
		this();
		this.email = a.getEmail();
		this.role = a.getRole();
		this.idPersonne = p.getId();
		this.nom = p.getNom();
		this.prenom = p.getPrenom();
		this.permis = p.getPermis();
		this.matricule = p.getMatricule();
	}
	
	public AccountEtPersonneView(Personne p) {
		this();
		this.idPersonne = p.getId();
		this.nom = p.getNom();
		this.prenom = p.getPrenom();
		this.permis = p.getPermis();
		this.matricule = p.getMatricule();
	}

	/**
	 * @param email
	 * @param mdp
	 * @param role
	 * @param nom
	 * @param prenom
	 * @param permis
	 * @param matricule
	 */
	public AccountEtPersonneView(String email, Roles role, Integer idP, String nom, String prenom, String permis, String matricule) {
		this();
		this.email = email;
		this.role = role;
		this.idPersonne = idP;
		this.nom = nom;
		this.prenom = prenom;
		this.permis = permis;
		this.matricule = matricule;
	}

	/**
	 * Getter for email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for email
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter for role.
	 * 
	 * @return the role
	 */
	public Roles getRole() {
		return role;
	}

	/**
	 * Setter for role
	 * 
	 * @param role
	 *            the role to set
	 */
	public void setRole(Roles role) {
		this.role = role;
	}

	/**
	 * Getter for nom.
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter for nom
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter for prenom.
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter for prenom
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter for permis.
	 * 
	 * @return the permis
	 */
	public String getPermis() {
		return permis;
	}

	/**
	 * Setter for permis
	 * 
	 * @param permis
	 *            the permis to set
	 */
	public void setPermis(String permis) {
		this.permis = permis;
	}

	/**
	 * Getter for matricule.
	 * 
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter for matricule
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Getter for idPersonne.
	 * @return the idPersonne
	 */
	public Integer getIdPersonne() {
		return idPersonne;
	}

	/**
	 * Setter for idPersonne
	 * @param idPersonne the idPersonne to set
	 */
	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}
}
