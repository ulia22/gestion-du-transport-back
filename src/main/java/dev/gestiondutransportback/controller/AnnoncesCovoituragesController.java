package dev.gestiondutransportback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.AnnonceCovoit;
import dev.gestiondutransportback.repository.AnnonceCovoitRepository;
import dev.gestiondutransportback.repository.PersonneRepository;
import dev.gestiondutransportback.view.AnnonceCovoitView;

@RestController
@RequestMapping("/annoncesCovoiturages")
@CrossOrigin(origins = {"*"})
public class AnnoncesCovoituragesController {

	@Autowired private AnnonceCovoitRepository annonceCovoitServ;
	@Autowired private PersonneRepository personneServ;
	
	@PostMapping("/creer")
	public AnnonceCovoitView creerAnnonce(@RequestBody AnnonceCovoit annonce){
		annonce.setPersonne(personneServ.findById(annonce.getPersonne().getId()));
		annonceCovoitServ.save(annonce);
		
		return new AnnonceCovoitView(annonce);
		
	}
}
