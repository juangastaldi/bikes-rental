package jgastaldi.bikesRental.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import jgastaldi.bikesRental.model.base.EntityBase;

@Entity
@Table(name = "bike")
public class Bike extends EntityBase {

	private Long code;
	private BikeStatus bikeStatus;

	public Bike() {
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public BikeStatus getBikeStatus() {
		return bikeStatus;
	}

	public void setBikeStatus(BikeStatus bikeStatus) {
		this.bikeStatus = bikeStatus;
	}
}
