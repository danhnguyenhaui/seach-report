package sop.search.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import sop.search.dao.AccountDAO;
import sop.search.entities.Account;
import sop.search.utility.ConnectionUtility;

public class AccountDAOImpl implements AccountDAO
{
    private ConnectionUtility connection;
    
    public AccountDAOImpl()
    {
        connection = new ConnectionUtility(); 
    }

    @Override
    public boolean save(Account account)
    {
        Account acc = findByUsername(account.getUsername());
        if(acc != null) return false;
        try {
            connection = new ConnectionUtility();
            connection.getSqlSaveAccount().setString(1, account.getUsername());
            connection.getSqlSaveAccount().setString(2, account.getPassword());
            connection.getSqlSaveAccount().setBoolean(3, account.isPermission());
            connection.getSqlSaveAccount().setString(4, account.getEmail());
            connection.getSqlSaveAccount().setString(5, account.getFullname());
            connection.getSqlSaveAccount().execute();
            connection.commit();
            System.out.println(account);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  
        }finally {
            connection.close();
        }
        return true;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password)
    {
        Account acc = null;
        try {
            connection = new ConnectionUtility();
            connection.getSqlFindAccountByUsernameAndPassword()
                .setString(1, username);
            connection.getSqlFindAccountByUsernameAndPassword()
                .setString(2, password);
            ResultSet result = connection.getSqlFindAccountByUsernameAndPassword().executeQuery();
            
            if(result.next()) {
                acc = new Account();
                acc.setAccountID(result.getInt("account_id"));
                acc.setUsername(result.getString("username"));
                acc.setPassword(result.getString("password"));
                acc.setEmail(result.getString("email"));
                acc.setPermission(result.getBoolean("permission"));
                acc.setFullname(result.getString("fullname"));
            }
        } catch (SQLException e) {
            acc = null;
            e.printStackTrace();
        }finally {
            connection.close();
        }
        
        return acc;
    }

    @Override
    public Account findByUsername(String username)
    {
        //System.out.println(username);
        Account acc = null;
        try {
            connection = new ConnectionUtility();
            connection.getSqlFindAccountByUsername()
                .setString(1, username);;
            ResultSet result = connection.getSqlFindAccountByUsername().executeQuery();
            if(result.next()) {
                acc = new Account();
                acc.setAccountID(result.getInt("account_id"));
                acc.setUsername(result.getString("username"));
                acc.setPassword(result.getString("password"));
                acc.setEmail(result.getString("email"));
                acc.setPermission(result.getBoolean("permission"));
                acc.setFullname(result.getString("fullname"));
                
                
            }
        } catch (SQLException e) {
            acc = null;
            e.printStackTrace();
        }finally {
            connection.close();
        }
        
        return acc;
    }
    
}
