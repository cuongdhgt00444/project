package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.entity.Rating;

public class RatingDAO {

	public static Rating insertRating(Rating rating) throws SQLException {
		String sqlQuery = "insert into Rating(recipeId, avgRating) values(?,?)";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, rating.getRecipeId());
		statement.setFloat(2, rating.getAvgRating());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("insert Rating failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			rating.setId(generatedKeys.getInt(1));
			System.out.println("inserted Rating id: " + rating.getId());
		} else {
			throw new SQLException("insert Rating failed, no ID obtained.");
		}
		return rating;
	}

	public ArrayList<Rating> getFavoriteRatingForRecipe(int recipeId) throws SQLException {
		String sqlQuery = "select * from Rating where recipeId=?";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, recipeId);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		Rating rating = null;
		ArrayList<Rating> ratings = new ArrayList<>();
		while (rs.next()) {
			rating = new Rating();
			rating.setId(rs.getInt(1));
			rating.setRecipeId(rs.getInt(3));

			ratings.add(rating);
		}
		return ratings;
	}
}
