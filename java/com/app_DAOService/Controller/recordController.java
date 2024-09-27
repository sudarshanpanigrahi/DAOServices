package com.app_DAOService.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app_DAOService.Model.DAOServiceImple;

@WebServlet("/Record")
public class recordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public recordController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if(session.getAttribute("email")!=null) {
				DAOServiceImple s = new DAOServiceImple();
				s.ConnectionDB();
				ResultSet res = s.listAll();
				request.setAttribute("result", res);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Records.jsp");
				rd.forward(request, response);
			}
		
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		}
} catch (Exception e) {
	e.printStackTrace();
	RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
	rd.forward(request, response);
}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}
}
