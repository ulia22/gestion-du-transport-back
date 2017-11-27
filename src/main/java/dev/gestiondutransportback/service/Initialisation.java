package dev.gestiondutransportback.service;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.gestiondutransportback.entity.Account;
import dev.gestiondutransportback.entity.AnnonceCovoit;
import dev.gestiondutransportback.entity.Categorie;
import dev.gestiondutransportback.entity.Marque;
import dev.gestiondutransportback.entity.Modele;
import dev.gestiondutransportback.entity.Personne;
import dev.gestiondutransportback.entity.Reservation;
import dev.gestiondutransportback.entity.Roles;
import dev.gestiondutransportback.entity.Statut;
import dev.gestiondutransportback.entity.Vehicule;
import dev.gestiondutransportback.repository.AccountRepository;
import dev.gestiondutransportback.repository.AnnonceCovoitRepository;
import dev.gestiondutransportback.repository.MarqueRepository;
import dev.gestiondutransportback.repository.ModeleRepository;
import dev.gestiondutransportback.repository.PersonneRepository;
import dev.gestiondutransportback.repository.ReservationRepository;
import dev.gestiondutransportback.repository.VehiculeRepository;

@Service
public class Initialisation {
	
	@Autowired private AccountRepository accountServ;
	@Autowired private AnnonceCovoitRepository annCovServ;
	@Autowired private MarqueRepository marqueServ;
	@Autowired private ModeleRepository modeleServ;
	@Autowired private PersonneRepository personneServ;
	@Autowired private ReservationRepository reservationServ;
	@Autowired private VehiculeRepository vehiculeServ;

	public void initAccount(){
		if(accountServ.count()==0){
			Stream.of(new Account("admin", "admin", Roles.ADMINISTRATEUR),
					new Account("collaborateur", "collaborateur", Roles.COLLABORATEUR),
					new Account("chauffeur", "chauffeur", Roles.CHAUFFEUR)).forEach(accountServ::save);;
		}
	}
	
	public void initModele(){
		if(modeleServ.count()==0){
			Stream.of(new Modele("XS-23", Categorie.CITADINES_POLYVALENTES, marqueServ.findOne(1))).forEach(modeleServ::save);;
		}
	}
	
	public void initMarque(){
		if(marqueServ.count()==0){
			Stream.of(new Marque("Peugeot")).forEach(marqueServ::save);;
		}
	}
	
	public void initVehicule(){
		if(vehiculeServ.count()==0){
			Stream.of(new Vehicule("010203", "https://www.alexandre-marine.fr/s/cc_images/cache_2436147775.jpg?t=1395164051", Statut.EN_SERVICE, marqueServ.findOne(1))).forEach(vehiculeServ::save);
		}
	}
	
	public void initReservation(){
		if(reservationServ.count()==0){
			Stream.of(new Reservation(LocalDateTime.now(), LocalDateTime.of(2018, 12 , 5, 12, 00), false, vehiculeServ.findOne(1),personneServ.findOne(1), personneServ.findOne(2))).forEach(reservationServ::save);;
		}
		
	}
	
	public void initAnnonceCovoit(){
		if(annCovServ.count()==0){
			Stream.of(new AnnonceCovoit("Maison", "Loin", "010203", "BMW", "BM-25", 3, LocalDateTime.now(), LocalDateTime.of(2018, 12, 5, 12, 00), personneServ.findOne(1), personneServ.findOne(2) )).forEach(annCovServ::save);
		}
	}
	
	public void initPersonne(){
		if(personneServ.count()==0){
			Stream.of(new Personne("Sto","Ange", "permis B", "010203", accountServ.findOne(1)),
					new Personne("Truc","Joris", "permis B", "010203", accountServ.findOne(2))).forEach(personneServ::save);
		}
		
	}
}
