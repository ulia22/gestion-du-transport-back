package dev.gestiondutransportback.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public List<Vehicule> listerVehicule(){

		return vehiculeRepository.findAll();
		
	}
	
	@PostMapping
	@Transactional
	public List<String>create(@RequestBody List<String> parse){
		

		
		Marque marque = marqueRepository.findByNom(parse.get(2));
		
		if(marque==null){
			
			marque = new Marque();
			
			marque.setNom(parse.get(2));
			
			marqueRepository.save(marque);
			
			
		}
		
		Modele model = modeleRepository.findByNom(parse.get(3));
		
		if(model==null){
			model= new Modele();
			model.setCategorie(Categorie.toCategorie(parse.get(1)));
			model.setNom(parse.get(3));
			model.setMarque(marque);
			
			modeleRepository.save(model);
		}
		
		
		Vehicule vehicule = new Vehicule(parse.get(0),parse.get(5), Statut.EN_SERVICE, marque,Integer.parseInt(parse.get(4)));
		
		
	
		
		vehicule= vehiculeRepository.save(vehicule);
		
		List l = new ArrayList();
		l.add(parse.get(0));
		l.add(parse.get(1));
		l.add(parse.get(2));
		l.add(parse.get(3));
		l.add(parse.get(4));
		l.add(parse.get(5));
		
		return l;
		
	}
	
}
