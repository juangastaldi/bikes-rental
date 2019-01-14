package jgastaldi.bikesRental.service;

import java.util.List;

import jgastaldi.bikesRental.exception.PromotionLimitException;
import jgastaldi.bikesRental.model.Bike;
import jgastaldi.bikesRental.model.BikeStatus;
import jgastaldi.bikesRental.model.Client;
import jgastaldi.bikesRental.model.Rent;
import jgastaldi.bikesRental.model.RentDetail;
import jgastaldi.bikesRental.model.RentPromotion;

public interface RentalService {

	public Client findClientByIdNumber(Long idNumber);

	public List<Bike> findAllBikeByBikeStatus(BikeStatus bikeStatus);

	public BikeStatus findBikeStatusByStatus(String status);

	public List<Rent> findAllRentByClient(Client client);

	public List<RentDetail> findAllRentDetailByRent(Rent rent);

	public Double getTotalAmoun(List<RentDetail> rentDetail, RentPromotion rentPromotion)
			throws PromotionLimitException;
}
