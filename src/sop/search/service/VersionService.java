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

public class VersionService
{
    private VersionDAO  versionDAO = null;
    private ReportDAO reportDAO = null;
    
    public VersionService()
    {
        versionDAO = new VersionDAOImpl();
        reportDAO = new ReportDAOImpl();
    }

    public void editReport(Report report, List<FileItem> fieldList) {
        Version lastestVersion = versionDAO.findByReportIDAndLastestVersion(report.getReportID());
        System.out.println(lastestVersion);
        // insert a new version for the report
        Version v = new Version();
        String extension = FileUtility.getFileExtension(fieldList);
        v.setExtension(extension);
        v.setActive(false);
        v.setVersion(lastestVersion.getVersion()+1);
        v.setPictureCoverFileCode(report.getReportID()
                + "_V" + v.getVersion() + "_" + report.getReportName() + ".png");
        v.setDateOfPost(lastestVersion.getDateOfPost());
        v.setDocumentFileCode(report.getReportID()
                +"_V"+ v.getVersion() +"_" + report.getReportName() + extension);
        v.setReportID(report.getReportID());
        versionDAO.save(v);
        // versionDAO.remove(lastestVersion.getVersionID());
        // upload report to server
        FileUtility.upload(fieldList, v);
    }
    public void activeVersion(int versionID) {
        Version version = versionDAO.findByVersionID(versionID);
        version.setActive(true);
        versionDAO.update(version);
        versionDAO.removeByReportIDAndOlderVersion(version.getReportID(), version.getVersion());
    }
    
    public void removeVersion(int versionID) {
        Version version = versionDAO.findByVersionID(versionID);
        if(version != null) {
            versionDAO.remove(versionID);
            if(version.getVersion() <= 1) {
                reportDAO.remove(version.getReportID());
            }
        }
    }
}
