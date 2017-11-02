package sop.search.dto;

import java.util.Date;

public class ReportDTO
{
    private int reportID = 0;
    private int versionID = 0;
    private String reportName = "";
    private String description = "";
    private Date dateOfPost = null;
    private int numberOfDownload = 0;
    private int numberOfView = 0;
    private int version = 0;
    private String poster = "";
    private String documentFileCode = "";
    private String pictureCoverFileCode = "";
    private boolean isActive = false;
    private String categoryName = "";
       
    
    public boolean isActive()
    {
        return isActive;
    }
    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }
    public String getCategoryName()
    {
        return categoryName;
    }
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
    public int getVersion()
    {
        return version;
    }
    public void setVersion(int version)
    {
        this.version = version;
    }
    public String getDocumentFileCode()
    {
        return documentFileCode;
    }
    public void setDocumentFileCode(String documentFileCode)
    {
        this.documentFileCode = documentFileCode;
    }
    public String getPictureCoverFileCode()
    {
        return pictureCoverFileCode;
    }
    public void setPictureCoverFileCode(String pictureCoverFileCode)
    {
        this.pictureCoverFileCode = pictureCoverFileCode;
    }
    public int getReportID()
    {
        return reportID;
    }
    public void setReportID(int reportID)
    {
        this.reportID = reportID;
    }
    public int getVersionID()
    {
        return versionID;
    }
    public void setVersionID(int versionID)
    {
        this.versionID = versionID;
    }
    public String getReportName()
    {
        return reportName;
    }
    public void setReportName(String reportName)
    {
        this.reportName = reportName;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public Date getDateOfPost()
    {
        return dateOfPost;
    }
    public void setDateOfPost(Date dateOfPost)
    {
        this.dateOfPost = dateOfPost;
    }
    public int getNumberOfDownload()
    {
        return numberOfDownload;
    }
    public void setNumberOfDownload(int numberOfDownload)
    {
        this.numberOfDownload = numberOfDownload;
    }
    public int getNumberOfView()
    {
        return numberOfView;
    }
    public void setNumberOfView(int numberOfView)
    {
        this.numberOfView = numberOfView;
    }
    public String getPoster()
    {
        return poster;
    }
    public void setPoster(String poster)
    {
        this.poster = poster;
    }
    public ReportDTO()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public ReportDTO(int reportID, int versionID, String reportName, String description, Date dateOfPost,
            int numberOfDownload, int numberOfView, int version, String poster, String documentFileCode,
            String pictureCoverFileCode, boolean isActive, String categoryName)
    {
        super();
        this.reportID = reportID;
        this.versionID = versionID;
        this.reportName = reportName;
        this.description = description;
        this.dateOfPost = dateOfPost;
        this.numberOfDownload = numberOfDownload;
        this.numberOfView = numberOfView;
        this.version = version;
        this.poster = poster;
        this.documentFileCode = documentFileCode;
        this.pictureCoverFileCode = pictureCoverFileCode;
        this.isActive = isActive;
        this.categoryName = categoryName;
    }
    @Override
    public String toString()
    {
        return "ReportDTO [reportID=" + reportID + ", versionID=" + versionID + ", reportName=" + reportName
                + ", description=" + description + ", dateOfPost=" + dateOfPost + ", numberOfDownload="
                + numberOfDownload + ", numberOfView=" + numberOfView + ", version=" + version + ", poster=" + poster
                + ", documentFileCode=" + documentFileCode + ", pictureCoverFileCode=" + pictureCoverFileCode
                + ", isActive=" + isActive + ", categoryName=" + categoryName + "]";
    }
    
    
    
}
