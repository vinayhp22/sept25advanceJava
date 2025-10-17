package com.vtech.hbms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtech.hbms.constants.Status;
import com.vtech.hbms.model.Patient;
import com.vtech.hbms.util.DBUtil;

@WebServlet("/read")
public class PatientsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Patient> patients = new ArrayList<Patient>();
		String sql = "SELECT * FROM patients";
		try(Connection conn = new DBUtil().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);) {

			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()) {
				
				Patient patient = new Patient();
				patient.setId(resultSet.getInt("id"));
				patient.setPatientName(resultSet.getString("patientname"));
				patient.setPatientAge(resultSet.getInt("patientage"));
				patient.setAddress(resultSet.getString("patientaddress"));
				if(resultSet.getDate("admitdate") != Date.valueOf("2000-01-01")) {
					patient.setAdmittedDate(resultSet.getDate("admitdate"));
				}
				if(resultSet.getDate("dischargeDate") != Date.valueOf("2000-01-01")) {
					patient.setDischargeDate(resultSet.getDate("dischargeDate"));
				}
					
				patient.setStatus(Status.valueOf(resultSet.getString("status")));
				patient.setRegisteredTime(resultSet.getTimestamp("registeredtime"));
				
				patients.add(patient);
			}
			if(patients.size() > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("patients.jsp");
				req.setAttribute("patients", patients);
				rd.forward(req, res);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
	

}
