package edu.polytech.location.model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 
 * {@summary} Classe représentant les détails de la réservation.
 *
 */
public class TarificationCardBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private LocalDate dateDebut;
	private LocalDate dateDefin;
	private boolean menForm;
	private boolean assuranceForm;
	private double assPrice;
	private double menagePrice;
	private double locationPrice;
	private double totalPrice;
	private double reduJour;
	private double reduAnticip;
	private double reduFidelite;
	private double reductionTotalPrice;
	
	public TarificationCardBean() {
		dateDebut = null;
		dateDefin = null;
		menForm = false;
		assuranceForm = false;
		totalPrice = 0D;
		assPrice = 0D;
		menagePrice = 0D;
		locationPrice = 0D;
		reduJour = 0D;
		reduAnticip = 0D;
		reduFidelite = 0D;
		reductionTotalPrice = 0D;

	}
	
	public double getReductionTotalPrice() {
		return reductionTotalPrice;
	}

	public void setReductionTotalPrice(double reductionTotalPrice) {
		this.reductionTotalPrice = reductionTotalPrice;
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateDefin() {
		return dateDefin;
	}

	public void setDateDefin(LocalDate dateDefin) {
		this.dateDefin = dateDefin;
	}

	public boolean isMenForm() {
		return menForm;
	}

	public void setMenForm(boolean menForm) {
		this.menForm = menForm;
	}

	public boolean isAssuranceForm() {
		return assuranceForm;
	}

	public void setAssuranceForm(boolean assuranceForm) {
		this.assuranceForm = assuranceForm;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getAssPrice() {
		return assPrice;
	}

	public void setAssPrice(double assPrice) {
		this.assPrice = assPrice;
	}

	public double getMenagePrice() {
		return menagePrice;
	}

	public void setMenagePrice(double menagePrice) {
		this.menagePrice = menagePrice;
	}

	public double getLocationPrice() {
		return locationPrice;
	}

	public void setLocationPrice(double locationPrice) {
		this.locationPrice = locationPrice;
	}

	public double getReduJour() {
		return reduJour;
	}

	public void setReduJour(double reduJour) {
		this.reduJour = reduJour;
	}

	public double getReduAnticip() {
		return reduAnticip;
	}

	public void setReduAnticip(double reduAnticip) {
		this.reduAnticip = reduAnticip;
	}

	public double getReduFidelite() {
		return reduFidelite;
	}

	public void setReduFidelite(double reduFidelite) {
		this.reduFidelite = reduFidelite;
	}

}
