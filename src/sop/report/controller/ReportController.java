package sop.report.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import sop.report.context.ServletContextListennerImpl;
import sop.search.dao.ReportDAO;
import sop.search.dao.impl.ReportDAOImpl;
import sop.search.dto.ReportDTO;
import sop.search.entities.Report;
import sop.search.service.ReportService;
import sop.search.utility.FileUtility;
import sop.search.service.VersionService;

/**
 * Servlet implementation class ReportController
 */
@WebServlet("/ReportController")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    public static List<FileItem> fieldList = null;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");
	    if(action == null) action = "view";
        System.out.println("ACTION : " + action);
        switch (action)
        {
            case "search":
                searchReport(request, response);
                break;
            default:
                break;
        }
	}

	private void searchReport(HttpServletRequest request, HttpServletResponse response)
    {
        String searchText = request.getParameter("searchText");
        if(searchText != null) {
            searchText = searchText.trim();
            ReportDAO reportDAO = new ReportDAOImpl();
            List<ReportDTO> list = reportDAO.findByReportNameAndDescription(searchText, searchText);
            request.setAttribute("searchList", list);
            request.setAttribute("searchText", searchText);
            try {
                request.getRequestDispatcher("view/search-report.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            };
        }
        
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setFieldList(request);
	    String action = getAction();
		System.out.println("ACTION : " + action);
		switch (action)
        {
            case "upload":
                upload();
                response.sendRedirect("http://localhost:8080/SearchReport/accountController?action=my-report-list&upload=success");
                break;
            case "editReport":
                editReport(response);
                break;
            default:
                break;
        }
		
	}

	private void editReport(HttpServletResponse response) {
	    Report report = new Report();
	    VersionService versionService = new VersionService();
        for(FileItem item : fieldList) {
            if(item.isFormField()) {
                switch (item.getFieldName())
                {
                    case "accountID":
                        report.setAccountID(Integer.parseInt(item.getString().trim()));
                        break;
                    case "reportName":
                        report.setReportName(item.getString());
                        break;
                    case "categoryID":
                        report.setCategoryID(Integer.parseInt(item.getString()));
                        break;
                    case "description":
                        report.setDescription(item.getString());
                        break;
                    case "reportID":
                        report.setReportID(Integer.parseInt(item.getString()));
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println(report);
        versionService.editReport(report, fieldList);
        try {
            response.sendRedirect("http://localhost:8080/SearchReport/accountController?action=my-report-list&editReport=success");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	    
	
	private String getAction() {
	    for(FileItem item : fieldList) {
            if(item.isFormField() 
                    && "action".equalsIgnoreCase(item.getFieldName())) {
                return item.getString();
            }
        }
	    return "";
	}
	
	private void setFieldList(HttpServletRequest request) {
	    try {
	        uploader = new ServletFileUpload(new DiskFileItemFactory());
            fieldList = uploader.parseRequest(request);
        } catch (FileUploadException e) {
            fieldList = null;
            e.printStackTrace();
        }
	    
	}
	private void upload() {
	    Report report = new Report();
	    for(FileItem item : fieldList) {
	        if(item.isFormField()) {
	            switch (item.getFieldName())
                {
                    case "accountID":
                        report.setAccountID(Integer.parseInt(item.getString().trim()));
                        break;
                    case "reportName":
                        report.setReportName(item.getString());
                        break;
                    case "categoryID":
                        report.setCategoryID(Integer.parseInt(item.getString()));
                        break;
                    case "description":
                        report.setDescription(item.getString());
                        break;
                    case "reportID":
                        report.setReportID(Integer.parseInt(item.getString()));
                        break;
                    default:
                        break;
                }
	        }
	    }
	    ReportService reportService = new ReportService();
	    reportService.insertAndUploadReport(report, fieldList);
	}
}
