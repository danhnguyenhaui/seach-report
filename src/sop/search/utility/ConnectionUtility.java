package sop.search.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sop.search.config.ConnectionDBConfig;;

public class ConnectionUtility
{
    private Connection connection;
    private PreparedStatement sqlSaveAccount;
    private PreparedStatement sqlFindAccountByUsername;
    private PreparedStatement sqlFindAccountByUsernameAndPassword;
    
    private PreparedStatement sqlFindAllCategories;
    
    private PreparedStatement sqlFindVersionByReportIDAndLastestVersion;
    private PreparedStatement sqlSaveVersion;
    private PreparedStatement sqlRemoveVersion;
    private PreparedStatement sqlActiveVersion;
    private PreparedStatement sqlRemoveVersionByReportIDAndOlderVersion;
    private PreparedStatement sqlFindVersionByVersionID;
    private PreparedStatement sqlUpdateVersion;
    
    private PreparedStatement sqlUpdateReport;
    private PreparedStatement sqlInsertReport;
    private PreparedStatement sqlFindLastestReport;
    private PreparedStatement sqlFindReportByReportID;
    private PreparedStatement sqlRemoveReport;
    private PreparedStatement sqlFindReportByAccountID;
    private PreparedStatement sqlFindReportByActive;
    private PreparedStatement sqlFindReportByReportNameAndDescription;
    private PreparedStatement sqlFindReportDTOByReportID;
    
