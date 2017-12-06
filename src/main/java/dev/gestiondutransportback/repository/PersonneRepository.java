package dev.gestiondutransportback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestiondutransportback.entity.Account;
import dev.gestiondutransportback.entity.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Integer>{

	public Personne findByAccount(Account a);
	
	public Personne findById(Integer id);
	
	public Personne findByMatricule(String matricule);
}
