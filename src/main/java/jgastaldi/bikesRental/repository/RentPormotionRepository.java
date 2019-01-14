package jgastaldi.bikesRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jgastaldi.bikesRental.model.RentPromotion;

@Repository
public interface RentPormotionRepository extends JpaRepository<RentPromotion, Long> {

	public RentPromotion findByPromotion(String promotion);
}
