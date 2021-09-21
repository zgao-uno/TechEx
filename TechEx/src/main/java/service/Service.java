package service;

import java.util.List;
import java.util.ArrayList;
import java.sql.*;

import datamodel.Things;
import util.DButil;

public class Service {
	
	public List<Things> showAll() {
		List<Things> list = new ArrayList<Things> ();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DButil.getConn();
			String sql = "select * from things";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String thing = rs.getString("thing");
				Things th = new Things(id,thing);
				list.add(th);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(con, ps, rs);
		}
		return list;
	}
	
	public void add(String thing) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DButil.getConn();
			String sql = "insert into things (thing) values (?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, thing);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(con, ps);
		}
	}
	
	public void delete(String thing) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = DButil.getConn();
			String sql = "delete from things where thing = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, thing);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DButil.close(con, ps);
		}
	}
}
