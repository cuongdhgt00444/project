package project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.OtherObjectDAO;
import project.entity.Account;
import project.entity.Category;
import project.entity.CookingStyle;
import project.entity.Country;
import project.entity.DishType;
import project.entity.Ingredient;
import project.entity.Nutrient;
import project.entity.ServeTime;

/**
 * Servlet implementation class AddRecipePage
 */
@WebServlet("/addRecipePage")
public class AddRecipePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecipePage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Account account = (Account) request.getSession().getAttribute("account");
		
		try {
			ArrayList<Category> categories = new OtherObjectDAO().getAllCategory();
			ArrayList<DishType> dishtypes = new OtherObjectDAO().getAllDishtype();
			ArrayList<CookingStyle> cookStyles = new OtherObjectDAO().getAllCookingStyle();
			ArrayList<ServeTime> serveTimes = new OtherObjectDAO().getAllServeTime();
			ArrayList<Country> countries = new OtherObjectDAO().getAllCountry();
			ArrayList<Ingredient> ingredients = new OtherObjectDAO().getAllIngredient();
			ArrayList<Nutrient> nutrients = new OtherObjectDAO().getAllNutrient();
			
			request.setAttribute("categories", categories);
			request.setAttribute("dishtypes", dishtypes);
			request.setAttribute("cookStyles", cookStyles);
			request.setAttribute("serveTimes", serveTimes);
			request.setAttribute("countries", countries);
			request.setAttribute("ingredients", ingredients);
			request.setAttribute("nutrients", nutrients);
			
			request.getRequestDispatcher("AddNewRecipe.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
