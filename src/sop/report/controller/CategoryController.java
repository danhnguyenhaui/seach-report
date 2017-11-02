package sop.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sop.report.context.ServletContextListennerImpl;
import sop.search.dao.ReportDAO;
import sop.search.dao.impl.ReportDAOImpl;
import sop.search.dto.ReportDTO;
import sop.search.entities.Category;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	    String view = request.getParameter("view");
	    try {
	        int v = Integer.parseInt(view);
	        @SuppressWarnings("unchecked")
            List<Category> categoryList = (List<Category>) ServletContextListennerImpl.context.getAttribute("CATEGORY_LIST");
	        if(categoryList != null) {
	            for(Category c : categoryList) {
	                if(c.getCategoryID() == v) {
	                    request.setAttribute("categoryName", c.getCategoryName());
	                    String query = "select * from report, version, account, category where "
	                            + "report.report_id = version.report_id" 
	                            + " AND report.account_id = account.account_id"
	                            + " AND report.category_id = category.category_id"
	                            + " AND version.active = true"
	                            + " AND report.category_id = " + v;
	                    ReportDAO reportDAO = new ReportDAOImpl();
	                    List<ReportDTO> list = reportDAO.orderByQuery(query);
	                    request.setAttribute("list", list);
	                    break;
	                }
	            }
	        }
	    }catch (Exception e) {
            if("new".equalsIgnoreCase(view)) {
                request.setAttribute("categoryName", "Báo cáo mới nhất");
                String query = "select * from report, version, account, category where "
                        + "report.report_id = version.report_id" 
                        + " AND report.account_id = account.account_id"
                        + " AND report.category_id = category.category_id"
                        + " AND version.active = true"
                        + " ORDER BY date_of_post DESC";
                ReportDAO reportDAO = new ReportDAOImpl();
                List<ReportDTO> list = reportDAO.orderByQuery(query);
                request.setAttribute("list", list);
            }else if("highlight".equalsIgnoreCase(view)) {
                request.setAttribute("categoryName", "Báo cáo nổi bật");
                String query = "select * from report, version, account, category where "
                        + "report.report_id = version.report_id" 
                        + " AND report.account_id = account.account_id"
                        + " AND report.category_id = category.category_id"
                        + " AND version.active = true"
                        + " ORDER BY (number_of_view + number_of_download) DESC";
                ReportDAO reportDAO = new ReportDAOImpl();
                List<ReportDTO> list = reportDAO.orderByQuery(query);
                request.setAttribute("list", list);
            }
        }finally {
            request.getRequestDispatcher("view/view-report-list.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
