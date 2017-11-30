package dev.gestiondutransportback.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.AnnonceCovoit;
import dev.gestiondutransportback.exception.ReservationException;
import dev.gestiondutransportback.repository.AnnonceCovoitRepository;
import dev.gestiondutransportback.repository.PersonneRepository;
import dev.gestiondutransportback.view.AnnonceCovoitView;

@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = {"*"})
public class ReservationsControlleur {

	@Autowired PersonneRepository personneServ;
	@Autowired AnnonceCovoitRepository annonceCovoitServ;
	
	@GetMapping("/annoncesCovoiturages")
	public List<AnnonceCovoitView> listerReservations(@RequestParam(value="covoitureurId", required=true) Integer covoitureurId) throws ReservationException {
		
			List<AnnonceCovoit> lAnnonce = annonceCovoitServ.findByIdCovoitureur(covoitureurId);
			List<AnnonceCovoitView> lAnnonceView = lAnnonce.stream().map(a -> new AnnonceCovoitView(a)).collect(Collectors.toList());
			if(lAnnonceView != null){
				return lAnnonceView;
			}else{
				throw new ReservationException("Problème à la récupération des réservations.");
			}
	}
}
