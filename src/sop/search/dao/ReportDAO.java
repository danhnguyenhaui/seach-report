package sop.search.dao;
import java.sql.ResultSet;
import java.sql.SQLDataException;

import sop.search.entities.Report;

public interface ReportDAO
{
    ResultSet findByAccountID(int accountID) throws SQLDataException;
    ResultSet findByReportID(int reportID) throws SQLDataException;
    boolean save(Report report) throws SQLDataException;
    boolean remove(int reportID) throws SQLDataException;
    ResultSet orderByReportNameAndDescripton() throws SQLDataException;
}
