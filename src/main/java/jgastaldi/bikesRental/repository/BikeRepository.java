package jgastaldi.bikesRental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgastaldi.bikesRental.model.Bike;
import jgastaldi.bikesRental.model.BikeStatus;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {

	public List<Bike> findAllByBikeStatus(BikeStatus bikeStatus);
}
