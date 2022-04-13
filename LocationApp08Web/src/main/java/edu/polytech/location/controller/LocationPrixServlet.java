package edu.polytech.location.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.polytech.location.business.BusinessLocal;
import edu.polytech.location.model.ReservationBean;

/**
 * 
 * {@summary} Servlet permettant d'envoyer la reservation choisi par l'utilisateur en base de données.
 *
 */
@WebServlet(name = "LocationPrix", urlPatterns = { "/LocationPrix.fr" })
public class LocationPrixServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private BusinessLocal business;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReservationBean reservation = new ReservationBean();
		reservation.setDateRservation(LocalDate.now());
		reservation.setTotalPrice(Double.parseDouble(request.getParameter("totalPrice")));
		business.addReservation(reservation);
		request.getRequestDispatcher("locationsList").forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
