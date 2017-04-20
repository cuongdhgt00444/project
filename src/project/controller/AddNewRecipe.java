package project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.entity.Account;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Account account = (Account) request.getSession().getAttribute("account");
		String recipeName = request.getParameter("recipeName");
		String description = request.getParameter("description");
		String direction = request.getParameter("direction");
		String cost = request.getParameter("cost");
		String difficulty = request.getParameter("difficulty");
		int categoryId = Integer.parseInt(request.getParameter("category"));
		int dishtype = Integer.parseInt(request.getParameter("dishtype"));
		int cookStyle = Integer.parseInt(request.getParameter("cookStyle"));
		String [] serveTime =  request.getParameterValues("serveTime");
		int country = Integer.parseInt(request.getParameter("country"));
		int mainIngredient = Integer.parseInt(request.getParameter("mainIngredient"));
		String [] otherIngredient = request.getParameterValues("otherIngredient");
		int serving = Integer.parseInt(request.getParameter("serving"));
		
		System.out.println("name: " + recipeName + "-" + 
				"\n name: " + recipeName + "-" +
		"\n description: " + description + "-" +
		"\n direction: " + direction + "-" +
		"\n cost: " + cost + "-" +
		"\n difficulty: " + difficulty + "-" +
		"\n categoryId: " + categoryId + "-" +
		"\n dishtype: " + dishtype + "-" +
		"\n cookStyle: " + cookStyle + "-" +
		"\n country: " + country + "-" +
		"\n mainIngredient: " + mainIngredient + "-" +
		"\n serving: " + serving);
		for (String string : serveTime) {
			System.out.println("\n serveTime: " + string);
		}
		for (String string : otherIngredient) {
			System.out.println("\n other ingredient: " + string);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
