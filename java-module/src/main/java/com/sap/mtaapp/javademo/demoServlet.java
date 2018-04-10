package com.sap.mtaapp.javademo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class demoServlet
 */
@WebServlet("/username")
@ServletSecurity(@HttpConstraint(rolesAllowed = { "Read" }))
public class demoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public demoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Served at URI: {}", request.getRequestURI());
		
		if (request.getUserPrincipal() != null) {
			response.getWriter().append("User Name: " + request.getUserPrincipal().getName()).println();
			response.getWriter().append("User Message: Hello!").println();
		} else {
			response.getWriter().append("User Name: null").println();
			response.getWriter().append("User Message: unknown").println();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private Logger logger = LoggerFactory.getLogger(demoServlet.class);
}