package sop.search.service;

import java.util.List;

import org.apache.commons.fileupload.FileItem;

import sop.search.dao.ReportDAO;
import sop.search.dao.VersionDAO;
import sop.search.dao.impl.ReportDAOImpl;
import sop.search.dao.impl.VersionDAOImpl;
import sop.search.entities.Report;
import sop.search.entities.Version;
import sop.search.utility.FileUtility;

public class ReportService
{
    private ReportDAO reportDAO;
    private VersionDAO versionDAO;
    public ReportService()
    {
        reportDAO = new ReportDAOImpl();
        versionDAO = new VersionDAOImpl();
    }

    public void insertAndUploadReport(Report report, List<FileItem> fieldList) {
        
        // insert report
        reportDAO.insert(report);
        Report lastestReport = reportDAO.findLastestReport();
        int lastestReportID = lastestReport.getReportID();
        // insert a new version for the report
        Version v = new Version();
        String extension = FileUtility.getFileExtension(fieldList);
        v.setExtension(extension);
        v.setReportID(lastestReportID);
        v.setDocumentFileCode(lastestReport.getReportID()
                +"_V1_" + lastestReport.getReportName() + extension);
        v.setPictureCoverFileCode(lastestReport.getReportID()
                + "_V1_" + lastestReport.getReportName() + ".png");
        v.setVersion(1);
        versionDAO.save(v);
        // upload report to server
        FileUtility.upload(fieldList, v);
       
    }
    
}
