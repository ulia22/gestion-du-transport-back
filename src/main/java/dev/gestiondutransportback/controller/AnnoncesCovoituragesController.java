package dev.gestiondutransportback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.AnnonceCovoit;
import dev.gestiondutransportback.repository.AnnonceCovoitRepository;

@RestController
@RequestMapping("/annoncesCovoiturages")
@CrossOrigin(origins = {"*"})
public class AnnoncesCovoituragesController {

	@Autowired private AnnonceCovoitRepository annonceCovoitServ;
	@PostMapping("/creer")
	public AnnonceCovoit creerAnnonce(@RequestBody AnnonceCovoit annonce){
		annonceCovoitServ.save(annonce);
		return annonce;
	}
}
