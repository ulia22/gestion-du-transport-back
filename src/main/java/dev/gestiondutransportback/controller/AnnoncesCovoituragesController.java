package dev.gestiondutransportback.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.AnnonceCovoit;
import dev.gestiondutransportback.repository.AnnonceCovoitRepository;
import dev.gestiondutransportback.view.AnnonceCovoitView;

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
	
	@GetMapping
	public List<AnnonceCovoitView> listAnnonces(@RequestParam(value = "personneId", required = true) Integer personneId){
		List<AnnonceCovoit> annonces = annonceCovoitServ.findAll();
		List<AnnonceCovoitView> annoncesView = annonces.stream().filter(a->a.getPersonne().getId() != personneId).map(a->new AnnonceCovoitView(a)).collect(Collectors.toList());
		return annoncesView;
	}
}
