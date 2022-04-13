package edu.polytech.location.dao;

import java.util.List;

import edu.polytech.location.model.LocationBean;

public interface LocationDao {

    public void createLocation(LocationBean bean);

    public List<LocationBean> getLocations();

    public LocationBean getLocation(Integer id);
}
