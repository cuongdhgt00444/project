package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.entity.FavoriteRecipe;

public class FavoriteRecipeDAO {

	public static FavoriteRecipe insertFavoriteRecipe(FavoriteRecipe fav) throws SQLException {
		String sqlQuery = "insert into FavoriteRecipe(accountId,recipeId) values(?,?)";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, fav.getAccountId());
		statement.setInt(2, fav.getRecipeId());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("insert FavoriteRecipe failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			fav.setId(generatedKeys.getInt(1));
			System.out.println("inserted FavoriteRecipe id: " + fav.getId());
		} else {
			throw new SQLException("insert FavoriteRecipe failed, no ID obtained.");
		}
		return fav;
	}

	public ArrayList<FavoriteRecipe> getFavoriteRecipeByAccount(int accountId) throws SQLException {
		String sqlQuery = "select * from FavoriteRecipe where accountId=?";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, accountId);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		FavoriteRecipe fav = null;
		ArrayList<FavoriteRecipe> favoriteRecipes = new ArrayList<>();
		while (rs.next()) {
			fav = new FavoriteRecipe();
			fav.setId(rs.getInt(1));
			fav.setRecipeId(rs.getInt(3));

			favoriteRecipes.add(fav);
		}
		return favoriteRecipes;
	}
}
