package jgastaldi.bikesRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgastaldi.bikesRental.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	public Client findByIdentificationNumber(Long identificationNumber);
}
