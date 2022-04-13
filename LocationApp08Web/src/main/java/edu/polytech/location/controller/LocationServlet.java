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
import edu.polytech.location.model.LocationBean;
import edu.polytech.location.model.TarificationCardBean;

/**
 * 
 * {@summary} Servlet permettant de calculer la tarification lié à la réservation et d'afficher les détails d'une location associé
 *
 */
@WebServlet(name = "afficheLocation", urlPatterns = { "/afficheLocation.fr" })
public class LocationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private BusinessLocal business;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TarificationCardBean reserv = new TarificationCardBean();
		reserv.setDateDebut(LocalDate.parse(request.getParameter("begin")));
		reserv.setDateDefin(LocalDate.parse(request.getParameter("end")));
		reserv.setMenForm(request.getParameter("menage") == null);
		reserv.setAssuranceForm(request.getParameter("assurance") == null);
		LocationBean location = business.getLocation(Integer.parseInt(request.getParameter("id")));
		business.Tarification(location, reserv);
		request.setAttribute("TARIFICATEUR", reserv);
		request.getRequestDispatcher("locationPrix.jsp").forward(request, response);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		LocationBean location = business.getLocation(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("LOCATION", location);

		request.getRequestDispatcher("location.jsp").forward(request, response);
	}

}
