package edu.polytech.location.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.polytech.location.business.BusinessImpl;
import edu.polytech.location.business.BusinessRemote;
import edu.polytech.location.model.LocationBean;

public class LocationClient {

    public static void main(String[] args) throws NamingException, IOException {
        BusinessRemote business = getBusiness();

        LocationBean bean1 = insertBeanInDB("12 chemin de la Vallée", "Les Arcs", "73700", 150D, "images/1.jpg");
        business.addLocation(bean1);

        LocationBean bean2 = insertBeanInDB("15 route de la montagne", "Les Arcs", "73700", 253D, "images/2.jpg");
        business.addLocation(bean2);

        LocationBean bean3 = insertBeanInDB("25 route de la montagne", "La Plagne", "73210", 75D, "images/3.jpg");
        business.addLocation(bean3);

        LocationBean bean4 = insertBeanInDB("35 route des monts", "La Clusaz", "74220", 58.5D, "images/4.jpg");
        business.addLocation(bean4);
    }

    /**
     * Permet d'insérer un enregistrement en BDD.
     * 
     * @param address
     * @param city
     * @param zipCode
     * @param nightPrice
     * @param picture
     * @throws IOException
     * @throws NamingException
     */
    private static LocationBean insertBeanInDB(String address, String city, String zipCode, Double nightPrice,
            String picture) throws IOException, NamingException {
        LocationBean bean = new LocationBean();

        bean.setAddress(address);
        bean.setCity(city);
        bean.setZipCode(zipCode);
        bean.setNightPrice(nightPrice);

        File file = new File(picture);
        byte[] picInBytes = new byte[(int) file.length()];
        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(picInBytes);
        fileInputStream.close();

        bean.setPicture(picInBytes);

        return bean;
    }

    private static BusinessRemote getBusiness() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "remote+http://localhost:8080");
        Context ctx = new InitialContext(jndiProperties);

        String appName = "LocationApp08/";
        String projectName = "LocationApp08EJB/";
        String className = BusinessImpl.class.getSimpleName();
        String remote = BusinessRemote.class.getName();

        String url = "ejb:" + appName + projectName + className + "!" + remote;
        System.out.println("EJB appelé avec : " + url);

        BusinessRemote business = (BusinessRemote) ctx.lookup(url);

        return business;
    }
}
