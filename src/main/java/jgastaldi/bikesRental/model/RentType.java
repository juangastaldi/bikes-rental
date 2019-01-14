package jgastaldi.bikesRental.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import jgastaldi.bikesRental.model.base.EntityBase;

@Entity
@Table(name = "rent_type")
public class RentType extends EntityBase {

	private String type;
	private Double price;

	public RentType() {
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
