package dev.gestiondutransportback.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dev.gestiondutransportback.entity.Categorie;
import dev.gestiondutransportback.entity.Marque;
import dev.gestiondutransportback.entity.Modele;
import dev.gestiondutransportback.entity.Statut;
import dev.gestiondutransportback.entity.Vehicule;
import dev.gestiondutransportback.repository.MarqueRepository;
import dev.gestiondutransportback.repository.ModeleRepository;
import dev.gestiondutransportback.repository.VehiculeRepository;
import dev.gestiondutransportback.view.VehiculeView;

@RestController
@RequestMapping("/vehicules")
@CrossOrigin(origins = {"*"})
public class VehiculesController {

	@Autowired ModeleRepository modeleRepository;
	
	@Autowired VehiculeRepository vehiculeRepository;
	
	@Autowired MarqueRepository marqueRepository;
	
	@GetMapping(value="/categories")
	public List<String> listerCategorie(){

		return Categorie.getEnum();
		
	}
	
	@GetMapping
	public List<VehiculeView> listerVehicule(){

		return vehiculeRepository.findAll().stream().map(v -> VehiculeView.view(v)).collect(Collectors.toList());
		
	}
	
	@PostMapping
	@Transactional
	public  VehiculeView create(@RequestBody VehiculeView vehiculeView){
		

		
		Marque marque = marqueRepository.findByNom(vehiculeView.getMarque());
		
		if(marque==null){
			
			marque = new Marque();
			
			marque.setNom(vehiculeView.getMarque());
			
			marqueRepository.save(marque);
			
			
		}
		
		Modele modele = modeleRepository.findByNom(vehiculeView.getModele());
		
		if(modele==null){
			modele= new Modele();
			modele.setCategorie(Categorie.toCategorie(vehiculeView.getCategorie()));
			modele.setNom(vehiculeView.getModele());
			modele.setMarque(marque);
			
			modeleRepository.save(modele);
		}
		
		
		Vehicule vehicule = new Vehicule(vehiculeView.getImmatriculation(), vehiculeView.getPhoto(), Statut.EN_SERVICE,Integer.parseInt(vehiculeView.getNbp()),modele);
	
		
		vehicule= vehiculeRepository.save(vehicule);
		
		
		return VehiculeView.view(vehicule);
		
	}
	
}
