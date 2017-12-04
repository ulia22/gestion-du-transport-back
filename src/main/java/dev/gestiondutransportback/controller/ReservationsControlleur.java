package dev.gestiondutransportback.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.Personne;
import dev.gestiondutransportback.entity.Reservation;
import dev.gestiondutransportback.repository.PersonneRepository;
import dev.gestiondutransportback.repository.ReservationRepository;
import dev.gestiondutransportback.view.ReservationViewVehicule;
import dev.gestiondutransportback.view.VehiculeView;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = {"*"})
public class ReservationsControlleur {
	
	@Autowired ReservationRepository reservationRepository;
	
	@Autowired PersonneRepository personneRepository;
	 
	
	
	
	@GetMapping("/vehiculesCovoiturages")
	public List<ReservationViewVehicule> listerReservationsVehicules(
			@RequestParam(value = "personneId", required = true) Integer personneId) {
		
		System.out.println("coter back");
		List<ReservationViewVehicule> vehiculesReserve =  reservationRepository.findByPersonneId(personneId).stream().map(r -> ReservationViewVehicule.view(r)).collect(Collectors.toList()) ;
		//List<ReservationViewVehicule> vehiculesReserveView = vehiculesReserve.stream().map(a -> new ReservationViewVehicule(a)).collect(Collectors.toList());
		
			return vehiculesReserve;
		
	}
	
	/*@PostMapping
	@Transactional
	public ReservationView create(@RequestBody ReservationView vehiculeView){
		
		System.out.println("newreserve");
		Reservation reservation = new Reservation();
		
		reservation.setAvecChauffeur(false);
		reservation.setChauffeur(null);
		
		reservation.setPersonne(null);
		
		//Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
		//reservation.setDateReserv(vehiculeView.getReservation().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		//reservation.setDateRetour(vehiculeView.getRetour().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		
		reservation = reservationRepository.save(reservation);
		
		return vehiculeView.view(reservation);
		
	}*/

}
