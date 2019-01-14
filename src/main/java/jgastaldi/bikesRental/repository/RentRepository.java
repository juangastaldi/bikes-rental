package jgastaldi.bikesRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgastaldi.bikesRental.model.Client;
import jgastaldi.bikesRental.model.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent, Long> {

	public List<Rent> findAllByClient(Client client);
}
