package sop.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sop.search.dao.AccountDAO;
import sop.search.dao.ReportDAO;
import sop.search.dao.impl.AccountDAOImpl;
import sop.search.dao.impl.ReportDAOImpl;
import sop.search.dto.ReportDTO;
import sop.search.entities.Account;
import sop.search.entities.Report;


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
	    String action = request.getParameter("action");
        switch (action)
        {
            case "login":
                login(request, response);
                
                break;
            case "my-report-list":
                viewMyReportList(request, response);
                break;
            case "admin":
                response.sendRedirect("http://localhost:8080/SearchReport/admin");
                break;
            case "editReport":
                editReport(request, response);
                break;
            default:
                break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

	void editReport(HttpServletRequest request, HttpServletResponse response) {
	    String reportID = request.getParameter("reportID");
	    ReportDAO reportDAO = new ReportDAOImpl();
	    Report report = reportDAO.findByReportID(Integer.parseInt(reportID));
	    request.setAttribute("report", report);
	    try {
            request.getRequestDispatcher("view/edit-report.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	void viewMyReportList(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        Account acc = (Account)request.getSession().getAttribute("ACCOUNT");
	        ReportDAO reportDAO = new ReportDAOImpl();
	        List<ReportDTO> list = reportDAO.findByAccountID(acc.getAccountID());
	        request.setAttribute("myReportList", list);
            request.getRequestDispatcher("view/my-report-list.jsp").forward(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
	        System.out.println((Account)session.getAttribute("ACCOUNT"));
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
