package project.entity;

public class DailyHistory {

	private int id;
	private int accountId;
	private int recipeId;
	private String chosenDate;
	private boolean isChoosen;
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
	 * @return the chosenDate
	 */
	public String getChosenDate() {
		return chosenDate;
	}
	/**
	 * @param chosenDate the chosenDate to set
	 */
	public void setChosenDate(String chosenDate) {
		this.chosenDate = chosenDate;
	}
	/**
	 * @return the isChoosen
	 */
	public boolean isChoosen() {
		return isChoosen;
	}
	/**
	 * @param isChoosen the isChoosen to set
	 */
	public void setChoosen(boolean isChoosen) {
		this.isChoosen = isChoosen;
	}
}
