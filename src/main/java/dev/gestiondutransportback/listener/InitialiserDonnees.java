package dev.gestiondutransportback.listener;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import dev.gestiondutransportback.service.Initialisation;

@Component
public class InitialiserDonnees {

	@Autowired
	private Initialisation init;

	@EventListener({ ContextRefreshedEvent.class })
	void contextRefreshedEvent() throws IOException {
		init.initAccount();
		init.initMarque();
		init.initModele();
		init.initVehicule();
		init.initPersonne();
		init.initReservation();
		init.initAnnonceCovoit();
		//init.initUserJson();

	}
}
