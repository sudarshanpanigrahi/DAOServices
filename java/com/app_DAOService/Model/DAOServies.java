package com.app_DAOService.Model;

import java.sql.ResultSet;

public interface DAOServies {

	public void ConnectionDB();
	public boolean LoginV(String email, String password);
	public void deleteReg(String email);
	public void createReg(String name,String email,String phone);
	public void UpdateReg(String email,String phone);
	public ResultSet listAll();

}