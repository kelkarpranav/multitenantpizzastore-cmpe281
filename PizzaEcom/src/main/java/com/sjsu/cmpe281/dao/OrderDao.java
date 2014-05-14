package com.sjsu.cmpe281.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sjsu.cmpe281.util.DBConnMgr;


public class OrderDao {
	
	public void getItemList(){
		PreparedStatement stat = null;
		DBConnMgr dbConn = DBConnMgr.getDBConnMgr();
		Connection conn = dbConn.getConnection();
		try {
			stat = conn.prepareStatement("select itemId, itemName from item");
			ResultSet rs = stat.executeQuery();
			rs.next();
			System.out.println("Hello --"+rs.getInt("itemId"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public int insertOrder(String storeid,String order) throws SQLException{
		DBConnMgr dbConn = DBConnMgr.getDBConnMgr();
		Connection conn = dbConn.getConnection();
		String query="insert into orders (storeid,orderdetails) values (?,?) ";
		String result=null;
		Statement stmt = null;
		ResultSet rs = null;
		int id = -1;
		PreparedStatement exeQuery;
		try {
			exeQuery = conn.prepareStatement(query);
			exeQuery.setString(1,storeid);
			exeQuery.setString(2,order);
			exeQuery.execute();
			result= "New Order Added!" ;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			if (rs.next()) {
				id = rs.getInt(1);
		    } 
		    rs.close();
		} catch (SQLException e) {
			result="Could Not Add New Entry!";
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				 rs.close();
				 stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/*DBConnection.returnConnection(DB);
			System.out.println(DBConnection);*/
		}
	
		return id;
	}

}
