package project.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.dao.AccountDAO;
import project.entity.Account;
import project.utils.ProjectUtils;
import project.utils.SendMail;

/**
 * Servlet implementation class AddNewAccount
 */
@WebServlet("/AddNewAccount")
public class AddNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNewAccount() {
		super();
	}

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Account acc = new Account();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String middlename = request.getParameter("middlename");
		String dob = request.getParameter("dob");
		String email = request.getParameter("email");
		boolean receiveDailyEmail = request.getParameter("recommendation") == null ? false: true;

		acc.setFirstName(firstname);
		acc.setMiddleName(middlename);
		acc.setLastName(lastname);
		acc.setDob(dob);
		acc.setUsername(username);
		acc.setPassword(password);
		acc.setEmail(email);
		acc.setReceiveDailyEmail(receiveDailyEmail);
		acc.setRole(2);

		// TODO: check exist email, username
		
		try {
			Account insertedAcc = AccountDAO.insertAccount(acc);
			String mailContent = ProjectUtils.buildMailContent(username, password);
			SendMail.sendMail(email, "New Account", mailContent);

			response.sendRedirect("AddNewAccountResult.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
