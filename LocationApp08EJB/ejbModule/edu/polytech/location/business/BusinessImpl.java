package edu.polytech.location.business;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import edu.polytech.location.dao.LocationDao;
import edu.polytech.location.dao.ReservationDao;
import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;
import edu.polytech.location.model.TarificationCardBean;

/**
 * 
 * {@summary} Classe qui implements les méthodes des différents DAO, la méthode de tarification
 *
 */
@Stateless
public class BusinessImpl implements BusinessLocal, BusinessRemote {

	@Inject
	private LocationDao locationDao;

	@Inject
	private ReservationDao reservationDao;

	private final double FORFAIT_MENAGE_PRICE = 20D;
	private final double TAUX_ASSURANCE = 0.05;
	private final double TAUX_REDUCTION_ANTICIPATION = 0.07;
	private final double TAUX_REDUCTION_PRIX_TOTAL_ELEVE = 0.1;
	private final double TAUX_REDUCTION_FIDELITE = 0.12;
	private final double MIN_PRICE_FOR_REDUC = 500;
	private final double MIN_DAY_FOR_REDUC = 30;

	/**
	 * {@summary} Insert un object LocationBean en base de données
	 * @param bean : La location à insérer
	 */
	@Override
	public void addLocation(LocationBean bean) {
		locationDao.createLocation(bean);
	}

	/**
	 * {@summary} récupère la liste des locations de la base de données
	 * @return une liste d'objects LocationBean
	 */
	@Override
	public List<LocationBean> getLocations() {
		return locationDao.getLocations();
	}

	/**
	 * {@summary} récupère la location correspondant à id
	 * @param id : identifiant de la location
	 * @return un object de type LocationBean
	 */
	@Override
	public LocationBean getLocation(Integer id) {
		return locationDao.getLocation(id);
	}
	
	/**
	 * {@summary} Insert un object ReservationBean en base de données
	 * @param bean : La reservation à insérer
	 */
	@Override
	public void addReservation(ReservationBean bean) {
		reservationDao.createReservation(bean);

	}

	/**
	 * {@summary} Récupère la liste des reservations de la base de données
	 * @return liste d'object ReservationBean
	 */
	@Override
	public List<ReservationBean> getReservations() {
		return reservationDao.getReservations();
	}

	/**
	 * {@summary} récupère la reservation correspondant à id
	 * @param id : identifiant de la reservation
	 * @return un object de type ReservationBean
	 */
	@Override
	public ReservationBean getReservation(Integer id) {
		return reservationDao.getReservation(id);
	}
	
	/**
	 * {@summary} Méthode permettant de calculer les différentes réductions liées à une location.
	 * 
	 * @param location : Object LocationBean représentant la location sur laquel s'applique les réductions
	 * @param tarifDetail : Object TarificationCardBean représentant les détails liés à une reservation.
	 * 
	 * @return tarifDetail : les détails de la reservation.
	 */
	@Override
	public TarificationCardBean Tarification(LocationBean location, TarificationCardBean tarifDetail) {
		
		/*Regle de gestion 1*/
		long numDay = tarifDetail.getDateDebut().until(tarifDetail.getDateDefin(), ChronoUnit.DAYS);
		tarifDetail.setLocationPrice(numDay * location.getNightPrice());

		/*Regle de gestion 2*/
		if (tarifDetail.isMenForm()) {
			tarifDetail.setMenagePrice(FORFAIT_MENAGE_PRICE);
		}

		/*Regle de gestion 3*/
		tarifDetail.setAssPrice(tarifDetail.getLocationPrice() * TAUX_ASSURANCE);

		/*Regle de gestion 4*/
		if (numDay >= 7) {
			tarifDetail.setReduJour(location.getNightPrice());
		}

		/*Regle de gestion 5*/
		tarifDetail.setTotalPrice(tarifDetail.getLocationPrice() + tarifDetail.getMenagePrice()
				- tarifDetail.getReduJour() - tarifDetail.getAssPrice());

		if (tarifDetail.getTotalPrice() > MIN_PRICE_FOR_REDUC) {
			tarifDetail.setReductionTotalPrice(tarifDetail.getTotalPrice() * TAUX_REDUCTION_PRIX_TOTAL_ELEVE);
		}
		tarifDetail.setTotalPrice(tarifDetail.getTotalPrice() - tarifDetail.getReductionTotalPrice());
		
		/*Regle de gestion 6*/
		long numb = LocalDate.now().until(tarifDetail.getDateDebut(), ChronoUnit.DAYS);
		if (numb > MIN_DAY_FOR_REDUC) {
			tarifDetail.setReduAnticip(tarifDetail.getTotalPrice() * TAUX_REDUCTION_ANTICIPATION);
		}
		tarifDetail.setTotalPrice(tarifDetail.getTotalPrice() - tarifDetail.getReduAnticip());
		
		/*Regle de gestion 7*/
		List<ReservationBean> listReserv = getReservations();
		int cmpt = 0;
		for (ReservationBean reservation : listReserv) {
			if (reservation.getIdUser() == 42) {
				cmpt++;
			}
		}
		if (cmpt % 3 == 0 && cmpt != 0) {
			double reduc = TAUX_REDUCTION_FIDELITE * (listReserv.get(listReserv.size() - 1).getTotalPrice()
					+ listReserv.get(listReserv.size() - 2).getTotalPrice());
			if (reduc <= tarifDetail.getTotalPrice()) {
				tarifDetail.setReduFidelite(reduc);
			} else {
				tarifDetail.setReduFidelite(tarifDetail.getReduAnticip());
			}
		}

		/*Regle de gestion 8*/
		tarifDetail.setTotalPrice(
				tarifDetail.getTotalPrice() - tarifDetail.getReduFidelite());

		return tarifDetail;
	}
}
