package edu.polytech.location.business;

import java.util.List;

import javax.ejb.Local;

import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.ReservationBean;
import edu.polytech.location.model.TarificationCardBean;


@Local
public interface BusinessLocal {

    public void addLocation(LocationBean bean);

    public List<LocationBean> getLocations();

    public LocationBean getLocation(Integer id);
    
    public TarificationCardBean Tarification(LocationBean location, TarificationCardBean tarifDetail);
    
    public void addReservation(ReservationBean bean);

    public List<ReservationBean> getReservations();

    public ReservationBean getReservation(Integer id);
}
