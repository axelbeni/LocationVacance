package edu.polytech.location.dao;

import java.util.List;

import edu.polytech.location.model.ReservationBean;

public interface ReservationDao {
	
	public void createReservation(ReservationBean bean);

    public List<ReservationBean> getReservations();

    public ReservationBean getReservation(Integer id);
}
