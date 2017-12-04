package dev.gestiondutransportback.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.gestiondutransportback.entity.AnnonceCovoit;
import dev.gestiondutransportback.entity.Personne;

public interface AnnonceCovoitRepository extends JpaRepository<AnnonceCovoit, Integer> {

	@Query(value = "SELECT * FROM annonce_covoit WHERE annonce_covoit.id IN (\n" 
			+ "SELECT DISTINCT annonce_covoit.id\n"
			+ "FROM `annonce_covoit` \n"
			+ "INNER JOIN reservation_covoit ON reservation_covoit.id_annonce_covoit = annonce_covoit.id\n"
			+ "INNER JOIN personne ON reservation_covoit.id_covoitureur = ?1 \n)", nativeQuery = true)
	public List<AnnonceCovoit> findByIdCovoitureur(Integer idCovoitureur);
	
	public List<AnnonceCovoit> findByPersonne(Personne personne);
}
