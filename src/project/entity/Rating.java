package project.entity;

public class Rating {

	private int id;
	private int recipeId;
	private float avgRating;
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
	 * @return the avgRating
	 */
	public float getAvgRating() {
		return avgRating;
	}
	/**
	 * @param avgRating the avgRating to set
	 */
	public void setAvgRating(float avgRating) {
		this.avgRating = avgRating;
	}
	
}
