package jgastaldi.bikesRental.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import jgastaldi.bikesRental.model.base.EntityBase;

@Entity
@Table(name = "rent")
public class Rent extends EntityBase {

	private Client client;
	private RentPromotion rentPromotion;
	private Double totalAmount;

	public Rent() {
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public RentPromotion getRentPromotion() {
		return rentPromotion;
	}

	public void setRentPromotion(RentPromotion rentPromotion) {
		this.rentPromotion = rentPromotion;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
