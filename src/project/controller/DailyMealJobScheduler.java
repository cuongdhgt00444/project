/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import project.dao.AccountDAO;
import project.dao.DailyHistoryDAO;
import project.dao.RecipeDAO;
import project.entity.Account;
import project.entity.DailyHistory;
import project.entity.Recipe;
import project.entity.RecipeBean;
import project.utils.ProjectUtils;
import project.utils.SendMail;

/**
 *
 * @author CuongDH
 */
public class DailyMealJobScheduler extends TimerTask {

	public DailyMealJobScheduler() {
	}

	@Override
	public void run() {
		System.out.println("starting job");
		try {
			ArrayList<Account> users = new AccountDAO().getAllUsers();

			DailyHistory dh = null;
			DailyHistoryDAO dhDao = new DailyHistoryDAO();
			RecipeDAO rd = new RecipeDAO();
			ArrayList<Recipe> dailyRecommendations = null;
			ArrayList<RecipeBean> dailyRecommendationsToView = null;
			for (Account account : users) {

				dh = new DailyHistory();
				dh.setAccountId(account.getId());
				dh.setChoosen(false);
				ArrayList<DailyHistory> dailyHistories = dhDao.getUnchoosenRecommendation(dh);

				// check if already has
				// if not get recipe and insert
				if (null == dailyHistories || dailyHistories.size() == 0) {
					System.out.println("getting daily recommendation");
					dailyRecommendations = getDailyRecommendations(account);

					System.out.println("start to insert daily recommendation");
					addRecommendations(dhDao, dailyRecommendations, account);
				}
				
				//send recommendation email
				dailyRecommendationsToView = new ArrayList<>();
				dailyRecommendationsToView = rd.getDailyRecommendationForUser(account.getId());
				String mailContent = ProjectUtils.buildRecommendationMailContent(account, dailyRecommendationsToView);
				SendMail.sendMail(account.getEmail(), "Daily recommendation", mailContent);
			}

		} catch (SQLException ex) {
			Logger.getLogger(DailyMealJobScheduler.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/**
	 * @param dhDao
	 * @param dailyRecommendations
	 * @param account
	 * @throws SQLException
	 */
	private void addRecommendations(DailyHistoryDAO dhDao, ArrayList<Recipe> dailyRecommendations, Account account)
			throws SQLException {
		DailyHistory dh;
		for (Recipe recipe : dailyRecommendations) {
			dh = new DailyHistory();
			dh.setAccountId(account.getId());
			dh.setRecipeId(recipe.getId());
			dh.setChosenDate(ProjectUtils.GetCurrentDatetime().toString());
			dh.setChoosen(false);

			dhDao.insertDailyRecommendation(dh);
		}
	}

	/**
	 * @param account
	 * @throws SQLException
	 */
	private ArrayList<Recipe> getDailyRecommendations(Account account) throws SQLException {
		ArrayList<Recipe> dailyRecommendations;
		dailyRecommendations = new ArrayList<>();
		Recipe recommendedBreakfast = new RecipeDAO().getDailyRecomendedRecipe(account.getId(), "breakfast", 3);
		dailyRecommendations.add(recommendedBreakfast);
		System.out.println("breakfast id: " + recommendedBreakfast.getId());

		Recipe recommendedLunch = new RecipeDAO().getDailyRecomendedRecipe(account.getId(), "lunch", 3);
		dailyRecommendations.add(recommendedLunch);
		System.out.println("lunch id: " + recommendedLunch.getId());

		Recipe recommendedDinner = new RecipeDAO().getDailyRecomendedRecipe(account.getId(), "dinner", 3);
		dailyRecommendations.add(recommendedDinner);
		System.out.println("dinner id: " + recommendedDinner.getId());

		return dailyRecommendations;
	}

}
