package sop.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sop.search.dao.ReportDAO;
import sop.search.dao.impl.ReportDAOImpl;
import sop.search.dto.ReportDTO;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    view(request, response);
	    System.out.println(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	void view(HttpServletRequest request, HttpServletResponse response) {
        ReportDAO reportDAO = new ReportDAOImpl();
        List<ReportDTO> newReportList = reportDAO.orderByQuery(
                "select * from report, version, account, category where "
                        + "report.report_id = version.report_id" 
                        + " AND report.account_id = account.account_id"
                        + " AND report.category_id = category.category_id"
                        + " AND version.active = true"
                        + " ORDER BY date_of_post DESC LIMIT 0, 3");
        List<ReportDTO> highlightReportList = reportDAO.orderByQuery(
                "select * from report, version, account, category where "
                        + "report.report_id = version.report_id" 
                        + " AND report.account_id = account.account_id"
                        + " AND report.category_id = category.category_id"
                        + " AND version.active = true"
                        + " ORDER BY (number_of_view + number_of_download) DESC LIMIT 0, 3");
        request.setAttribute("newReportList", newReportList);
        request.setAttribute("highlightReportList", highlightReportList);
        try {
            request.getRequestDispatcher("view/home.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
