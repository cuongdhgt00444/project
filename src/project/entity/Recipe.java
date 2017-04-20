package project.entity;

public class Recipe {

	private int id; 
	private String recipeName;
	private String description;
	private String direction; //how to make
	private int recipeBy;// references Account(id),
	private int category; //int references Category(id),
	private int dishType;
	private int cookingStyle;
	private String serveTime;
	private int originalFrom;//country
	private String cost;
	private int serving;
	private String difficulty;
	private boolean isApproved;
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
	public int getRecipeBy() {
		return recipeBy;
	}
	/**
	 * @param recipeBy the recipeBy to set
	 */
	public void setRecipeBy(int recipeBy) {
		this.recipeBy = recipeBy;
	}
	/**
	 * @return the category
	 */
	public int getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(int category) {
		this.category = category;
	}
	/**
	 * @return the dishType
	 */
	public int getDishType() {
		return dishType;
	}
	/**
	 * @param dishType the dishType to set
	 */
	public void setDishType(int dishType) {
		this.dishType = dishType;
	}
	/**
	 * @return the cookingStyle
	 */
	public int getCookingStyle() {
		return cookingStyle;
	}
	/**
	 * @param cookingStyle the cookingStyle to set
	 */
	public void setCookingStyle(int cookingStyle) {
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
	public int getOriginalFrom() {
		return originalFrom;
	}
	/**
	 * @param originalFrom the originalFrom to set
	 */
	public void setOriginalFrom(int originalFrom) {
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
	 * @return the isApproved
	 */
	public boolean isApproved() {
		return isApproved;
	}
	/**
	 * @param isApproved the isApproved to set
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
}
