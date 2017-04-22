package project.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.RecipeDAO;
import project.entity.Account;
import project.entity.RecipeBean;

/**
 * Servlet implementation class DailyRecommendaion
 */
@WebServlet("/DailyRecommendation")
public class DailyRecommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DailyRecommendation() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Account account = (Account) request.getSession().getAttribute("account");

		try {
			ArrayList<RecipeBean> dailyRecommendation = new RecipeDAO().getDailyRecommendationForUser(account.getId());
			ArrayList<RecipeBean> breakfasts = new ArrayList<>();
			RecipeBean breakfast = new RecipeBean();
			for (RecipeBean recipeBean : dailyRecommendation) {
				System.out.println("time:" + recipeBean.getServeTime());
				if (recipeBean.getServeTime().toLowerCase().contains("breakfast")) {
					breakfasts.add(recipeBean);
					breakfast = recipeBean;
				}
			}
			dailyRecommendation.remove(breakfast);
			
			System.out.println("recipes:" + dailyRecommendation.size());
			request.setAttribute("recipes", dailyRecommendation);
			request.setAttribute("breakfast", breakfasts);
			request.getRequestDispatcher("DailyRecommendation.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
