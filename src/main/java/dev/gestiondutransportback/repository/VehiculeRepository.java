package dev.gestiondutransportback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import dev.gestiondutransportback.entity.Categorie;
import dev.gestiondutransportback.entity.Vehicule;

public interface VehiculeRepository extends JpaRepository<Vehicule, Integer>{
	
	

}
