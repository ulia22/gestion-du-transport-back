package dev.gestiondutransportback.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.gestiondutransportback.entity.Reservation;
import dev.gestiondutransportback.repository.ReservationRepository;
import dev.gestiondutransportback.view.ReservationView;
import dev.gestiondutransportback.view.VehiculeView;

import java.time.*;


@RestController
@RequestMapping("/reservations")
@CrossOrigin(origins = {"*"})
public class ReservationsControlleur {
	
	@Autowired ReservationRepository reservationRepository;
	
	@PostMapping
	@Transactional
	public ReservationView create(@RequestBody ReservationView vehiculeView){
		
		
		Reservation reservation = new Reservation();
		
		reservation.setAvecChauffeur(false);
		reservation.setChauffeur(null);
		
		reservation.setPersonne(null);
		
		//Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant())
		reservation.setDateReserv(vehiculeView.getReservation().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		reservation.setDateRetour(vehiculeView.getRetour().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		
		reservation = reservationRepository.save(reservation);
		
		return vehiculeView.view(reservation);
		
	}

}
