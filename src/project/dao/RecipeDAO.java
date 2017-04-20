package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.entity.Recipe;

public class RecipeDAO {

	public static Recipe insertRecipe(Recipe recipe) throws SQLException {
		String sqlQuery = "insert into Recipe(recipeName, description, direction, recipeBy,"
				+ " category, dishType, cookingStyle, serveTime, originalFrom,"
				+ " cost, serving, difficulty, isApproved) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, recipe.getRecipeName());
		statement.setString(2, recipe.getDescription());
		statement.setString(3, recipe.getDirection());
		statement.setInt(4, recipe.getRecipeBy());
		statement.setInt(5, recipe.getCategory());
		statement.setInt(6, recipe.getDishType());
		statement.setInt(7, recipe.getCookingStyle());
		statement.setString(8, recipe.getServeTime());
		statement.setInt(9, recipe.getOriginalFrom());
		statement.setString(10, recipe.getCost());
		statement.setInt(11, recipe.getServing());
		statement.setString(12, recipe.getDifficulty());
		statement.setBoolean(13, recipe.isApproved());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("insert Recipe failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			recipe.setId(generatedKeys.getInt(1));
			System.out.println("inserted Recipe id: " + recipe.getId());
		} else {
			throw new SQLException("insert Recipe failed, no ID obtained.");
		}
		return recipe;
	}
}
