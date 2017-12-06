package dev.gestiondutransportback.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.Personne;
import dev.gestiondutransportback.entity.Roles;
import dev.gestiondutransportback.repository.PersonneRepository;
import dev.gestiondutransportback.view.AccountEtPersonneView;

@RestController
@RequestMapping("/chauffeurs")
@CrossOrigin(origins = {"*"})
public class ChauffeursController {

	@Autowired private PersonneRepository personneServ;
	
	@GetMapping
	List<AccountEtPersonneView> listerChauffeur(){
		List<Personne> personnes = personneServ.findAll().stream()
				.filter(p-> p.getAccount().getRole().equals(Roles.CHAUFFEUR) || p.getAccount().getRole().equals(Roles.ADMINISTRATEUR))
				.collect(Collectors.toList());
		 List<AccountEtPersonneView> accEtPers = personnes.stream().map(p->new AccountEtPersonneView(p.getAccount(), p)).collect(Collectors.toList());
		 return accEtPers;
	}
	
	@PostMapping
	List<AccountEtPersonneView> ajouterChauffeur(@RequestBody String matricule){
		Personne nouveauChauffeur = personneServ.findByMatricule(matricule);
		if(!nouveauChauffeur.getAccount().getRole().equals(Roles.ADMINISTRATEUR) && !nouveauChauffeur.getAccount().getRole().equals(Roles.CHAUFFEUR)){
			nouveauChauffeur.getAccount().setRole(Roles.CHAUFFEUR);
		}
		personneServ.save(nouveauChauffeur);
		List<Personne> personnes = personneServ.findAll().stream()
				.filter(p-> p.getAccount().getRole().equals(Roles.CHAUFFEUR) || p.getAccount().getRole().equals(Roles.ADMINISTRATEUR))
				.collect(Collectors.toList());
		 List<AccountEtPersonneView> accEtPers = personnes.stream().map(p->new AccountEtPersonneView(p.getAccount(), p)).collect(Collectors.toList());
		 return accEtPers;
	}
}
