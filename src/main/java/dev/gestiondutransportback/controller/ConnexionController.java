package dev.gestiondutransportback.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.Account;
import dev.gestiondutransportback.exception.ConnexionException;
import dev.gestiondutransportback.repository.AccountRepository;

@RestController
@RequestMapping("/connexion")
@CrossOrigin(origins = {"*"})
public class ConnexionController {
	
	@Autowired private AccountRepository accountServ;
	
	@PostMapping
	public String postConnexion(@RequestBody Map<String, String> map) throws ConnexionException{
		
		Account account = accountServ.findByEmail(map.get("email"));
		if (account.getMdp() == map.get("password")){
			
			return account.getRole().toString();
		} else {
			throw new ConnexionException("L'email ou le mot de passe est incorecte");
		}
		
		
	}

}
