package edu.polytech.location.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.polytech.location.business.BusinessLocal;
import edu.polytech.location.model.LocationBean;


@WebServlet("/locationsList")
public class LocationsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private BusinessLocal business;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<LocationBean> locationsList = business.getLocations();

		request.setAttribute("LOCATIONS_LIST", locationsList);

		request.getRequestDispatcher("locationsList.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
