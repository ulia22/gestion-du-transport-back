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
import dev.gestiondutransportback.utils.GetHttp;

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
			Stream.of(new Modele("Carrera S 911", Categorie.CITADINES_POLYVALENTES, marqueServ.findOne(1)),
					new Modele("M2 Coupé", Categorie.COMPACTES, marqueServ.findOne(2)),
					new Modele("E-Class Coupé", Categorie.BERLINE_TAILLE_M, marqueServ.findOne(3)), 
					new Modele("Model Y", Categorie.MICRO_URBAINES, marqueServ.findOne(4)))
					.forEach(modeleServ::save);
			
		}
	}

	public void initMarque() {
		if (marqueServ.count() == 0) {
			Stream.of(new Marque("Porsche"), new Marque("BMW"), new Marque("Mercedes-Benz"), new Marque("Tesla"))
					.forEach(marqueServ::save);

		}
	}

	public void initVehicule() {
		if (vehiculeServ.count() == 0) {
			Stream.of(new Vehicule("Immatriculation 1",
					"http://www.autoguide.com/blog/wp-content/gallery/1-millionth-porsche-911/high_one_millionth_911_911_carrera_s_kit_2017_porsche_ag-1.jpg", Statut.EN_SERVICE,
					4, modeleServ.findOne(1)),
					new Vehicule("Immatriculation 2",
							"https://m.bmw.fr/content/dam/bmw/common/all-models/m-series/m2-coupe/2015/at-a-glance/m2-at-a-glance-stage-presentation.jpg/_jcr_content/renditions/cq5dam.resized.img.1680.large.time1493915009567.jpg", Statut.EN_SERVICE,
							4, modeleServ.findOne(2)),
					new Vehicule("Immatriculation 3",
							"https://www.autocar.co.uk/sites/autocar.co.uk/files/mercedes-benz-e-class-coupe_0.jpg", Statut.HORS_SERVICE,
							4, modeleServ.findOne(3)),
					new Vehicule("Immatriculation 4",
							"http://st.motortrend.ca/uploads/sites/5/2016/10/2016-Tesla-Model-S-60-front-three-quarter-in-motion-02-e1477952073682.jpg", Statut.EN_REPARATION,
							4, modeleServ.findOne(4))
					).forEach(vehiculeServ::save);
		}
	}

	public void initReservation() {
		if (reservationServ.count() == 0) {
			Stream.of(new Reservation(LocalDateTime.now(), LocalDateTime.of(2017, 7, 12, 18, 00), false,
					vehiculeServ.findOne(1), personneServ.findOne(1), personneServ.findOne(2)),
					new Reservation(LocalDateTime.of(2017, 12, 9, 10, 50), LocalDateTime.of(2017, 12, 10, 12, 00), false,
							vehiculeServ.findOne(2), personneServ.findOne(2), personneServ.findOne(3)),
					new Reservation(LocalDateTime.of(2018, 1, 1, 9, 53), LocalDateTime.of(2018, 3, 1, 12, 00), false,
							vehiculeServ.findOne(1), personneServ.findOne(3), personneServ.findOne(1)))
					.forEach(reservationServ::save);

		}

	}

	public void initAnnonceCovoit() {
		Stream.of(new AnnonceCovoit("13 rue de la Haute Forêt, Nantes 44300", "15 chemin de Chibario, Venerque 31810" , "Immatriculation 1" , "BMW", "BM-25", 4,
						LocalDateTime.of(2017 , 12, 5, 12, 00), LocalDateTime.of(2017 , 12, 5, 10, 00), personneServ.findOne(1),
						personneServ.findOne(2)), 
				new AnnonceCovoit("Nantes", "Strasbourg" , "Immatriculation 6" , "Renault", "21", 4,
						LocalDateTime.of( 2016 , 8, 9, 12, 00), LocalDateTime.of(2016 , 12, 5, 10, 00), personneServ.findOne(2),
						personneServ.findOne(3)),
				new AnnonceCovoit("Moscou", "Perpignan" , "Immatriculation 2" , "Subaru", "Impreza", 2,
						LocalDateTime.of( 2015 , 1, 1, 2, 00), LocalDateTime.of(2015 , 1, 1, 1, 00), personneServ.findOne(3),
						personneServ.findOne(1)),
				new AnnonceCovoit("Paris", "Marseille" , "Immatriculation 3" , "Fiat", "Punto", 4,
						LocalDateTime.of(2017 , 12, 7, 19, 00), LocalDateTime.of(2017 , 12, 5, 10, 00), personneServ.findOne(1),
						personneServ.findOne(2)), 
				new AnnonceCovoit("Nantes", "Amsterdam" , "Immatriculation 4" , "Peugeot", "206", 4,
						LocalDateTime.of( 2018 , 1, 1, 2, 00), LocalDateTime.of(2018 , 1, 1, 1, 00), personneServ.findOne(2),
						personneServ.findOne(3)),
				new AnnonceCovoit("Barcelone", "Lille" , "Immatriculation 5" , "Seat", "Ibiza", 4,
						LocalDateTime.of( 2015 , 1, 1, 2, 00), LocalDateTime.of(2015 , 1, 1, 1, 00), personneServ.findOne(3),
						personneServ.findOne(1))
				).forEach(annCovServ::save);
			

		
	}

	public void initPersonne() {
		if (personneServ.count() == 0) {
			Stream.of(new Personne("Le Grand", "Ange", "permis B", "010203", accountServ.findOne(1), "https://pbs.twimg.com/profile_images/805774049892855808/Qw1m1Uvo.jpg"),
					new Personne("Trash Silver", "Joris", "permis B", "010203", accountServ.findOne(2), "https://lol.seek-team.com/images/medals/silver_1.png?v22"),
					new Personne("Chocolatine", "Clément", "Pas de permis", "010203", accountServ.findOne(3), "http://couteaux-et-tirebouchons.com/wp-content/uploads/2016/01/Pain-au-chocolat-ou-chocolatine.jpg"))
					.forEach(personneServ::save);
		}
	}

	public void initUserJson() throws IOException {

		String str = GetHttp
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
