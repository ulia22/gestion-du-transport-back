package dev.gestiondutransportback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestiondutransportback.entity.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Integer>{

	public Marque findByNom(String nom);

}
