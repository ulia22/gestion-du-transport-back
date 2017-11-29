package dev.gestiondutransportback.view;

import dev.gestiondutransportback.entity.Vehicule;

public class VehiculeView {
	
	public String immatriculation;
    public String marque;
    public String nbp;
    public String photo;
    public String categorie;
    public String modele;
    
    public VehiculeView(){
    	
    }
    
    public VehiculeView(String immatriculation,String marque,String nbp,String photo,String categorie,
    String modele){
    	
    	this.immatriculation=immatriculation;
    	this.marque=marque;
    	this.nbp=nbp;
    	this.photo=photo;
    	this.categorie=categorie;
    	this.modele=modele;
    	
    }
    
    public static VehiculeView view(Vehicule vehicule){
    	return new VehiculeView(vehicule.getImmatriculation(),vehicule.getModele().getMarque().getNom(),Integer.toString(vehicule.getNbp()),
    	vehicule.getPhoto(),vehicule.getModele().getCategorie().toString(),vehicule.getModele().getNom());
    }
    
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
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
    
    
    

}
