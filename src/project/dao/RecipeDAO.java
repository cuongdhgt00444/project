package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.entity.Recipe;
import project.entity.RecipeBean;

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

	public ArrayList<RecipeBean> getRecipesByRating() throws SQLException {
		String sqlQuery = "select top(10) r.id, r.recipeName, r.description, a.username, cat.category, dt.dishtype, r.serveTime,"
				+ " c.countryName,cost, serving, difficulty , rate.avgRating"
				+ " from recipe r, account a, category cat, dishType dt, cookingStyle cs, Country c, Rating rate"
				+ " where r.recipeBy = a.id and r.category = cat.id and r.dishType = dt.id"
				+ " and r.cookingStyle = cs.id and r.originalFrom = c.id and rate.recipeId = r.id"
				+ " and r.isApproved = 1 order by rate.avgRating desc";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		RecipeBean rb = null;
		ArrayList<RecipeBean> rateRecipes = new ArrayList<>();
		while (rs.next()) {
			rb = new RecipeBean();
			rb.setId(rs.getInt("id"));
			rb.setRecipeName(rs.getString("recipeName"));
			rb.setDescription(rs.getString("description"));
			rb.setRecipeBy(rs.getString("username"));
			rb.setRating(rs.getFloat("avgRating"));

			rateRecipes.add(rb);
		}
		return rateRecipes;
	}

	public Recipe getDailyRecomendedRecipe(int accountId, String serveTime, int limit) throws SQLException {
		String sqlQuery = "Select top(1) r.id from recipe r,RecipeIngredient ri " + " where r.serveTime like '%"
				+ serveTime + "%' and r.id = ri.recipeId and ri.isMain = 1 and r.isApproved=1"
				+ " and ri.ingredientId  not in"
				+ " (select ri.ingredientId from recipe r, dailyHistory dh, RecipeIngredient ri "
				+ " where r.id = dh.recipeId and dh.recipeId = ri.recipeId and ri.isMain = 1"
				+ "and dh.isChoosen=1 and r.serveTime like '%" + serveTime + "%'"
				+ "and datediff(day,dh.chosenDate,getdate()) < ? and dh.accountId= ?)";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, limit);
		statement.setInt(2, accountId);

		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		Recipe recipe = null;
		while (rs.next()) {
			recipe = new Recipe();
			recipe.setId(rs.getInt("id"));

		}
		return recipe;
	}

	public ArrayList<RecipeBean> getDailyRecommendationForUser(int accountId) throws SQLException {
		String sqlQuery = "select r.id, r.recipeName, r.description, a.username, cat.category, dt.dishtype, r.serveTime,"
				+ " c.countryName,cost, serving, difficulty , rate.avgRating"
				+ " from account a, category cat, dishType dt, cookingStyle cs, Country c, Rating rate,"
				+ " (select * from (select r.* from recipe r, DailyHistory dh, account forUser"
				+ " where r.id = dh.recipeId and forUser.id = dh.accountId and dh.isChoosen = 0 and dh.accountId = ?) a) as r"
				+ " where r.recipeBy = a.id and r.category = cat.id and r.dishType = dt.id "
				+ " and r.cookingStyle = cs.id and r.originalFrom = c.id and rate.recipeId = r.id"
				+ " and r.isApproved = 1 order by rate.avgRating desc";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.setInt(1, accountId);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		RecipeBean rb = null;
		ArrayList<RecipeBean> rateRecipes = new ArrayList<>();
		while (rs.next()) {
			rb = new RecipeBean();
			rb.setId(rs.getInt("id"));
			rb.setRecipeName(rs.getString("recipeName"));
			rb.setDescription(rs.getString("description"));
			rb.setRecipeBy(rs.getString("username"));
			rb.setRating(rs.getFloat("avgRating"));
			rb.setServeTime(rs.getString("serveTime"));

			rateRecipes.add(rb);
		}
		return rateRecipes;
	}
}
