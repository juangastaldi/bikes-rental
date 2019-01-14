package jgastaldi.bikesRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgastaldi.bikesRental.model.BikeStatus;

@Repository
public interface BikeStatusRepository extends JpaRepository<BikeStatus, Long> {

	public BikeStatus findByStatus(String status);
}
