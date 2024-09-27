package com.app_DAOService.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app_DAOService.Model.DAOServiceImple;

@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public loginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");

			DAOServiceImple s = new DAOServiceImple();
			s.ConnectionDB();
			boolean status = s.LoginV(email, password);
			if(status) {
				HttpSession hp = request.getSession(true);
				hp.setAttribute("email", email);
				hp.setMaxInactiveInterval(10);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/Views/CreateReg.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("error", "Invalied username/password");
				RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
				rd.forward(request, response);
			}
		}catch(Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
			rd.forward(request, response);
		}
	}

}
