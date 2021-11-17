package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.Utils.JdbcUltils;
import com.vti.entity.Role;
import com.vti.entity.User;

public class UserRepository implements IUserRepository {

	private JdbcUltils jdbcUltils;
	private Connection connection;

	public UserRepository() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		jdbcUltils = new JdbcUltils();
	}

	@Override
	public List<User> getListUsers() throws SQLException, ClassNotFoundException {
		List<User> users = new ArrayList<>();

		try {
			// get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statment object
			Statement statement = connection.createStatement();

			// Step 4: Execute query
			String listUser = "SELECT * FROM usermanager.user";
			ResultSet resultSet = statement.executeQuery(listUser);

			// Step 5: Handling result set
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));

				User user = new User(userId, fullName, email, password, role);
				users.add(user);

			}
			return users;
		} finally {
			// Step 6: Close connection
			connection.close();
		}

	}

	@Override
	public User getUserById(int id) throws SQLException, ClassNotFoundException {
		try {
			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = " SELECT * " + " FROM `User` " + " WHERE UserID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute SQL query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set
			while (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				String email = resultSet.getString("Email");
				String password = resultSet.getString("Password");
				Role role = Role.valueOf(resultSet.getString("Role"));

				User user = new User(userId, fullName, email, password, role);

				return user;
			}
			return null;

		} finally {
			connection.close();
		}
	}

	@Override
	public int deleteUser(int id) throws ClassNotFoundException, SQLException {
		try {

			// Step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object
			String sql = " DELETE " + " FROM `User` " + " WHERE UserID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query

			int effectedRecodAmount = preparedStatement.executeUpdate();

			// Step 5: Handling result
			return effectedRecodAmount;

		} finally {
			connection.close();
		}
	}

	@Override
	public boolean isUserIdExits(int id) throws SQLException, ClassNotFoundException {
		try {

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT * FROM usermanager.user " + " WHERE UserID = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setInt(1, id);

			// Step 4: Execute Query
			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result set

			if (resultSet.next()) {

				return true;
			}

			return false;
		} finally {
			connection.close();
		}

	}

	@Override
	public User login(String email, String password) throws Exception {

		try {

			// step 2: get connect
			connection = jdbcUltils.connect();

			// Step 3: Create a statement object

			String sql = "SELECT * FROM usermanager.user " + "WHERE Email = ? AND Password = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			// set parameter
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			// Step 4: Execute Query

			ResultSet resultSet = preparedStatement.executeQuery();

			// Step 5: Handling result
			if (resultSet.next()) {
				int userId = resultSet.getInt("UserID");
				String fullName = resultSet.getString("FullName");
				Role role = Role.valueOf(resultSet.getString("Role").toUpperCase());

				User user = new User(userId, fullName, email, password, role);
				return user;
			} else {
				throw new Exception("Tai khoan hoac mat khau sai!");
			}

		} finally {
			connection.close();
		}

	}

}
