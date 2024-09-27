package com.app_DAOService.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImple implements DAOServies {
	private Connection con;
	private Statement stm;

	@Override
	public void ConnectionDB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jundb", "root", "12345");
			stm = con.createStatement();
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
	}

	@Override
	public boolean LoginV(String email, String password) {
		try {
			ResultSet res = stm
					.executeQuery("select * from login where email='" + email + "' and password='" + password + "'");
			return res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void createReg(String name, String email, String phone) {
		try {
			stm.executeUpdate("insert into registration values('" + name + "','" + email + "','" + phone + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteReg(String email) {
		try {
			stm.executeUpdate("delete from registration where email='" + email + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listAll() {
		try {
			ResultSet res = stm.executeQuery("select * from registration");
			return res;

		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public void UpdateReg(String email, String phone) {
		try {
			stm.executeUpdate("update registration set phone='"+phone+"' where email ='"+email+"' ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
