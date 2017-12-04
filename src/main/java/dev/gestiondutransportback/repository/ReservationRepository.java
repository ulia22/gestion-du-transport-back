package dev.gestiondutransportback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestiondutransportback.entity.Personne;
import dev.gestiondutransportback.entity.Reservation;
import dev.gestiondutransportback.view.ReservationViewVehicule;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	List<Reservation> findByPersonneId(Integer integer);

}
