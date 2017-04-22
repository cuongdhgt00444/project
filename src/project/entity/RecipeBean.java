package project.entity;

import java.util.ArrayList;

public class RecipeBean {

	private int id; 
	private String recipeName;
	private String description;
	private String direction;
	private String recipeBy;
	private String category; 
	private String dishType;
	private String cookingStyle;
	private String serveTime;
	private String originalFrom;//country
	private String cost;
	private int serving;
	private String difficulty;
	private float rating;
	private ArrayList<RecipeIngredient> ingredients;
	private ArrayList<RecipeNutrientFact> nutrientFacts;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}
	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the recipeBy
	 */
	public String getRecipeBy() {
		return recipeBy;
	}
	/**
	 * @param recipeBy the recipeBy to set
	 */
	public void setRecipeBy(String recipeBy) {
		this.recipeBy = recipeBy;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the dishType
	 */
	public String getDishType() {
		return dishType;
	}
	/**
	 * @param dishType the dishType to set
	 */
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	/**
	 * @return the cookingStyle
	 */
	public String getCookingStyle() {
		return cookingStyle;
	}
	/**
	 * @param cookingStyle the cookingStyle to set
	 */
	public void setCookingStyle(String cookingStyle) {
		this.cookingStyle = cookingStyle;
	}
	/**
	 * @return the serveTime
	 */
	public String getServeTime() {
		return serveTime;
	}
	/**
	 * @param serveTime the serveTime to set
	 */
	public void setServeTime(String serveTime) {
		this.serveTime = serveTime;
	}
	/**
	 * @return the originalFrom
	 */
	public String getOriginalFrom() {
		return originalFrom;
	}
	/**
	 * @param originalFrom the originalFrom to set
	 */
	public void setOriginalFrom(String originalFrom) {
		this.originalFrom = originalFrom;
	}
	/**
	 * @return the cost
	 */
	public String getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	/**
	 * @return the serving
	 */
	public int getServing() {
		return serving;
	}
	/**
	 * @param serving the serving to set
	 */
	public void setServing(int serving) {
		this.serving = serving;
	}
	/**
	 * @return the difficulty
	 */
	public String getDifficulty() {
		return difficulty;
	}
	/**
	 * @param difficulty the difficulty to set
	 */
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}
	/**
	 * @return the ingredients
	 */
	public ArrayList<RecipeIngredient> getIngredients() {
		return ingredients;
	}
	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(ArrayList<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}
	/**
	 * @return the nutrientFacts
	 */
	public ArrayList<RecipeNutrientFact> getNutrientFacts() {
		return nutrientFacts;
	}
	/**
	 * @param nutrientFacts the nutrientFacts to set
	 */
	public void setNutrientFacts(ArrayList<RecipeNutrientFact> nutrientFacts) {
		this.nutrientFacts = nutrientFacts;
	}
	
}
