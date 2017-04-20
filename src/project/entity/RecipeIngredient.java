package project.entity;

public class RecipeIngredient {

	private int id;
	private int recipeId;
	private int ingredientId;
	private String unit;
	private float quantity;
	private boolean isMain;
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
	 * @return the recipeId
	 */
	public int getRecipeId() {
		return recipeId;
	}
	/**
	 * @param recipeId the recipeId to set
	 */
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	/**
	 * @return the ingredientId
	 */
	public int getIngredientId() {
		return ingredientId;
	}
	/**
	 * @param ingredientId the ingredientId to set
	 */
	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}
	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * @return the quantity
	 */
	public float getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the isMain
	 */
	public boolean isMain() {
		return isMain;
	}
	/**
	 * @param isMain the isMain to set
	 */
	public void setMain(boolean isMain) {
		this.isMain = isMain;
	}
	
}
