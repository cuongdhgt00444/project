package project.entity;

public class Review {

	private int id;
	private int accountId;
	private int recipeId;
	private float rating;
	private String comment;
	private String reviewedDate;
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
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the reviewedDate
	 */
	public String getReviewedDate() {
		return reviewedDate;
	}
	/**
	 * @param reviewedDate the reviewedDate to set
	 */
	public void setReviewedDate(String reviewedDate) {
		this.reviewedDate = reviewedDate;
	}
	
}
