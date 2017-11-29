package sop.search.dto;

public class ReportIDDTO
{
    private int reportID;

    public ReportIDDTO()
    {
    }

    public ReportIDDTO(int parseInt)
    {
        reportID = parseInt;
    }

    public int getReportID()
    {
        return reportID;
    }

    public void setReportID(int reportID)
    {
        this.reportID = reportID;
    }

    @Override
    public String toString()
    {
        return "ReportIDDTO [reportID=" + reportID + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + reportID;
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ReportIDDTO other = (ReportIDDTO) obj;
        if (reportID != other.reportID)
            return false;
        return true;
    }
    
}
