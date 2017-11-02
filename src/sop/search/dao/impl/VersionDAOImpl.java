package sop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

import sop.search.dao.VersionDAO;
import sop.search.entities.Version;
import sop.search.utility.ConnectionUtility;

public class VersionDAOImpl implements VersionDAO
{
    private ConnectionUtility connection = null;
    
    
    public VersionDAOImpl()
    {
        connection = new ConnectionUtility();
    }

    @Override
    public int save(Version version)
    {
        int check = -1;
        try {
            connection = new ConnectionUtility();
            connection.getSqlSaveVersion().setInt(1, version.getReportID());
            connection.getSqlSaveVersion().setString(2, version.getDocumentFileCode());
            connection.getSqlSaveVersion().setString(3, version.getPictureCoverFileCode());
            connection.getSqlSaveVersion().setString(4, version.getExtension());
            connection.getSqlSaveVersion().setInt(5, version.getVersion());
            check = connection.getSqlSaveVersion().executeUpdate();
            connection.commit();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }finally {
            connection.close();
        }
        System.out.println("INSERT: " + version);
        return check;
    }
    
    @Override
    public boolean remove(int versionID)
    {
        connection = new ConnectionUtility();
        return false;
    }
    
    @Override
    public Version findByReportIDAndLastestVersion(int reportID)
    {
        Version ver = null;
        try {
            connection = new ConnectionUtility();
            connection.getSqlFindVersionByReportIDAndLastestVersion()
                .setInt(1, reportID);
            connection.getSqlFindVersionByReportIDAndLastestVersion()
            .setInt(2, reportID);
            ResultSet result = connection.getSqlFindVersionByReportIDAndLastestVersion().executeQuery();
            if(result.next()) {
                ver = new Version();
                ver.setVersionID(result.getInt("version_id"));
                ver.setDateOfPost(result.getDate("date_of_post"));
                ver.setActive(result.getBoolean("active"));
                ver.setDocumentFileCode(result.getString("document_file_code"));
                ver.setPictureCoverFileCode(result.getString("picture_cover_file_code"));
                ver.setVersion(result.getInt("version"));
                ver.setReportID(result.getInt("report_id"));
                ver.setExtension(result.getString("extension"));
            }
        } catch (SQLException e) {
            ver = null;
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return ver;
    }

    @Override
    public void activeVersion(int versionID)
    {
        connection = new ConnectionUtility();
        try {
            connection.getSqlActiveVersion().setBoolean(1, true);
            connection.getSqlActiveVersion().setInt(2, versionID);
            connection.getSqlActiveVersion().executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connection.close();
        }
        
    }

    @Override
    public void removeVersion(int versionID)
    {
        connection = new ConnectionUtility();
        try {
            connection.getSqlRemoveVersion().setInt(1, versionID);
            connection.getSqlRemoveVersion().executeUpdate();
            connection.commit();
            System.out.println("REMOVE VERSION HAS ID IS: " + versionID);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connection.close();
        }
        
    }

    @Override
    public void removeByReportIDAndOlderVersion(int reportID, int version)
    {
        connection = new ConnectionUtility();
        try {
            connection.getSqlRemoveVersionByReportIDAndOlderVersion().setInt(1, reportID);
            connection.getSqlRemoveVersionByReportIDAndOlderVersion().setInt(2, version);
            connection.getSqlRemoveVersionByReportIDAndOlderVersion().executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connection.close();
        }
        
        
    }

    @Override
    public Version findByVersionID(int versionID)
    {
        Version version = new Version();
        connection = new ConnectionUtility();
        try {
            connection.getSqlFindVersionByVersionID().setInt(1, versionID);
            ResultSet result = connection.getSqlFindVersionByVersionID().executeQuery();
            if(result.next()) {
                version = new Version();
                version.setVersionID(result.getInt("version_id"));
                version.setDateOfPost(result.getDate("date_of_post"));
                version.setActive(result.getBoolean("active"));
                version.setDocumentFileCode(result.getString("document_file_code"));
                version.setPictureCoverFileCode(result.getString("picture_cover_file_code"));
                version.setVersion(result.getInt("version"));
                version.setReportID(result.getInt("report_id"));
                version.setExtension(result.getString("extension"));
            }
        } catch (SQLException e) {
            version = null;
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return version;
    }

    @Override
    public void update(Version version)
    {
        System.out.println(version);
        connection = new ConnectionUtility();
        try {
            connection.getSqlUpdateVersion().setInt(1, version.getReportID());
            connection.getSqlUpdateVersion().setDate(2, version.getDateOfPost());
            connection.getSqlUpdateVersion().setString(3, version.getDocumentFileCode());
            connection.getSqlUpdateVersion().setString(4, version.getPictureCoverFileCode());
            connection.getSqlUpdateVersion().setString(5, version.getExtension());
            connection.getSqlUpdateVersion().setInt(6, version.getVersion());
            connection.getSqlUpdateVersion().setBoolean(7, version.isActive());
            connection.getSqlUpdateVersion().setInt(8, version.getVersionID());
            connection.getSqlUpdateVersion().executeUpdate();
            connection.commit();
            System.out.println("UPDATED VERSION " + version);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            connection.close();
        }
        
    }
    
}
