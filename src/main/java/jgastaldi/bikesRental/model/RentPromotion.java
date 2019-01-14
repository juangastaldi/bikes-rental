package jgastaldi.bikesRental.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import jgastaldi.bikesRental.model.base.EntityBase;

@Entity
@Table(name = "rent_promotion")
public class RentPromotion extends EntityBase {

	private String promotion;
	private Double discount;
	private Integer numberFrom;
	private Integer numberTo;
	private LocalDate promotionFrom;
	private LocalDate promotionTo;

	public RentPromotion() {
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getNumberFrom() {
		return numberFrom;
	}

	public void setNumberFrom(Integer numberFrom) {
		this.numberFrom = numberFrom;
	}

	public Integer getNumberTo() {
		return numberTo;
	}

	public void setNumberTo(Integer numberTo) {
		this.numberTo = numberTo;
	}

	public LocalDate getPromotionFrom() {
		return promotionFrom;
	}

	public void setPromotionFrom(LocalDate promotionFrom) {
		this.promotionFrom = promotionFrom;
	}

	public LocalDate getPromotionTo() {
		return promotionTo;
	}

	public void setPromotionTo(LocalDate promotionTo) {
		this.promotionTo = promotionTo;
	}
}
