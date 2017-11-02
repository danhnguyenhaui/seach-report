package sop.search.entities;

public class Report
{
    private int reportID = 0;
    private int accountID =0;
    private int categoryID = 0;
    private String reportName = "";
    private String description = "";
    private int numberOfView = 0;
    private int numberOfDownload = 0;
    
    
    public int getCategoryID()
    {
        return categoryID;
    }
    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }
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
    
    public Report()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public Report(int accountID, int categoryID, String reportName, String description, int numberOfView,
            int numberOfDownload)
    {
        super();
        this.accountID = accountID;
        this.categoryID = categoryID;
        this.reportName = reportName;
        this.description = description;
        this.numberOfView = numberOfView;
        this.numberOfDownload = numberOfDownload;
    }
    @Override
    public String toString()
    {
        return "Report [reportID=" + reportID + ", accountID=" + accountID + ", categoryID=" + categoryID
                + ", reportName=" + reportName + ", description=" + description + ", numberOfView=" + numberOfView
                + ", numberOfDownload=" + numberOfDownload + "]";
    }
    
    
    
}
