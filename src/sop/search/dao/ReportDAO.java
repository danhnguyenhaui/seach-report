package sop.search.dao;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.util.List;

import sop.search.dto.ReportDTO;
import sop.search.entities.Report;

public interface ReportDAO
{
    List<ReportDTO> findByAccountID(int accountID);
    Report findByReportID(int reportID);
    boolean save(Report report);
    boolean remove(int reportID);
    List<ReportDTO> findByActive(boolean isActive);
    Report findLastestReport();
    void insert(Report report);
    void update(Report report);
    List<ReportDTO> orderByQuery(String query);
    List<ReportDTO> findByReportNameAndDescription(String repportName, String description);
}
