package vn.edu.iuh.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.edu.iuh.Model.User;

public class ConnectionUtils {
	
	public  static Connection getConnection() {
		
		Connection conn=null;
		
		String url="jdbc:sqlserver://localhost;databaseName=QLSV";
		String user ="sa";
		String password="sapassword";
		try {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
public void insertUser(User user) {
        //1 CODE     2NAME     3 PRICE
	String sql = "INSERT into userregiser VALUES(?,?,?)";
	Connection conn=ConnectionUtils.getConnection();

	PreparedStatement preStmt=null;
		try {
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, user.getEmail());
			preStmt.setString(2, user.getTen());
			preStmt.setString(3, user.getMatkhau());
		
			int row = preStmt.executeUpdate();
			

			} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
public ArrayList<User> doctubang(ArrayList list){
	try {
		
		Connection con = ConnectionUtils.getConnection();
		String sql = "SELECT * FROM userregiser";
		Statement statement = con.createStatement();
		ResultSet rs =  statement.executeQuery(sql);
		
		while (rs.next()) {
			String email = rs.getString(1);
			String ten = rs.getString(2);
			String matkhau = rs.getString(3);
			
			User user=new User(email, ten, matkhau);
			list.add(user);
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return list;
}
}

