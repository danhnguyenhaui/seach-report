package sop.search.entities;

public class Report
{
    private int reportID = 0;
    private int accountID =0;
    private String reportName = "";
    private String description = "";
    private int numberOfView = 0;
    private int numberOfDownload = 0;
    public int getReportID()
    {
        return reportID;
    }
    public void setReportID(int reportID)
    {
        this.reportID = reportID;
    }
    public int getAccountID()
    {
        return accountID;
    }
    public void setAccountID(int accountID)
    {
        this.accountID = accountID;
    }
    public String getReportName()
    {
        return reportName;
    }
    public void setReportName(String reportname)
    {
        this.reportName = reportname;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public int getNumberOfView()
    {
        return numberOfView;
    }
    public void setNumberOfView(int numberOfView)
    {
        this.numberOfView = numberOfView;
    }
    public int getNumberOfDownload()
    {
        return numberOfDownload;
    }
    public void setNumberOfDownload(int numberOfDownload)
    {
        this.numberOfDownload = numberOfDownload;
    }
    public Report(int accountID, String reportName, String description, int numberOfView, int numberOfDownload)
    {
        super();
        this.accountID = accountID;
        this.reportName = reportName;
        this.description = description;
        this.numberOfView = numberOfView;
        this.numberOfDownload = numberOfDownload;
    }
    public Report()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public String toString()
    {
        return "Report [reportID=" + reportID + ", accountID=" + accountID + ", reportName=" + reportName
                + ", description=" + description + ", numberOfView=" + numberOfView + ", numberOfDownload="
                + numberOfDownload + "]";
    }
    
    
}
