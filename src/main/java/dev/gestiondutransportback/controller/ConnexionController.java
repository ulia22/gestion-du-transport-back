package dev.gestiondutransportback.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.Account;
import dev.gestiondutransportback.entity.Personne;
import dev.gestiondutransportback.exception.ConnexionException;
import dev.gestiondutransportback.repository.AccountRepository;
import dev.gestiondutransportback.repository.PersonneRepository;
import dev.gestiondutransportback.view.AccountEtPersonneView;

@RestController
@RequestMapping("/connexion")
@CrossOrigin(origins = { "*" })
public class ConnexionController {

	@Autowired
	private AccountRepository accountServ;
	@Autowired
	private PersonneRepository personneServ;

	@PostMapping
	public AccountEtPersonneView postConnexion(@RequestBody Map<String, String> map) throws ConnexionException {
		System.out.println(map.get("email")+" "+map.get("password"));
		Account account = accountServ.findByEmail(map.get("email"));
		if (account.getMdp().equals(map.get("password"))) {
			Personne personne = personneServ.findByAccount(account);
			if (personne != null) {
				return new AccountEtPersonneView(account, personne);
			} else {
				return new AccountEtPersonneView(account, new Personne());
			}
			
		} else {
			throw new ConnexionException("L'email ou le mot de passe est incorecte");
		}

	}

}
