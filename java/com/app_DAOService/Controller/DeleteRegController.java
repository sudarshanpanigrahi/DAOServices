package com.app_DAOService.Controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app_DAOService.Model.DAOServiceImple;

@WebServlet("/DeleteReg")
public class DeleteRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRegController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		DAOServiceImple s = new DAOServiceImple();
		s.ConnectionDB();
		s.deleteReg(email);
		
		ResultSet res = s.listAll();
		request.setAttribute("result", res);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Records.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
