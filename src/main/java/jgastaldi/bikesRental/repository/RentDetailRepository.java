package jgastaldi.bikesRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgastaldi.bikesRental.model.Rent;
import jgastaldi.bikesRental.model.RentDetail;

@Repository
public interface RentDetailRepository extends JpaRepository<RentDetail, Long> {

	public List<RentDetail> findAllByRent(Rent rent);
}
