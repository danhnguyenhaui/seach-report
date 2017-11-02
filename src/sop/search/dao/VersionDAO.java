package sop.search.dao;

import java.sql.SQLDataException;

import sop.search.entities.Version;

public interface VersionDAO
{
    int save(Version version);
    boolean remove(int versionID);
    Version findByReportIDAndLastestVersion(int reportID);
    void activeVersion(int versionID);
    void removeVersion(int versionID);
    void removeByReportIDAndOlderVersion(int reportID, int version);
    Version findByVersionID(int versionID);
    void update(Version version);
}
