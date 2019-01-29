package com.lti.training.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.lti.training.dto.Employee;
import com.lti.training.exception.DataAccessException;

public class EmployeeDao {

	public void add(Employee emp) throws DataAccessException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//why not FileInputStream is = new FileInputStream("dev-db.properties");
			InputStream is = 
					this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
			
			Properties dbProps = new Properties();
			dbProps.load(is);
			String driverClassName = dbProps.getProperty("driverClassName");
			String url = dbProps.getProperty("url");
			String username = dbProps.getProperty("username");
			String password = dbProps.getProperty("password");
			
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, username, password);

			pstmt = conn.prepareStatement("insert into TBL_EMP values(?,?,?)");
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException | IOException e) {
			throw new DataAccessException("Problem while inserting employee data", e);
		}
		finally {
			try { pstmt.close(); } catch(Exception e) { }
			try { conn.close(); } catch(Exception e) { }
		}
	}
}
