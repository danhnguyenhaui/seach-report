package sop.search.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import sop.search.dao.ReportDAO;
import sop.search.entities.Report;
import sop.search.utility.ConnectionUtility;
import sop.search.dto.ReportDTO;;

public class ReportDAOImpl implements ReportDAO
{
    private ConnectionUtility connect = null;
    
    public ReportDAOImpl()
    {
        connect = new ConnectionUtility();
    }

    @Override
    public List<ReportDTO> findByAccountID(int accountID)
    {
        List<ReportDTO> list = new ArrayList<>();
        connect = new ConnectionUtility();
        try {
            connect.getSqlFindReportByAccountID().setInt(1, accountID);
            ResultSet result = connect.getSqlFindReportByAccountID().executeQuery();
            while(result.next()) {
                ReportDTO report = new ReportDTO();
                report.setDateOfPost(result.getDate("date_of_post"));
                report.setDescription(result.getString("description"));
                report.setDocumentFileCode(result.getString("document_file_code"));
                report.setNumberOfDownload(result.getInt("number_of_download"));
                report.setNumberOfView(result.getInt("number_of_view"));
                report.setPictureCoverFileCode(result.getString("picture_cover_file_code"));
                report.setPoster(result.getString("fullname"));
                report.setReportID(result.getInt("report.report_id"));
                report.setReportName(result.getString("reportname"));
                report.setVersion(result.getInt("version"));
                report.setVersionID(result.getInt("version_id"));
                report.setCategoryName(result.getString("category_name"));
                report.setActive(result.getBoolean("active"));
                list.add(report);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }finally {
            connect.close();
        }
        return list;
    }

    @Override
    public Report findByReportID(int reportID)
    {
        Report report = null;
        try {
            connect = new ConnectionUtility();
            connect.getSqlFindReportByReportID().setInt(1, reportID);
            ResultSet result = connect.getSqlFindReportByReportID().executeQuery();
            if(result.next()) {
                report = new Report();
                report.setAccountID(result.getInt("account_id"));
                report.setCategoryID(result.getInt("category_id"));
                report.setReportID(result.getInt("report_id"));
                report.setDescription(result.getString("description"));
                report.setNumberOfDownload(result.getInt("number_of_download"));
                report.setReportName(result.getString("reportname"));
                report.setNumberOfView(result.getInt("number_of_view"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return report;
    }

    @Override
    public boolean save(Report report)
    {
        Report r = findByReportID(report.getReportID());
        if(r == null) {
            insert(report);
        }else {
            update(report);
        }
        return false;
    }

    @Override
    public boolean remove(int reportID)
    {
        connect = new ConnectionUtility();
        try {
            connect.getSqlRemoveReport().setInt(1, reportID);
            connect.getSqlRemoveReport().executeUpdate();
            connect.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connect.close();
        }
        return false;
    }

    
    
    @Override
    public List<ReportDTO> findByActive(boolean isActive)
    {
        List<ReportDTO> list = null;
        connect = new ConnectionUtility();
        try {
            connect.getSqlFindReportByActive().setBoolean(1, isActive);
            list = new ArrayList<>();
            ResultSet result = connect.getSqlFindReportByActive().executeQuery();
            while(result.next()) {
                ReportDTO report = new ReportDTO();
                report.setDateOfPost(result.getDate("date_of_post"));
                report.setDescription(result.getString("description"));
                report.setDocumentFileCode(result.getString("document_file_code"));
                report.setNumberOfDownload(result.getInt("number_of_download"));
                report.setNumberOfView(result.getInt("number_of_view"));
                report.setPictureCoverFileCode(result.getString("picture_cover_file_code"));
                report.setPoster(result.getString("fullname"));
                report.setReportID(result.getInt("report.report_id"));
                report.setReportName(result.getString("reportname"));
                report.setVersion(result.getInt("version"));
                report.setVersionID(result.getInt("version_id"));
                report.setCategoryName(result.getString("category_name"));
                report.setActive(result.getBoolean("active"));
                list.add(report);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Report report) {
        try {
            connect = new ConnectionUtility();
            connect.getSqlInsertReport().setInt(1, report.getAccountID());
            connect.getSqlInsertReport().setInt(2, report.getCategoryID());
            connect.getSqlInsertReport().setString(3, report.getReportName());
            connect.getSqlInsertReport().setString(4, report.getDescription());
            connect.getSqlInsertReport().executeUpdate();
            connect.commit();
            System.out.println("INSERT: "+report);
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connect.close();
        }
        
    }
    
    public void update(Report report) {
        try {
            connect = new ConnectionUtility();
            connect.getSqlUpdateReport().setInt(1, report.getAccountID());
            connect.getSqlUpdateReport().setInt(2, report.getCategoryID());
            connect.getSqlUpdateReport().setString(3, report.getReportName());
            connect.getSqlUpdateReport().setString(4, report.getDescription());
            connect.getSqlUpdateReport().setInt(5, report.getNumberOfView());
            connect.getSqlUpdateReport().setInt(6, report.getNumberOfDownload());
            connect.getSqlUpdateReport().executeUpdate();
            connect.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connect.close();
        }
        System.out.println("UPDATE: " +report);
    }

    @Override
    public Report findLastestReport()
    {
        Report report = null;
        try {
            connect = new ConnectionUtility();
            ResultSet result = connect.getSqlFindLastestReport().executeQuery();
            if(result.next()) {
                report = new Report();
                report.setAccountID(result.getInt("account_id"));
                report.setCategoryID(result.getInt("category_id"));
                report.setReportID(result.getInt("report_id"));
                report.setDescription(result.getString("description"));
                report.setNumberOfDownload(result.getInt("number_of_download"));
                report.setReportName(result.getString("reportname"));
                report.setNumberOfView(result.getInt("number_of_view"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connect.close();
        }
        return report;
    }

    @Override
    public List<ReportDTO> orderByQuery(String query)
    {
        List<ReportDTO> list = new ArrayList<>();
        try {
            connect = new ConnectionUtility();
            PreparedStatement sql = connect.getConnection().prepareStatement(query);
            ResultSet result = sql.executeQuery();
            while (result.next()) {
                ReportDTO report = new ReportDTO();
                report.setDateOfPost(result.getDate("date_of_post"));
                report.setDescription(result.getString("description"));
                report.setDocumentFileCode(result.getString("document_file_code"));
                report.setNumberOfDownload(result.getInt("number_of_download"));
                report.setNumberOfView(result.getInt("number_of_view"));
                report.setPictureCoverFileCode(result.getString("picture_cover_file_code"));
                report.setPoster(result.getString("fullname"));
                report.setReportID(result.getInt("report.report_id"));
                report.setReportName(result.getString("reportname"));
                report.setVersion(result.getInt("version"));
                report.setVersionID(result.getInt("version_id"));
                report.setCategoryName(result.getString("category_name"));
                report.setActive(result.getBoolean("active"));
                list.add(report);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connect.close();
        }
        return list;
    }

    @Override
    public List<ReportDTO> findByReportNameAndDescription(String repportName, String description)
    {
        List<ReportDTO> list = new ArrayList<>();
        connect = new ConnectionUtility();
        try {
            connect.getSqlFindReportByReportNameAndDescription().setString(1, '%' + description + '%');
            connect.getSqlFindReportByReportNameAndDescription().setString(2, '%' + repportName + '%');
            ResultSet result = connect.getSqlFindReportByReportNameAndDescription().executeQuery();
            while (result.next()) {
                ReportDTO report = new ReportDTO();
                report.setDateOfPost(result.getDate("date_of_post"));
                report.setDescription(result.getString("description"));
                report.setDocumentFileCode(result.getString("document_file_code"));
                report.setNumberOfDownload(result.getInt("number_of_download"));
                report.setNumberOfView(result.getInt("number_of_view"));
                report.setPictureCoverFileCode(result.getString("picture_cover_file_code"));
                report.setPoster(result.getString("fullname"));
                report.setReportID(result.getInt("report.report_id"));
                report.setReportName(result.getString("reportname"));
                report.setVersion(result.getInt("version"));
                report.setVersionID(result.getInt("version_id"));
                report.setCategoryName(result.getString("category_name"));
                report.setActive(result.getBoolean("active"));
                list.add(report);
                
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }finally {
            connect.close();
        }
        return list;
    }
}
