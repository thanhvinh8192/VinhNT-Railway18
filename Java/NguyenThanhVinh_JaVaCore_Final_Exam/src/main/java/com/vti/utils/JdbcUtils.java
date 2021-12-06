package com.vti.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils {
	private Connection connection;
	private Properties properties;
	
	public JdbcUtils() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream("src/main/resources/database.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("Không tìm thấy file cấu hình!\n Vui lòng kiểm tra lại đường dẫn");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				return connection;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		String url = properties.getProperty("url");
		String username =properties.getProperty("username");
		String password =properties.getProperty("password");
		String driver =properties.getProperty("myDriver");
		
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Kiểm tra Class.forName");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;
	}
	
	public void disConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ResultSet excuteQuery(String sql) throws SQLException  {
		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		return statement.executeQuery(sql);
	}
	
	public PreparedStatement createPreparedStatement(String sql) throws SQLException {
		Connection connection = getConnection();
		return	connection.prepareStatement(sql);
	}
}
