package jgastaldi.bikesRental.service;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jgastaldi.bikesRental.exception.PromotionLimitException;
import jgastaldi.bikesRental.model.Bike;
import jgastaldi.bikesRental.model.BikeStatus;
import jgastaldi.bikesRental.model.Client;
import jgastaldi.bikesRental.model.Rent;
import jgastaldi.bikesRental.model.RentDetail;
import jgastaldi.bikesRental.model.RentPromotion;
import jgastaldi.bikesRental.repository.BikeRepository;
import jgastaldi.bikesRental.repository.BikeStatusRepository;
import jgastaldi.bikesRental.repository.ClientRepository;
import jgastaldi.bikesRental.repository.RentDetailRepository;
import jgastaldi.bikesRental.repository.RentRepository;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private BikeRepository bikeRepository;

	@Autowired
	private BikeStatusRepository bikeStatusRepository;

	@Autowired
	private RentRepository rentRepository;

	@Autowired
	private RentDetailRepository rentDetailRepository;

	public Client findClientByIdNumber(Long idNumber) {
		return clientRepository.findByIdentificationNumber(idNumber);
	}

	public List<Bike> findAllBikeByBikeStatus(BikeStatus bikeStatus) {
		return bikeRepository.findAllByBikeStatus(bikeStatus);
	}

	public BikeStatus findBikeStatusByStatus(String status) {
		return bikeStatusRepository.findByStatus(status);
	}

	public List<Rent> findAllRentByClient(Client client) {
		return rentRepository.findAllByClient(client);
	}

	public List<RentDetail> findAllRentDetailByRent(Rent rent) {
		return rentDetailRepository.findAllByRent(rent);
	}

	@Override
	public Double getTotalAmoun(List<RentDetail> rentDetail, RentPromotion rentPromotion)
			throws PromotionLimitException {
		Double totalAmount = 0.0;
		Double discount = null;
		if (rentDetail != null) {
			if (rentPromotion != null) {
				if (rentPromotion.getNumberFrom() < rentDetail.size()) {
					throw new PromotionLimitException("Number of bikes under promotion limit");
				}
				if (rentDetail.size() > rentPromotion.getNumberTo()) {
					throw new PromotionLimitException("Numer of bikes uper promotion limit");
				}
				discount = rentPromotion.getDiscount();
			}
			for (RentDetail detail : rentDetail) {
				switch (detail.getRentType().getType()) {
				case "day":
					totalAmount += ChronoUnit.DAYS.between(detail.getRentFrom(), detail.getRentTo())
							* detail.getRentType().getPrice();
					break;
				case "week":
					totalAmount += ChronoUnit.WEEKS.between(detail.getRentFrom(), detail.getRentTo())
							* detail.getRentType().getPrice();
					break;
				case "hour":
					totalAmount += ChronoUnit.HOURS.between(detail.getRentFrom(), detail.getRentTo())
							* detail.getRentType().getPrice();
					break;
				}
			}
			if (discount != null) {
				totalAmount = (totalAmount * (100 - discount)) / 100;
			}
		}
		return totalAmount;
	}

}
