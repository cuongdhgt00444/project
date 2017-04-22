/**
 * 
 */
package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.entity.Account;
import project.entity.RecipeBean;

/**
 * @author CuongDH
 *
 */
public class AccountDAO {

	/**
	 * insert new account
	 * 
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public static Account insertAccount(Account account) throws SQLException {
		String sqlQuery = "insert into Account(username, password,firstname,middlename,lastname,dob,email,receieDailyEmail,role) values(?,?,?,?,?,?,?,?,?)";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, account.getUsername());
		statement.setString(2, account.getPassword());
		statement.setString(3, account.getFirstName());
		statement.setString(4, account.getMiddleName());
		statement.setString(5, account.getLastName());
		statement.setString(6, account.getDob());
		statement.setString(7, account.getEmail());
		statement.setBoolean(8, account.isReceiveDailyEmail());
		statement.setInt(9, account.getRole());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("Creating user failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			account.setId(generatedKeys.getInt(1));
			System.out.println("id: " + account.getId());
		} else {
			throw new SQLException("Creating user failed, no ID obtained.");
		}
		return account;
	}

	public String getUsernameByEmail(String email) throws SQLException {
		String sqlQuery = "select top(1)* from Account where email =?";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, email);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		String username = "";
		if (rs.next()) {
			username = rs.getString(2);
		}
		return username;
	}

	public Account getAccountByUsernamePassword(String username, String password) {

		String sql = "Select * from Account where username=? and [password]=?";
		Account account = new Account();
		try {
			PreparedStatement ps = ConnectionUtils.getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				account.setId(rs.getInt(1));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setEmail(rs.getString("email"));
				account.setRole(rs.getInt("role"));
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
		}
		return account;
	}

	public boolean checkNameAccount(String username) {

		String sql = "Select * from Account where username=?";
		Account account = new Account();
		try {
			PreparedStatement ps = ConnectionUtils.getConnection().prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return true;
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
		}
		System.out.println("ko the add");
		return false;
	}

	public boolean updatePassword(String password, String email) {
		String sql = "Update Account set [password]=? where email=?";
		try {
			PreparedStatement ps = ConnectionUtils.getConnection().prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			ps.executeUpdate();
		} catch (Exception ex) {

		}
		return false;
	}

	public ArrayList<Account> getAllUsers() throws SQLException {
		String sqlQuery = "Select * from Account where role=2";
		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		Account account = null;
		ArrayList<Account> accounts = new ArrayList<>();
		while (rs.next()) {
			account = new Account();
			account.setId(rs.getInt("id"));
			account.setEmail(rs.getString("email"));
			account.setReceiveDailyEmail(rs.getBoolean("receieDailyEmail"));

			accounts.add(account);
		}
		return accounts;
	}

	public static void main(String[] args) {
		Account acc = new Account();
		acc.setUsername("cuongdh");
		acc.setPassword("sdfsdf");
		acc.setEmail("mail");
		acc.setRole(4);
	}
}
