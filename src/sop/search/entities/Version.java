package sop.search.entities;

import java.sql.Date;

public class Version
{
    private int versionID = 0;
    private int reportID = 0;
    private Date dateOfPost = null;
    private String documentFileCode = "";
    private String pictureCoverFileCode = "";
    private String extension = "";
    private int version = 0;
    private boolean isActive = false;
    
    
    public String getExtension()
    {
        return extension;
    }
    public void setExtension(String extension)
    {
        this.extension = extension;
    }
    public int getVersionID()
    {
        return versionID;
    }
    public void setVersionID(int versionID)
    {
        this.versionID = versionID;
    }
    public int getReportID()
    {
        return reportID;
    }
    public void setReportID(int reportID)
    {
        this.reportID = reportID;
    }
    public Date getDateOfPost()
    {
        return dateOfPost;
    }
    public void setDateOfPost(Date dateOfPost)
    {
        this.dateOfPost = dateOfPost;
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
    public int getVersion()
    {
        return version;
    }
    public void setVersion(int version)
    {
        this.version = version;
    }
    public boolean isActive()
    {
        return isActive;
    }
    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Version()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public Version(int reportID, Date dateOfPost, String documentFileCode, String pictureCoverFileCode,
            String extension, int version, boolean isActive)
    {
        super();
        this.reportID = reportID;
        this.dateOfPost = dateOfPost;
        this.documentFileCode = documentFileCode;
        this.pictureCoverFileCode = pictureCoverFileCode;
        this.extension = extension;
        this.version = version;
        this.isActive = isActive;
    }
    @Override
    public String toString()
    {
        return "Version [versionID=" + versionID + ", reportID=" + reportID + ", dateOfPost=" + dateOfPost
                + ", documentFileCode=" + documentFileCode + ", pictureCoverFileCode=" + pictureCoverFileCode
                + ", extension=" + extension + ", version=" + version + ", isActive=" + isActive + "]";
    }
    
    
}
