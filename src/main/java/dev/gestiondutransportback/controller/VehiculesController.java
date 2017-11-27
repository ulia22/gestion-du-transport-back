package dev.gestiondutransportback.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dev.gestiondutransportback.entity.Categorie;
import dev.gestiondutransportback.entity.Marque;
import dev.gestiondutransportback.entity.Vehicule;
import dev.gestiondutransportback.repository.MarqueRepository;
import dev.gestiondutransportback.repository.VehiculeRepository;

@RestController
@RequestMapping("/vehicules")
@CrossOrigin(origins = {"*"})
public class VehiculesController {

	@Autowired EntityManager entityManager;
	
	@Autowired MarqueRepository marqueRepository;
	
	@GetMapping
	public List<String> listerCategorie(){

		return Categorie.getEnum();
		
	}
	
	@PostMapping
	@Transactional
	public Vehicule create(@RequestBody Vehicule vehicule){
		
		Marque marque = marqueRepository.findByNom(vehicule.getMarque().getNom());
		Vehicule voit = new Vehicule();
		
		
		
		vehicule.setMarque(marque);
	
		
		return entityManager.merge(vehicule);
		
	}
	
}
