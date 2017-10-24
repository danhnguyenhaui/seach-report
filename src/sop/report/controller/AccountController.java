package sop.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sop.search.dao.AccountDAO;
import sop.search.dao.impl.AccountDAOImpl;
import sop.search.entities.Account;


/**
 * Servlet implementation class AccountController
 */
@WebServlet("/accountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		String action = request.getParameter("action");
		switch (action)
        {
            case "login":
                login(request, response);
                break;
            
            default:
                break;
        }
	}

	void login(HttpServletRequest request, HttpServletResponse response) {
	    AccountDAO accDAO = new AccountDAOImpl();
	    HttpSession session = request.getSession();
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    Account acc = accDAO.findByUsernameAndPassword(username, password);
	    if(acc != null) {
	        session.setAttribute("ACCOUNT", acc);
	        System.out.println(acc);
	        try {
                response.sendRedirect("http://localhost:8080/SearchReport/");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	    }else {
	        try {
                response.sendRedirect("http://localhost:8080/SearchReport/view/login.jsp?error=true");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	    }
	}
}
