package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import project.entity.Category;
import project.entity.CookingStyle;
import project.entity.Country;
import project.entity.DishType;
import project.entity.Ingredient;
import project.entity.Nutrient;
import project.entity.ServeTime;

public class OtherObjectDAO {

	public ArrayList<Category> getAllCategory() throws SQLException {
		String sqlQuery = "select * from Category";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		Category category = null;
		ArrayList<Category> categories = new ArrayList<>();
		while (rs.next()) {
			category = new Category();
			category.setId(rs.getInt(1));
			category.setCategory(rs.getString(2));

			categories.add(category);
		}
		return categories;
	}
	
	public ArrayList<DishType> getAllDishtype() throws SQLException {
		String sqlQuery = "select * from DishType";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		DishType dishtype = null;
		ArrayList<DishType> types = new ArrayList<>();
		while (rs.next()) {
			dishtype = new DishType();
			dishtype.setId(rs.getInt(1));
			dishtype.setDishType(rs.getString(2));

			types.add(dishtype);
		}
		return types;
	}
	
	public ArrayList<CookingStyle> getAllCookingStyle() throws SQLException {
		String sqlQuery = "select * from CookingStyle";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		CookingStyle style = null;
		ArrayList<CookingStyle> styles = new ArrayList<>();
		while (rs.next()) {
			style = new CookingStyle();
			style.setId(rs.getInt(1));
			style.setStyle(rs.getString(2));

			styles.add(style);
		}
		return styles;
	}
	
	public ArrayList<ServeTime> getAllServeTime() throws SQLException {
		String sqlQuery = "select * from ServeTime";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		ServeTime serveTime = null;
		ArrayList<ServeTime> times = new ArrayList<>();
		while (rs.next()) {
			serveTime = new ServeTime();
			serveTime.setId(rs.getInt(1));
			serveTime.setServeTime(rs.getString(2));

			times.add(serveTime);
		}
		return times;
	}
	
	public ArrayList<Country> getAllCountry() throws SQLException {
		String sqlQuery = "select * from Country";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		Country country = null;
		ArrayList<Country> countries = new ArrayList<>();
		while (rs.next()) {
			country = new Country();
			country.setId(rs.getInt(1));
			country.setCountryName(rs.getString(2));

			countries.add(country);
		}
		return countries;
	}
	
	public ArrayList<Nutrient> getAllNutrient() throws SQLException {
		String sqlQuery = "select * from Nutrient";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		Nutrient nutrient = null;
		ArrayList<Nutrient> nutrients = new ArrayList<>();
		while (rs.next()) {
			nutrient = new Nutrient();
			nutrient.setId(rs.getInt(1));
			nutrient.setNutrientName(rs.getString(2));

			nutrients.add(nutrient);
		}
		return nutrients;
	}
	
	public ArrayList<Ingredient> getAllIngredient() throws SQLException {
		String sqlQuery = "select * from Ingredient";

		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
		statement.executeQuery();

		ResultSet rs = statement.getResultSet();
		Ingredient ingredient = null;
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		while (rs.next()) {
			ingredient = new Ingredient();
			ingredient.setId(rs.getInt(1));
			ingredient.setIngredientName(rs.getString(2));
			ingredient.setIngredientType(rs.getString(3));

			ingredients.add(ingredient);
		}
		return ingredients;
	}
}
