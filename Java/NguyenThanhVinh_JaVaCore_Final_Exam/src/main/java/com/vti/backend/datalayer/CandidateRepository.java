package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Fresher;
import com.vti.entity.Role;
import com.vti.entity.Candidate;
import com.vti.entity.Experience;
import com.vti.utils.JdbcUtils;

public class CandidateRepository {
	private JdbcUtils jdbc;
	
	public CandidateRepository() {
		jdbc = new JdbcUtils();
	}
	
	public Candidate login(String email, String password) {
		try {
			String sqlQuery = "SELECT * FROM candidate " + "WHERE email = ? AND password = ? ";
			PreparedStatement preparedStatement = jdbc.createPreparedStatement(sqlQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password.toLowerCase());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String phone = resultSet.getString("phone");
				Role role = Role.valueOf(resultSet.getString("role"));
				return new Candidate (firstName, lastName, phone, email, password, role);
			}else {
				System.err.print("Tài khoản hoặc mật khẩu không đúng!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.disConnection();
		}
		return null;
	}
	

	public String createExperience(Experience experience) {
		String queryCheck = "SELECT * FROM candidate WHERE email = '" + experience.getEmail() + "';";
		try {
			if (!jdbc.excuteQuery(queryCheck).next()) {
				String sqlQuery = "INSERT INTO candidate (first_name, last_name, email, `password`, `role`, phone)" +  "VALUES (?, ?, ?, ?, ?, ?);";
				
				PreparedStatement preparedStatement = jdbc.createPreparedStatement(sqlQuery);
				preparedStatement.setString(1, experience.getFirstName());
				preparedStatement.setString(2, experience.getLastName());
				preparedStatement.setString(3, experience.getEmail());
				preparedStatement.setString(4, experience.getPassword());
				preparedStatement.setString(5, "Experience");
				preparedStatement.setString(6, experience.getPhone());
				preparedStatement.executeUpdate();
				
				String sql = "INSERT INTO experience ( experience_email, exp_in_year) values (?, ?);";
				PreparedStatement preparedStatement1 = jdbc.createPreparedStatement(sql);
				preparedStatement1.setString(1, experience.getEmail());
				preparedStatement1.setInt(2, experience.getExpInYear());
				preparedStatement.setString(3, null);
				preparedStatement1.executeUpdate();
			}else {
				System.err.println("Email "+ experience.getEmail() + " đã tồn tại.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.disConnection();
		}
		return "Thêm ứng viên Experience thành công";
	}
	
	public String createFresher(Fresher fresher) {
		String queryCheck = "SELECT * FROM candidate WHERE email = '" + fresher.getEmail() + "';";
		try {
			if (!jdbc.excuteQuery(queryCheck).next()) {
				String sqlQuery = "INSERT INTO candidate (first_name, last_name, email, `password`, `role`, phone)" +  "VALUES (?, ?, ?, ?, ?, ?);";
				
				PreparedStatement preparedStatement = jdbc.createPreparedStatement(sqlQuery);
				preparedStatement.setString(1, fresher.getFirstName());
				preparedStatement.setString(2, fresher.getLastName());
				preparedStatement.setString(3, fresher.getEmail());
				preparedStatement.setString(4, fresher.getPassword());
				preparedStatement.setString(5, "Fresher");
				preparedStatement.setString(6, fresher.getPhone());
				preparedStatement.executeUpdate();
				
				String sqlFresher = "INSERT INTO fresher ( fresher_email, graduation_rank) values (?, ?);";
				PreparedStatement preparedStatement1 = jdbc.createPreparedStatement(sqlFresher);
				preparedStatement1.setString(1, fresher.getEmail());
				preparedStatement1.setString(2, fresher.getGraduationRank().toString());
				preparedStatement1.executeUpdate();
				
				
			}else {
				System.err.println("Email "+ fresher.getEmail() + " đã tồn tại.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.disConnection();
		}
		return "Thêm ứng viên Fresher thành công";
	}
}
