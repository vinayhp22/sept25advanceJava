package com.vtech.hbms.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vtech.hbms.constants.Status;
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
				patient.setStatus(Status.valueOf(rs.getString("status")));
				patient.setRegisteredTime(rs.getTimestamp("registeredtime"));
				System.out.println(patient.toString());
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd", Locale.ENGLISH);

		System.out.println("dischargedate: "+req.getParameter("dischargedate"));
		System.out.println("admitdate: "+req.getParameter("admitdate"));
		 int id = Integer.parseInt(req.getParameter("id"));
		 Date admitDate = req.getParameter("admitdate")!=null && !req.getParameter("admitdate").trim().isEmpty()  ? Date.valueOf(LocalDate.parse(req.getParameter("admitdate"))) : null;
		 Date dischargeDate = req.getParameter("dischargedate")!=null && !req.getParameter("dischargedate").trim().isEmpty() ? Date.valueOf(LocalDate.parse(req.getParameter("dischargedate"))) : null;
		 String status = req.getParameter("status");
		 LocalDate localDate = LocalDate.parse("2025-10-18");
		 System.out.println("Local Date: "+localDate);
		 
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
