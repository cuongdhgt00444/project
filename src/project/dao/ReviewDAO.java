package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.entity.Review;

public class ReviewDAO {

	/**
	 * insert review
	 * 
	 * @param review
	 * @return
	 * @throws SQLException
	 */
	public static Review insertRecipeIngredient(Review review) throws SQLException {
		String sqlQuery = "insert into Review(accountId, recipeId, rating,comment,reviewedDate) values(?,?,?,?,?)";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, review.getAccountId());
		statement.setInt(2, review.getRecipeId());
		statement.setFloat(2, review.getRating());
		statement.setString(3, review.getComment());
		statement.setString(4, review.getReviewedDate());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("insert Review failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			review.setId(generatedKeys.getInt(1));
			System.out.println("inserted Review id: " + review.getId());
		} else {
			throw new SQLException("insert Review failed, no ID obtained.");
		}
		return review;
	}
}
