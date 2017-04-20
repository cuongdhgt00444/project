package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.entity.RecipeNutrientFact;

public class RecipeNutrientFactDAO {

	public RecipeNutrientFact insertRecipeIngredient(RecipeNutrientFact recipeNutrientFact) throws SQLException {
		String sqlQuery = "insert into RecipeNutrientFact(recipeId, nutrient,unit,quantity) values(?,?,?,?)";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, recipeNutrientFact.getRecipeId());
		statement.setInt(2, recipeNutrientFact.getNutrient());
		statement.setString(3, recipeNutrientFact.getUnit());
		statement.setFloat(4, recipeNutrientFact.getQuantity());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("insert RecipeNutrientFact failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			recipeNutrientFact.setId(generatedKeys.getInt(1));
			System.out.println("inserted RecipeNutrientFact id: " + recipeNutrientFact.getId());
		} else {
			throw new SQLException("insert RecipeNutrientFact failed, no ID obtained.");
		}
		return recipeNutrientFact;
	}
}
