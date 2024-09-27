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
@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println(email);
		System.out.println(phone);
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		RequestDispatcher rds = request.getRequestDispatcher("/WEB-INF/Views/Update.jsp");
		rds.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String email =request.getParameter("email");
		String phone =request.getParameter("phone");
		DAOServiceImple s = new DAOServiceImple();
		s.ConnectionDB();
		s.UpdateReg(email, phone);
		
		ResultSet res = s.listAll();
		request.setAttribute("result", res);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Records.jsp");
		rd.forward(request, response);
	}
}
