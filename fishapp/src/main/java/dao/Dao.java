package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Ehdokkaat;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<Ehdokkaat> readAllEhdokkaat() {
		ArrayList<Ehdokkaat> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select ehdokas_id, etunimi, sukunimi, puolue from ehdokkaat");
			while (RS.next()){
				Ehdokkaat f=new Ehdokkaat();
				f.setId(RS.getInt("ehdokas_id"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setPuolue(RS.getString("puolue"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Ehdokkaat> updateEhdokkaat(Ehdokkaat f) {
		try {
			String sql="update ehdokkaat set etunimi=?, sukunimi=?, puolue=? where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getEtunimi());
			pstmt.setString(2, f.getSukunimi());
			pstmt.setString(3, f.getPuolue());
			pstmt.setInt(4, f.getId());
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Ehdokkaat> deleteEhdokkaat(String ehdokas_id) {
		try {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public Ehdokkaat readEhdokkaat(String ehdokas_id) {
		Ehdokkaat f=null;
		try {
			String sql="select ehdokas_id, etunimi, sukunimi, puolue from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Ehdokkaat();
				f.setId(RS.getInt("ehdokas_id"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setPuolue(RS.getString("puolue"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
}
