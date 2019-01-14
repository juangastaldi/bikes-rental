package jgastaldi.bikesRental.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rent_detail")
public class RentDetail {

	private Rent rent;
	private Bike bike;
	private LocalDateTime rentFrom;
	private LocalDateTime rentTo;
	private RentType rentType;

	public RentDetail() {
	}

	public Rent getRent() {
		return rent;
	}

	public void setRent(Rent rent) {
		this.rent = rent;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public LocalDateTime getRentFrom() {
		return rentFrom;
	}

	public void setRentFrom(LocalDateTime rentFrom) {
		this.rentFrom = rentFrom;
	}

	public LocalDateTime getRentTo() {
		return rentTo;
	}

	public void setRentTo(LocalDateTime rentTo) {
		this.rentTo = rentTo;
	}

	public RentType getRentType() {
		return rentType;
	}

	public void setRentType(RentType rentType) {
		this.rentType = rentType;
	}
}
