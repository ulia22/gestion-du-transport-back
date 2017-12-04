package dev.gestiondutransportback.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.gestiondutransportback.entity.Account;
import dev.gestiondutransportback.entity.AnnonceCovoit;
import dev.gestiondutransportback.entity.Categorie;
import dev.gestiondutransportback.entity.Marque;
import dev.gestiondutransportback.entity.Modele;
import dev.gestiondutransportback.entity.Personne;
import dev.gestiondutransportback.entity.Reservation;
import dev.gestiondutransportback.entity.Roles;
import dev.gestiondutransportback.entity.Statut;
import dev.gestiondutransportback.entity.UserJson;
import dev.gestiondutransportback.entity.Vehicule;
import dev.gestiondutransportback.repository.AccountRepository;
import dev.gestiondutransportback.repository.AnnonceCovoitRepository;
import dev.gestiondutransportback.repository.MarqueRepository;
import dev.gestiondutransportback.repository.ModeleRepository;
import dev.gestiondutransportback.repository.PersonneRepository;
import dev.gestiondutransportback.repository.ReservationRepository;
import dev.gestiondutransportback.repository.VehiculeRepository;
import dev.gestiondutransportback.utils.Utils;

@Service
public class Initialisation {

	@Autowired
	private AccountRepository accountServ;
	@Autowired
	private AnnonceCovoitRepository annCovServ;
	@Autowired
	private MarqueRepository marqueServ;
	@Autowired
	private ModeleRepository modeleServ;
	@Autowired
	private PersonneRepository personneServ;
	@Autowired
	private ReservationRepository reservationServ;
	@Autowired
	private VehiculeRepository vehiculeServ;

	public void initAccount() {
		if (accountServ.count() == 0) {
			Stream.of(new Account("admin", "admin", Roles.ADMINISTRATEUR),
					new Account("collaborateur", "collaborateur", Roles.COLLABORATEUR),
					new Account("chauffeur", "chauffeur", Roles.CHAUFFEUR)).forEach(accountServ::save);
			;
		}
	}

	public void initModele() {
		if (modeleServ.count() == 0) {
			Stream.of(new Modele("XS-23", Categorie.CITADINES_POLYVALENTES, marqueServ.findOne(1)))
					.forEach(modeleServ::save);
			;
		}
	}

	public void initMarque() {
		if (marqueServ.count() == 0) {
			Stream.of(new Marque("Peugeot")).forEach(marqueServ::save);
			;
		}
	}

	public void initVehicule() {
		if (vehiculeServ.count() == 0) {
			Stream.of(new Vehicule("010203",
					"https://www.alexandre-marine.fr/s/cc_images/cache_2436147775.jpg?t=1395164051", Statut.EN_SERVICE,
					4, modeleServ.findOne(1))).forEach(vehiculeServ::save);
		}
	}

	public void initReservation() {
		if (reservationServ.count() == 0) {
			Stream.of(new Reservation(LocalDateTime.now(), LocalDateTime.of(2018, 12, 5, 12, 00), false,
					vehiculeServ.findOne(1), personneServ.findOne(1), personneServ.findOne(2)))
					.forEach(reservationServ::save);
			;
		}

	}

	public void initAnnonceCovoit() {
		if (annCovServ.count() == 0) {
			int nbAnnonce = 40;
			int yearsStart = 1980;
			for (int i = 0; i < nbAnnonce; i++) {
				annCovServ.save(new AnnonceCovoit("Maison" + i, "Loin" + i, "0000" + i, "BMW" + i, "BM-25", 5,
						LocalDateTime.of(yearsStart + i, 12, 5, 12, 00), LocalDateTime.now(), personneServ.findOne(1),
						personneServ.findOne(2)));
			}

			// Stream.of(new AnnonceCovoit("Maison", "Loin", "010203", "BMW",
			// "BM-25", 3, LocalDateTime.of(2018, 12, 5, 12, 00),
			// LocalDateTime.now(), personneServ.findOne(1),
			// personneServ.findOne(2) ),
			// new AnnonceCovoit("DTA", "Paris", "01258", "Ferrarri", "Enzo", 4,
			// LocalDateTime.of(2012, 12, 5, 12, 00), LocalDateTime.now(),
			// personneServ.findOne(1), personneServ.findOne(2) )
			// ).forEach(annCovServ::save);
		}
	}

	public void initPersonne() {
		if (personneServ.count() == 0) {
			Stream.of(new Personne("Sto", "Ange", "permis B", "010203", accountServ.findOne(1)),
					new Personne("Truc", "Joris", "permis B", "010203", accountServ.findOne(2)),
					new Personne("qsd", "qsd", "qdsqdd B", "515635", accountServ.findOne(3)))
					.forEach(personneServ::save);
		}
	}

	public void initUserJson() throws IOException {

		String str = Utils
				.get("https://raw.githubusercontent.com/DiginamicFormation/ressources-atelier/master/users.json");

		JsonFactory jsonFactory = new JsonFactory();

		@SuppressWarnings("deprecation")
		JsonParser jsonParser = jsonFactory.createJsonParser(str);
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<UserJson>> mapTypeUser = new TypeReference<List<UserJson>>() {
		};

		List<UserJson> liste = mapper.readValue(jsonParser, mapTypeUser);

		liste.forEach(userJson -> {
			accountServ.save(new Account(userJson.getEmail(), userJson.getPassword(), Roles.COLLABORATEUR));
			personneServ.save(new Personne(userJson.getNom(), userJson.getPrenom(), userJson.getMatricule(),
					accountServ.findByEmail(userJson.getEmail()), userJson.getPhoto()));
		});

	}
}
