package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import project.entity.RecipeIngredient;

public class RecipeIngredientDAO {

	public static RecipeIngredient insertRecipeIngredient(RecipeIngredient recipeIngredient) throws SQLException {
		String sqlQuery = "insert into RecipeIngredient(recipeId, ingredientId,unit,quantity,isMain) values(?,?,?,?,?)";
		System.out.println("sql: " + sqlQuery);

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, recipeIngredient.getRecipeId());
		statement.setInt(2, recipeIngredient.getIngredientId());
		statement.setString(3, recipeIngredient.getUnit());
		statement.setFloat(4, recipeIngredient.getQuantity());
		statement.setBoolean(5, recipeIngredient.isMain());

		int affectedRows = statement.executeUpdate();

		if (affectedRows == 0) {
			throw new SQLException("insert RecipeIngredient failed, no rows affected.");
		}

		ResultSet generatedKeys = statement.getGeneratedKeys();
		if (generatedKeys.next()) {
			recipeIngredient.setId(generatedKeys.getInt(1));
			System.out.println("inserted RecipeIngredient id: " + recipeIngredient.getId());
		} else {
			throw new SQLException("insert RecipeIngredient failed, no ID obtained.");
		}
		return recipeIngredient;
	}
}
