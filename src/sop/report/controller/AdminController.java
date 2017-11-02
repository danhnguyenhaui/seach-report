package sop.report.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sop.search.dao.ReportDAO;
import sop.search.dao.VersionDAO;
import sop.search.dao.impl.ReportDAOImpl;
import sop.search.dao.impl.VersionDAOImpl;
import sop.search.dto.ReportDTO;
import sop.search.service.ReportService;
import sop.search.service.VersionService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	    String action = request.getParameter("action");
	    if(action == null) action = "checking";
	    System.out.println(action);
	    switch (action)
        {
            case "removeVersion":
                //System.out.println("removeVersion");
                removeVersion(request, response);
                break;
            case "activeVersion":
                activeVersion(request, response);
                break;
            case "checking":
                admin(request, response);
                break;
            default: 
                break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	void activeVersion(HttpServletRequest request, HttpServletResponse response) {
	    String versionID = request.getParameter("versionID");
        if(versionID != null) {
            VersionService versionService = new VersionService();
            try {
                versionService.activeVersion(Integer.parseInt(versionID));
                admin(request, response);
                //response.sendRedirect("view/admin.jsp");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	}
	void removeVersion(HttpServletRequest request, HttpServletResponse response) {
	    String versionID = request.getParameter("versionID");
	    if(versionID != null) {
	        VersionService versionService = new VersionService();
	        try {
	            versionService.removeVersion(Integer.parseInt(versionID));
	            admin(request, response);
	        }catch (Exception e) {
                e.printStackTrace();
            }
	        
	    }
	}
	void admin(HttpServletRequest request, HttpServletResponse response) {
        List<ReportDTO> list = null;
        ReportDAO reportDAO = new ReportDAOImpl();
        list =reportDAO.findByActive(false);
        request.setAttribute("reportList", list);
        try {
            request.getRequestDispatcher("view/admin.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
