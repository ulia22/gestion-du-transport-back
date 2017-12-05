package dev.gestiondutransportback.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

import dev.gestiondutransportback.exception.GoogleException;
import dev.gestiondutransportback.service.GoogleApiService;

@RestController
@RequestMapping("/googleApi")
@CrossOrigin(origins = { "*" })
public class GoogleApiController {

	@Autowired private GoogleApiService googleServ;
	
	@PostMapping("/lister")
	public JsonNode postListe(@RequestBody String keyword){
		
		try {
			return googleServ.list(keyword);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	@PostMapping("/dureeEtDistance")
	public Map<String, String> postDureeEtDistance(@RequestBody Map<String, String> villes) throws GoogleException{
		try {
			return googleServ.dureeEtDistance(villes.get("villeDepart"), villes.get("villeArrive"));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
