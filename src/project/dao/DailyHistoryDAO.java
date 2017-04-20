package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.entity.DailyHistory;

public class DailyHistoryDAO {

	public static DailyHistory insertAccount(DailyHistory history) throws SQLException {
		String sqlQuery = "insert into DailyHistory(accountId,recipeId,chosenDate,isChosen) values(?,?,?,?)";
		System.out.println("sql: " + sqlQuery);
		
		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, history.getAccountId());
		statement.setInt(2, history.getRecipeId());
		statement.setString(3, history.getChosenDate());
		statement.setBoolean(4, history.isChoosen());
		

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("insert history failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			history.setId(generatedKeys.getInt(1));
			System.out.println("inserted history id: " + history.getId());
		} else {
			throw new SQLException("insert history failed, no ID obtained.");
		}
		return history;
	}
}
