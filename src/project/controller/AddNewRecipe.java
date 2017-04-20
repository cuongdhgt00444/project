package project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import project.dao.OtherObjectDAO;
import project.dao.RecipeDAO;
import project.dao.RecipeIngredientDAO;
import project.dao.RecipeNutrientFactDAO;
import project.entity.Account;
import project.entity.Category;
import project.entity.CookingStyle;
import project.entity.Country;
import project.entity.DishType;
import project.entity.Ingredient;
import project.entity.Nutrient;
import project.entity.Recipe;
import project.entity.RecipeIngredient;
import project.entity.RecipeNutrientFact;
import project.entity.ServeTime;

/**
 * Servlet implementation class AdddNewRecipe
 */
@WebServlet("/AddNewRecipe")
public class AddNewRecipe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewRecipe() {
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
		String step = request.getParameter("step");
		if (step.equals("1")) {
			step1(request, response, account);
		}

		if (step.equals("2")) {
			step2(request, response);
		}

		if (step.equals("3")) {
			int calorie = Integer.parseInt(request.getParameter("calorie"));
			int protein = Integer.parseInt(request.getParameter("protein"));
			int fat = Integer.parseInt(request.getParameter("fat"));
			System.out.println("\n calorie: " + calorie + "-" + "\n protein: " + protein + "-" + "\n fat: " + fat);

			Recipe r = (Recipe) request.getSession().getAttribute("recipe");
			Recipe inserted = new Recipe();
			try {
				inserted = new RecipeDAO().insertRecipe(r);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			RecipeIngredient mainIngredient = (RecipeIngredient) request.getSession().getAttribute("mainIngredient");
			mainIngredient.setRecipeId(inserted.getId());

			try {
				new RecipeIngredientDAO().insertRecipeIngredient(mainIngredient);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			RecipeNutrientFactDAO rnfDao = new RecipeNutrientFactDAO();

			RecipeNutrientFact recipeCalorie = new RecipeNutrientFact();
			recipeCalorie.setNutrient(4);
			recipeCalorie.setQuantity(calorie);
			recipeCalorie.setUnit("calorie");
			recipeCalorie.setRecipeId(inserted.getId());
			try {
				rnfDao.insertRecipeIngredient(recipeCalorie);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			RecipeNutrientFact recipeFat = new RecipeNutrientFact();
			recipeFat.setNutrient(2);
			recipeFat.setQuantity(fat);
			recipeFat.setUnit("gram");
			recipeFat.setRecipeId(inserted.getId());
			try {
				rnfDao.insertRecipeIngredient(recipeFat);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			RecipeNutrientFact recipeProtein = new RecipeNutrientFact();
			recipeProtein.setNutrient(1);
			recipeProtein.setQuantity(protein);
			recipeProtein.setUnit("gram");
			recipeProtein.setRecipeId(inserted.getId());
			try {
				rnfDao.insertRecipeIngredient(recipeProtein);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("AddResult.jsp").forward(request, response);
		}

	}

	/**
	 * @param request
	 * @throws IOException
	 * @throws ServletException
	 */
	private void step2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mainIngredient = Integer.parseInt(request.getParameter("mainIngredient"));
		int mainIngredientQuan = Integer.parseInt(request.getParameter("mainQuantity"));
		String[] otherIngredient = request.getParameterValues("otherIngredient");
		if (null != otherIngredient) {
			for (String string : otherIngredient) {
				System.out.println("\n other ingredient: " + string);
			}
		}

		RecipeIngredient mainRI = new RecipeIngredient();
		mainRI.setIngredientId(mainIngredient);
		mainRI.setMain(true);
		mainRI.setQuantity(mainIngredientQuan);
		mainRI.setUnit("gram");

		HttpSession session = request.getSession(false);
		session.setAttribute("mainIngredient", mainRI);
		request.getRequestDispatcher("AddNewRecipe3.jsp").forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @param account
	 * @throws ServletException
	 * @throws IOException
	 */
	private void step1(HttpServletRequest request, HttpServletResponse response, Account account)
			throws ServletException, IOException {
		String recipeName = request.getParameter("recipeName");
		String description = request.getParameter("description");
		String direction = request.getParameter("direction");
		String cost = request.getParameter("cost");
		String difficulty = request.getParameter("difficulty");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int dishtype = Integer.parseInt(request.getParameter("dishtype"));
		int cookStyle = Integer.parseInt(request.getParameter("cookStyle"));
		String[] serveTime = request.getParameterValues("serveTime");
		int country = Integer.parseInt(request.getParameter("country"));

		int serving = Integer.parseInt(request.getParameter("serving"));

		System.out.println("name: " + recipeName + "-" + "\n name: " + recipeName + "-" + "\n description: "
				+ description + "-" + "\n direction: " + direction + "-" + "\n cost: " + cost + "-" + "\n difficulty: "
				+ difficulty + "-" + "\n categoryId: " + categoryId + "-" + "\n dishtype: " + dishtype + "-"
				+ "\n cookStyle: " + cookStyle + "-" + "\n country: " + country + "-" + "-" + "\n serving: " + serving);
		for (String string : serveTime) {
			System.out.println("\n serveTime: " + string);
		}

		Recipe recipe = new Recipe();
		recipe.setRecipeName(recipeName);
		recipe.setDescription(description);
		recipe.setDirection(direction);
		recipe.setCategory(categoryId);
		recipe.setCookingStyle(cookStyle);
		recipe.setDishType(dishtype);
		recipe.setCost(cost);
		recipe.setDifficulty(difficulty);
		recipe.setOriginalFrom(country);
		recipe.setRecipeBy(account.getId());
		recipe.setServeTime(String.join(",", serveTime));
		recipe.setServing(serving);
		if (account.getRole() == 1) {
			recipe.setApproved(true);
		} else {
			recipe.setApproved(false);
		}
		

		ArrayList<Ingredient> ingredients = new ArrayList<>();
		ArrayList<Nutrient> nutrients = new ArrayList<>();
		try {
			ingredients = new OtherObjectDAO().getAllIngredient();
			nutrients = new OtherObjectDAO().getAllNutrient();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("ingredients", ingredients);
		request.setAttribute("nutrients", nutrients);

		HttpSession session = request.getSession(false);
		session.setAttribute("recipe", recipe);
		request.getRequestDispatcher("AddNewRecipe2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
