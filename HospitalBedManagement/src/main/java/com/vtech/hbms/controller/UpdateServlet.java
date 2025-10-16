package com.vtech.hbms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtech.hbms.model.Patient;
import com.vtech.hbms.util.DBUtil;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		String sql = "SELECT * FROM patients WHERE id = ?";
		try(Connection conn = new DBUtil().getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
		) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			Patient patient = new Patient();
			while(rs.next()) {
				patient.setId(rs.getInt("id"));
				patient.setPatientName(rs.getString("patientname"));
				patient.setPatientAge(rs.getInt("patientage"));
				patient.setAddress(rs.getString("patientaddress"));
				patient.setAdmittedDate(rs.getDate("admitdate"));
				patient.setDischargeDate(rs.getDate("dischargeDate"));
				patient.setStatus(rs.getString("status"));
				patient.setRegisteredTime(rs.getTimestamp("registeredtime"));
			}
			if(patient.getId()>0) {
				req.setAttribute("patient", patient);
				req.getRequestDispatcher("updatepatient.jsp").forward(req, resp);
			} 
						
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 int id = Integer.parseInt(req.getParameter("id"));
		 Date admitDate = Date.valueOf(req.getParameter("admitdate"));
		 Date dischargeDate = Date.valueOf(LocalDate.parse(req.getParameter("dischargedate")));
		 String status = req.getParameter("status");
		 
		 
		 String sql = "Update patients SET status = ?, admitdate = ?, dischargeDate = ? WHERE id = ?";
		 try(Connection con = new DBUtil().getConnection();
			 PreparedStatement stmt = con.prepareStatement(sql)) {
			 stmt.setString(1, status);
			 stmt.setDate(2, admitDate);
			 stmt.setDate(3, dischargeDate);
			 stmt.setInt(4, id);
			 int rows = stmt.executeUpdate();
			 System.out.println(rows);
			 if(rows>0) {
				 req.setAttribute("updateSuccessMessage", "Successfully updated");
				 req.getRequestDispatcher("index.jsp").forward(req, resp);
			 }
			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
