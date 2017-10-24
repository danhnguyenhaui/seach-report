package sop.search.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import sop.search.config.ConnectionDBConfig;;

public class ConnectionUtility
{
    private Connection connection;
    private PreparedStatement sqlSaveAccount;
    private PreparedStatement sqlFindAccountByUsername;
    private PreparedStatement sqlFindAccountByUsernameAndPassword;
    public ConnectionUtility()
    {
        try {
            Class.forName(ConnectionDBConfig.DRIVER);
            connection = DriverManager.getConnection(
                    ConnectionDBConfig.URL, ConnectionDBConfig.USERNAME
                    , ConnectionDBConfig.PASSWORD);
            sqlSaveAccount = connection.prepareStatement(
                    "insert into account(username, password, permission, email, fullname) values(?, ?, ?, ?, ?)");
            sqlFindAccountByUsername = connection.prepareStatement(
                    "select * from account where username = ?");
            sqlFindAccountByUsernameAndPassword = connection.prepareStatement(
                    "select * from account where username = ? and password = ?");
            connection.setAutoCommit(false);
            
            
        } catch (ClassNotFoundException e) {
            this.connection = null;
            e.printStackTrace();
        } catch (SQLException e) {
            this.connection = null;
            e.printStackTrace();
        }
    }
    public void close() {
        try {
            sqlFindAccountByUsernameAndPassword.close();
            sqlFindAccountByUsername.close();
            sqlSaveAccount.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public PreparedStatement getSqlSaveAccount()
    {
        return sqlSaveAccount;
    }

    public PreparedStatement getSqlFindAccountByUsername()
    {
        return sqlFindAccountByUsername;
    }

    public PreparedStatement getSqlFindAccountByUsernameAndPassword()
    {
        return sqlFindAccountByUsernameAndPassword;
    }

    public void commit() {
        if(connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
