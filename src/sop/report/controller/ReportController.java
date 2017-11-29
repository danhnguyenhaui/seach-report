package sop.report.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.util.Streams;

import sop.report.context.ServletContextListennerImpl;
import sop.search.dao.ReportDAO;
import sop.search.dao.impl.ReportDAOImpl;
import sop.search.dto.ReportDTO;
import sop.search.dto.ReportIDDTO;
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
        System.out.println("GET METHOD: " + response.getCharacterEncoding());
        System.out.println("GET METHOD: " + response.getContentType());
        System.out.println("GET METHOD: " + request.getCharacterEncoding());
        System.out.println("GET METHOD: " + request.getContentType());
        switch (action)
        {
            case "search":
                searchReport(request, response);
                break;
            case "viewReportDetail":
                view(request, response);
                break;
            case "download":
                download(request, response);
                increaseDownload(request);
                break;
            default:
                break;
        }
	}

	private void download(HttpServletRequest request, HttpServletResponse response)
    {
        String fileName = request.getParameter("fileName");
        try {
            FileUtility.download(response, fileName);
            //view(request, response);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

	private void increaseDownload(HttpServletRequest request) {
	    String reportID = request.getParameter("reportID");
	    ReportDAO reportDAO = new ReportDAOImpl();
	    Report report = new Report();
	    report = reportDAO.findByReportID(Integer.parseInt(reportID));
	    report.setNumberOfDownload(report.getNumberOfDownload() + 1);
	    reportDAO.update(report);
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
		System.out.println("POST METHOD: " + response.getCharacterEncoding());
        System.out.println("POST METHOD: " + response.getContentType());
        System.out.println("POST METHOD: " + request.getCharacterEncoding());
        System.out.println("POST METHOD: " + request.getContentType());
		switch (action)
        {
            case "upload":
                upload();
                response.sendRedirect("http://localhost:8080/SearchReport/accountController?action=my-report-list&upload=success");
                break;
            case "editReport":
                editReport(response);
                response.sendRedirect("http://localhost:8080/SearchReport/accountController?action=my-report-list&upload=success");
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
	    System.out.println("ContextPath: "+request.getContextPath()+ ", CharacterEncoding="+request.getCharacterEncoding());
	    try {
	        uploader = new ServletFileUpload(new DiskFileItemFactory());
	        fieldList = uploader.parseRequest(request);
        } catch (FileUploadException e) {
            fieldList = null;
            e.printStackTrace();
        }
	    
	}
	void view(HttpServletRequest request, HttpServletResponse response) {
	    String reportID = request.getParameter("reportID");
	    if(reportID != null) {
	        ReportDAO reportDAO = new ReportDAOImpl();
	        ReportDTO reportDTO = reportDAO.findByReportDTOID(Integer.parseInt(reportID));
	        request.setAttribute("report", reportDTO);
	        Report report = new Report();
	        boolean check = checkViewedReportSession(request);
	        if(!check) {
	            report = reportDAO.findByReportID(Integer.parseInt(reportID));
	            report.setNumberOfView(report.getNumberOfView() + 1);
	            reportDAO.update(report);
	        }
	        try {
                request.getRequestDispatcher("view/view-detailed-report.jsp").forward(request, response);
            } catch (ServletException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            };
	    }
	}
	private boolean checkViewedReportSession(HttpServletRequest request) {
	    ReportDAO reportDAO = new ReportDAOImpl();
	    String reportID = request.getParameter("reportID");
	    ReportIDDTO reportIDDTO = new ReportIDDTO(Integer.parseInt(reportID));
	    HttpSession session = request.getSession();
	    List<ReportIDDTO> listViewedReportID = (List<ReportIDDTO>)session.getAttribute("VIEWED_REPORTS");
	    if(listViewedReportID == null) listViewedReportID = new ArrayList<ReportIDDTO>();
	    if(listViewedReportID.size() > 0) {
	        for(ReportIDDTO r : listViewedReportID) {
	            if(r.equals(reportIDDTO)) {
	                return true;
	            }
	        }
	    }
	    listViewedReportID.add(new ReportIDDTO(Integer.parseInt(reportID)));
	    session.setAttribute("VIEWED_REPORTS", listViewedReportID);
	    System.out.println("Viewed Report List: " + listViewedReportID);
	    return false;
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
                        try {
                            InputStream is = item.getInputStream();
                            String reportName = Streams.asString(is, "UTF-8");
                            report.setReportName(reportName);
                            break;
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    case "categoryID":
                        report.setCategoryID(Integer.parseInt(item.getString()));
                        break;
                    case "description":
                        try {
                            InputStream is = item.getInputStream();
                            String description = Streams.asString(is, "UTF-8");
                            report.setDescription(description);
                            break;
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        
                    case "reportID":
                        report.setReportID(Integer.parseInt(item.getString()));
                        break;
                    default:
                        break;
                }
	        }
	    }
	    System.out.println(report);
	    ReportService reportService = new ReportService();
	    reportService.insertAndUploadReport(report, fieldList);
	}
}
