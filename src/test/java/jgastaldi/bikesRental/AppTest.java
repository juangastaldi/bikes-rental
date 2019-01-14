package jgastaldi.bikesRental;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import jgastaldi.bikesRental.exception.PromotionLimitException;
import jgastaldi.bikesRental.model.Bike;
import jgastaldi.bikesRental.model.BikeStatus;
import jgastaldi.bikesRental.model.Client;
import jgastaldi.bikesRental.model.Rent;
import jgastaldi.bikesRental.model.RentDetail;
import jgastaldi.bikesRental.model.RentPromotion;
import jgastaldi.bikesRental.model.RentType;
import jgastaldi.bikesRental.repository.BikeRepository;
import jgastaldi.bikesRental.repository.BikeStatusRepository;
import jgastaldi.bikesRental.repository.ClientRepository;
import jgastaldi.bikesRental.repository.RentDetailRepository;
import jgastaldi.bikesRental.repository.RentPormotionRepository;
import jgastaldi.bikesRental.repository.RentRepository;
import jgastaldi.bikesRental.repository.RentTypeRepository;
import jgastaldi.bikesRental.service.RentalService;
import jgastaldi.bikesRental.service.RentalServiceImpl;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
public class AppTest extends TestCase {

	@TestConfiguration
	static class RentalTestContextConfiguration {

		@Bean
		public RentalService rentalService() {
			return new RentalServiceImpl();
		}
	}

	@Autowired
	private RentalService rentalService;

	@MockBean
	private ClientRepository clientRepository;

	@MockBean
	private RentTypeRepository rentTypeRepository;

	@MockBean
	private RentPormotionRepository rentPromotionRepository;

	@MockBean
	private BikeStatusRepository bikeStatusRepository;

	@MockBean
	private BikeRepository bikeRepository;

	@MockBean
	private RentRepository rentRepository;

	@MockBean
	private RentDetailRepository rentDetailRepository;

	private Client alex;
	private RentType hour;
	private RentType day;
	private RentType week;
	private List<RentType> rentTypes;
	private RentPromotion family;
	private BikeStatus available;
	private BikeStatus rented;
	private BikeStatus maintenance;
	private Bike bikeAvailable1;
	private Bike bikeAvailable2;
	private Bike bikeAvailable3;
	private List<Bike> bikesAvailable;
	private Rent rent;
	private List<Rent> listRent;
	private RentDetail detail1;
	private RentDetail detail2;
	private RentDetail detail3;
	private List<RentDetail> listDetail;

