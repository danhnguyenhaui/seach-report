package sop.search.dao;

import java.sql.SQLDataException;

import sop.search.entities.Version;

public interface VerionDAO
{
    boolean save(Version version) throws SQLDataException;
    boolean remove(int versionID) throws SQLDataException;
}
