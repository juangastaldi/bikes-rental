package jgastaldi.bikesRental.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import jgastaldi.bikesRental.model.base.EntityBase;

@Entity
@Table(name = "client")
public class Client extends EntityBase {

	private Long identificationNumber;
	private String name;
	private Long phone;

	public Client() {
	}

	public Long getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(Long identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
}