	@Before
	public void setUp() {
		alex = new Client();
		alex.setId(1L);
		alex.setName("alex");
		alex.setIdentificationNumber(1234L);
		alex.setPhone(51462458774L);
		Mockito.when(clientRepository.findByIdentificationNumber(alex.getIdentificationNumber())).thenReturn(alex);

		hour = new RentType();
		hour.setId(1L);
		hour.setType("hour");
		hour.setPrice(5.0);
		Mockito.when(rentTypeRepository.findByType(hour.getType())).thenReturn(hour);

		day = new RentType();
		day.setId(2L);
		day.setType("day");
		day.setPrice(20.0);
		Mockito.when(rentTypeRepository.findByType(day.getType())).thenReturn(day);

		week = new RentType();
		week.setId(3L);
		week.setType("week");
		week.setPrice(60.0);
		Mockito.when(rentTypeRepository.findByType(week.getType())).thenReturn(week);

		rentTypes = new ArrayList<RentType>();
		rentTypes.add(hour);
		rentTypes.add(hour);
		rentTypes.add(week);

		Mockito.when(rentTypeRepository.findAll()).thenReturn(rentTypes);

		family = new RentPromotion();
		family.setId(1L);
		family.setPromotion("family");
		family.setDiscount(30.0);
		family.setNumberFrom(3);
		family.setNumberTo(5);
		family.setPromotionFrom(LocalDate.parse("2018-01-01"));
		family.setPromotionTo(LocalDate.parse("2020-12-31"));
		Mockito.when(rentPromotionRepository.findByPromotion(family.getPromotion())).thenReturn(family);

		available = new BikeStatus();
		available.setId(1L);
		available.setStatus("available");
		available.setDescription("Available for rent");
		Mockito.when(bikeStatusRepository.findByStatus("available")).thenReturn(available);

		rented = new BikeStatus();
		rented.setId(2L);
		rented.setStatus("rented");
		rented.setStatus("Bike rented");
		maintenance = new BikeStatus();
		maintenance.setId(3L);
		maintenance.setStatus("maintenance");
		maintenance.setDescription("Bike in maintenance");

		bikeAvailable1 = new Bike();
		bikeAvailable1.setId(1L);
		bikeAvailable1.setCode(2018001L);
		bikeAvailable1.setBikeStatus(available);

		bikeAvailable2 = new Bike();
		bikeAvailable2.setId(2L);
		bikeAvailable2.setCode(2018002L);
		bikeAvailable2.setBikeStatus(available);

		bikeAvailable3 = new Bike();
		bikeAvailable3.setId(3L);
		bikeAvailable3.setCode(2018003L);
		bikeAvailable3.setBikeStatus(available);

		bikesAvailable = new ArrayList<Bike>();
		bikesAvailable.add(bikeAvailable1);
		bikesAvailable.add(bikeAvailable2);
		bikesAvailable.add(bikeAvailable3);
		Mockito.when(bikeRepository.findAllByBikeStatus(available)).thenReturn(bikesAvailable);

		rent = new Rent();
		rent.setClient(alex);
		rent.setRentPromotion(family);
		rent.setTotalAmount(70.0);

		listRent = new ArrayList<Rent>();
		listRent.add(rent);
		Mockito.when(rentRepository.findAllByClient(alex)).thenReturn(listRent);

		detail1 = new RentDetail();
		detail1.setRent(rent);
		detail1.setBike(bikeAvailable1);
		detail1.setRentFrom(LocalDateTime.parse("2019-01-01T12:00:00"));
		detail1.setRentTo(LocalDateTime.parse("2019-01-01T16:00:00"));
		detail1.setRentType(hour);

		detail2 = new RentDetail();
		detail2.setRent(rent);
		detail2.setRentType(day);
		detail2.setBike(bikeAvailable2);
		detail2.setRentFrom(LocalDateTime.parse("2019-01-01T12:00:00"));
		detail2.setRentTo(LocalDateTime.parse("2019-01-03T12:00:00"));

		detail3 = new RentDetail();
		detail3.setRent(rent);
		detail3.setRentType(day);
		detail3.setBike(bikeAvailable3);
		detail3.setRentFrom(LocalDateTime.parse("2019-01-01T12:00:00"));
		detail3.setRentTo(LocalDateTime.parse("2019-01-03T12:00:00"));

		listDetail = new ArrayList<RentDetail>();
		listDetail.add(detail1);
		listDetail.add(detail2);
		listDetail.add(detail3);
		Mockito.when(rentDetailRepository.findAllByRent(rent)).thenReturn(listDetail);
	}

	@Test
	public void validModel() {
		Client found = rentalService.findClientByIdNumber(alex.getIdentificationNumber());
		assert (found.getIdentificationNumber().equals(alex.getIdentificationNumber()));
		assert (found.getName().equals(alex.getName()));
		assert (found.getPhone().equals(alex.getPhone()));

		BikeStatus foundStatus = rentalService.findBikeStatusByStatus(available.getStatus());
		assert (foundStatus.getId().equals(available.getId()));
		assert (foundStatus.getDescription().equals(available.getDescription()));

		List<Bike> foundBikes = rentalService.findAllBikeByBikeStatus(available);
		for (int i = 0; i < foundBikes.size(); i++) {
			assert foundBikes.get(i).getCode().equals(bikesAvailable.get(i).getCode());
			assert foundBikes.get(i).getBikeStatus().equals(available);
		}

		List<Rent> rentFound = rentalService.findAllRentByClient(alex);
		assert (rentFound.size() == listRent.size());
		assert rentFound.get(0).equals(rent);

		List<RentDetail> detailFound = rentalService.findAllRentDetailByRent(rent);
		assert detailFound.size() == listDetail.size();

		Double totalAmout;
		try {
			totalAmout = rentalService.getTotalAmoun(listDetail, family);
			assert totalAmout.equals(rent.getTotalAmount());
		} catch (PromotionLimitException e) {
			e.printStackTrace();
		}

	}
}
