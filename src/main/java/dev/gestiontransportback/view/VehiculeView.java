package dev.gestiontransportback.view;

import java.io.Serializable;

import dev.gestiondutransportback.entity.Vehicule;

public class VehiculeView {
	
	String marque;
	
	String nbp;
	
	String photo;
	
	String categorie;
	
	String modele;
	
	String immatriculation;
	
	public VehiculeView(){
		
	}
	
	public VehiculeView(String immatriculation,String marque,String nbp,String photo,String categorie,String modele){
		this.marque=marque;
		this.nbp=nbp;
		this.photo=photo;
		this.categorie=categorie;
		this.modele=modele;
		this.immatriculation=immatriculation;
	}
	
	public static VehiculeView view(Vehicule vehicule){
		
		String categorie = vehicule.getModele().getCategorie().toString();
		
		
		return new VehiculeView(vehicule.getImmatriculation(),vehicule.getModele().getMarque().getNom(),String.valueOf(vehicule.getNbp()),vehicule.getPhoto(),categorie,vehicule.getModele().getNom());
		
	}


	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getNbp() {
		return nbp;
	}

	public void setNbp(String nbp) {
		this.nbp = nbp;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	
	
	

}
