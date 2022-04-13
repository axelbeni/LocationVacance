package edu.polytech.location.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: ReservationBean
 *
 */
@Entity

public class ReservationBean implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer idUser;
	private LocalDate dateRservation;
	private Double totalPrice;
	private static final long serialVersionUID = 1L;

	public ReservationBean() {
		idUser = 42;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public LocalDate getDateRservation() {
		return this.dateRservation;
	}

	public void setDateRservation(LocalDate dateRservation) {
		this.dateRservation = dateRservation;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
