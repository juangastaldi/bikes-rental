package jgastaldi.bikesRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgastaldi.bikesRental.model.RentType;

@Repository
public interface RentTypeRepository extends JpaRepository<RentType, Long> {

	public RentType findByType(String type);
}
