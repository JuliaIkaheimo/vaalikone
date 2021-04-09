package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Ehdokkaat;
import data.Kysymykset;

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
		catch (SQLException s) {
			System.out.println(s.getMessage());
			return false;
		}
	}
	public ArrayList<Ehdokkaat> readAllEhdokkaat() {
		ArrayList<Ehdokkaat> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select ehdokas_id, etunimi, sukunimi, puolue from ehdokkaat");
			while (RS.next()){
				Ehdokkaat e=new Ehdokkaat();
				e.setEhdokas_id(RS.getInt("ehdokas_id"));
				e.setEtunimi(RS.getString("etunimi"));
				e.setSukunimi(RS.getString("sukunimi"));
				e.setPuolue(RS.getString("puolue"));
				list.add(e);
			}
			return list;
		}
		catch(SQLException s) {
			return null;
		}
	}
	public ArrayList<Ehdokkaat> updateEhdokkaat(Ehdokkaat e) {
		try {
			String sql="update ehdokkaat set etunimi=?, sukunimi=?, puolue=? where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, e.getEtunimi());
			pstmt.setString(2, e.getSukunimi());
			pstmt.setString(3, e.getPuolue());
			pstmt.setInt(4, e.getEhdokas_id());
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException s) {
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
		catch(SQLException s) {
			return null;
		}
	}

	public Ehdokkaat readEhdokkaat(String ehdokas_id) {
		Ehdokkaat e=null;
		try {
			String sql="select ehdokas_id, etunimi, sukunimi, puolue from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, ehdokas_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				e=new Ehdokkaat();
				e.setEhdokas_id(RS.getInt("ehdokas_id"));
				e.setEtunimi(RS.getString("etunimi"));
				e.setSukunimi(RS.getString("sukunimi"));
				e.setPuolue(RS.getString("puolue"));
			}
			return e;
		}
		catch(SQLException s) {
			return null;
		}
	}
	public ArrayList<Kysymykset> readAllKysymykset() {
		ArrayList<Kysymykset> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset");
			while (RS.next()){
				Kysymykset k=new Kysymykset();
				k.setId(RS.getInt("kysymys_id"));
				k.setKysymys(RS.getString("kysymys"));
				list.add(k);
			}
			return list;
		}
		catch(SQLException s) {
			return null;
		}
	}
	
	public ArrayList<Ehdokkaat> lisaaEhdokkaat(Ehdokkaat e) {
		try {
			String sql="insert into ehdokkaat(ehdokas_id, etunimi, sukunimi, puolue) values(?, ?, ?, ?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, e.getEhdokas_id());
			pstmt.setString(2, e.getEtunimi());
			pstmt.setString(3, e.getSukunimi());
			pstmt.setString(4, e.getPuolue());
			
			pstmt.executeUpdate();
			return readAllEhdokkaat();
		}
		catch(SQLException s) {
			return null;
		}
	}
}
