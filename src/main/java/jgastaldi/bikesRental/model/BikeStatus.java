package jgastaldi.bikesRental.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import jgastaldi.bikesRental.model.base.EntityBase;

@Entity
@Table(name = "bike_status")
public class BikeStatus extends EntityBase {

	private String status;
	private String description;

	public BikeStatus() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