    public ConnectionUtility()
    {
        try {
            Class.forName(ConnectionDBConfig.DRIVER);
            connection = DriverManager.getConnection(
                    ConnectionDBConfig.URL, ConnectionDBConfig.USERNAME
                    , ConnectionDBConfig.PASSWORD);
            sqlSaveAccount = connection.prepareStatement(
                    "insert into account(username, password, permission, email, fullname) values(?, ?, ?, ?, ?)");
            sqlFindAccountByUsername = connection.prepareStatement(
                    "select * from account where username = ?");
            sqlFindAccountByUsernameAndPassword = connection.prepareStatement(
                    "select * from account where username = ? and password = ?");
            sqlFindAllCategories = connection.prepareStatement(
                    "select * from category");
            sqlFindVersionByReportIDAndLastestVersion = connection.prepareStatement(
                    "SELECT * FROM version as v " + 
                        "WHERE v.version = " + 
                            "(SELECT MAX(version) FROM version WHERE version_id = " + 
                                "(SELECT version_id FROM version WHERE report_id = ?)) " + 
                        "AND v.report_id = ?");
            sqlSaveVersion = connection.prepareStatement(
                    "insert into version(report_id, document_file_code, picture_cover_file_code, extension, version) "
                    + "VALUES(?, ?, ?, ?, ?)");
            sqlInsertReport = connection.prepareStatement(
                    "insert into report(account_id, category_id, reportname, description)"
                    + " values(?, ?, ?, ?)");
            sqlUpdateReport = connection.prepareStatement(
                    "update report set account_id = ?, category_id = ?, reportname = ?,"
                    + " description = ?, number_of_view = ?, number_of_download = ? Where report_id = ?");
            sqlFindLastestReport = connection.prepareStatement(
                    "select * from report where report_id = "
                    + "(select MAX(report_id) from report)");
            sqlFindReportByReportID = connection.prepareStatement(
                    "select * from report where report_id = ?");
            sqlFindReportByAccountID = connection.prepareStatement(
                    "select * from report, version, account, category where "
                        + "report.report_id = version.report_id " 
                        + "AND report.account_id = account.account_id AND report.account_id = ?"
                        + " AND report.category_id = category.category_id");
            sqlFindReportByActive = connection.prepareStatement(
                    "select * from report, version, account, category where "
                            + "report.report_id = version.report_id" 
                            + " AND report.account_id = account.account_id"
                            + " AND report.category_id = category.category_id"
                            + " AND version.active = ?");
            sqlRemoveVersion = connection.prepareStatement(
                    "delete from version where version_id = ?");
            sqlActiveVersion = connection.prepareStatement(
                    "update version set active = ? where version_id = ?");
            sqlFindReportByReportNameAndDescription = connection.prepareStatement(
                    "select * from report, version, account, category where "
                            + "report.report_id = version.report_id" 
                            + " AND report.account_id = account.account_id"
                            + " AND report.category_id = category.category_id"
                            + " AND version.active = true"
                            + " AND (description like ?"
                            + " OR reportname like ?)");
            sqlRemoveReport = connection.prepareStatement(
                    "delete from report where report_id = ?");
            sqlRemoveVersionByReportIDAndOlderVersion = connection.prepareStatement(
                    "delete from version where version.report_id = ? AND version.version < ?");
            sqlFindVersionByVersionID = connection.prepareStatement(
                    "select * from version where version_id = ?");
            sqlUpdateVersion = connection.prepareStatement(
                    "update version set report_id = ?, date_of_post = ?,"
                            + " document_file_code = ?, picture_cover_file_code = ?,"
                            + " extension = ?, version = ?, active = ?"
                            + " WHERE version_id = ?");
            sqlFindReportDTOByReportID = connection.prepareStatement(
                    "select * from report, version, account, category where "
                            + "report.report_id = version.report_id" 
                            + " AND report.account_id = account.account_id"
                            + " AND report.category_id = category.category_id"
                            + " AND version.active = true"
                            + " AND report.report_id = ?");
            
            connection.setAutoCommit(false);
            
            
        } catch (ClassNotFoundException e) {
            this.connection = null;
            e.printStackTrace();
        } catch (SQLException e) {
            this.connection = null;
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            sqlFindAccountByUsernameAndPassword.close();
            sqlFindAccountByUsername.close();
            sqlSaveAccount.close();
            sqlFindAllCategories.close();
            sqlFindVersionByReportIDAndLastestVersion.close();
            sqlSaveVersion.close();
            sqlUpdateReport.close();
            sqlInsertReport.close();
            sqlFindLastestReport.close();
            sqlFindReportByReportID.close();
            sqlFindReportByReportID.close();
            sqlFindReportByActive.close();
            sqlRemoveVersion.close();
            sqlActiveVersion.close();
            sqlFindReportByReportNameAndDescription.close();
            sqlRemoveReport.close();
            sqlRemoveVersionByReportIDAndOlderVersion.close();
            sqlFindVersionByVersionID.close();
            sqlUpdateVersion.close();
            sqlFindReportDTOByReportID.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public PreparedStatement getSqlFindReportDTOByReportID()
    {
        return sqlFindReportDTOByReportID;
    }
    public PreparedStatement getSqlUpdateVersion()
    {
        return sqlUpdateVersion;
    }
    public PreparedStatement getSqlFindVersionByVersionID()
    {
        return sqlFindVersionByVersionID;
    }
    public PreparedStatement getSqlRemoveVersionByReportIDAndOlderVersion()
    {
        return sqlRemoveVersionByReportIDAndOlderVersion;
    }
    
   
    public PreparedStatement getSqlRemoveReport()
    {
        return sqlRemoveReport;
    }
    public PreparedStatement getSqlFindReportByReportNameAndDescription()
    {
        return sqlFindReportByReportNameAndDescription;
    }
    public PreparedStatement getSqlActiveVersion()
    {
        return sqlActiveVersion;
    }
    public PreparedStatement getSqlRemoveVersion()
    {
        return sqlRemoveVersion;
    }
    public PreparedStatement getSqlFindReportByActive()
    {
        return sqlFindReportByActive;
    }
    public PreparedStatement getSqlFindReportByAccountID()
    {
        return sqlFindReportByAccountID;
    }
    public PreparedStatement getSqlFindReportByReportID()
    {
        return sqlFindReportByReportID;
    }
    public PreparedStatement getSqlFindLastestReport()
    {
        return sqlFindLastestReport;
    }
    public PreparedStatement getSqlUpdateReport()
    {
        return sqlUpdateReport;
    }
    public PreparedStatement getSqlInsertReport()
    {
        return sqlInsertReport;
    }
    public PreparedStatement getSqlFindVersionByReportIDAndLastestVersion()
    {
        return sqlFindVersionByReportIDAndLastestVersion;
    }
    public PreparedStatement getSqlSaveVersion()
    {
        return sqlSaveVersion;
    }
    public PreparedStatement getSqlFindAllCategories()
    {
        return sqlFindAllCategories;
    }
    public PreparedStatement getSqlSaveAccount()
    {
        return sqlSaveAccount;
    }

    public PreparedStatement getSqlFindAccountByUsername()
    {
        return sqlFindAccountByUsername;
    }

    public PreparedStatement getSqlFindAccountByUsernameAndPassword()
    {
        return sqlFindAccountByUsernameAndPassword;
    }

    public Connection getConnection()
    {
        return connection;
    }
    public void commit() {
        if(connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
