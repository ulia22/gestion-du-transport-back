package dev.gestiondutransportback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.gestiondutransportback.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
