package com.vti.backend.datalayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Manager;
import com.vti.entity.Project;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

public class UserRepository {
	private JdbcUtils jdbc;
	
	public UserRepository() {
		jdbc = new JdbcUtils();
	}
	
	public User login(String email, String password) {
		try {
			String sqlQuery = "SELECT * FROM users " + "WHERE Email = ? AND Password = ? ";
			PreparedStatement preparedStatement = jdbc.createPreparedStatement(sqlQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password.toLowerCase());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String fullName = resultSet.getString("fullName");
				Role role = Role.valueOf(resultSet.getString("role"));
				return new User(userId, fullName, email, password, role);
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

	public List<User> getListUserByProjectId(int projectId) {
		List<User> users = new ArrayList<User>();
		String findProjectId = "SELECT * FROM project WHERE project_id = " + projectId +";";
		try {
			ResultSet resultSet = jdbc.excuteQuery(findProjectId); //Tìm kiếm idProject trong database.
			if (resultSet.next()) {									//Nếu có kết quả thì thực hiện câu query bên dưới
				String query = """
						SELECT u.user_id, u.fullname, u.email, u.`password`, u.`role` 
						FROM users u
						LEFT JOIN manager m ON u.user_id = m.manager_id
						LEFT JOIN project p ON p.manager_id = m.manager_id
						LEFT JOIN employee e ON e.employee_id = u.user_id
						LEFT JOIN project_employees pe ON pe.employee_id = e.employee_id
						LEFT JOIN project p1 ON p1.project_id = pe.project_id
						WHERE p.project_id = ? OR p1.project_id = ?;
						""";
				PreparedStatement preparedStatement = jdbc.createPreparedStatement(query);
				preparedStatement.setInt(1, projectId);
				preparedStatement.setInt(2, projectId);
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("user_id");
					String fullname = rs.getString("fullname");
					String password = rs.getString("password");
					String email = rs.getString("email");
					Role role = Role.valueOf(rs.getString("role"));
					User user = new User(id, fullname, email, password, role);
					users.add(user);
				}
			}else {
				System.out.println("Không tìm thấy project");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.disConnection();
		}
		return users;
	}

	public List<Manager> getListManager() {
		List<Manager> managers = new ArrayList<Manager>();
		String sql = """
				SELECT p.project_id, m.manager_id, fullname, email, `password`, exp_in_year FROM users u
				INNER JOIN manager m ON m.manager_id = u.user_id
				INNER JOIN project p ON p.manager_id = m.manager_id
				ORDER BY p.project_id ASC;
				""";
		try {
			ResultSet resultSet = jdbc.excuteQuery(sql);
			while (resultSet.next()) {
				int projectId = resultSet.getInt("p.project_id");
				int managerId = resultSet.getInt("m.manager_id");
				String fullname = resultSet.getString("fullName");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String expInYear = resultSet.getString("exp_in_year");
				Manager manager = new Manager(managerId, fullname, email, password, managerId, projectId);
				managers.add(manager);
			}
			return managers;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdbc.disConnection();
		}
		return managers;
	}

}
