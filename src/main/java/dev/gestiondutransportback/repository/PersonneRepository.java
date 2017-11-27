package dev.gestiondutransportback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestiondutransportback.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{

}
