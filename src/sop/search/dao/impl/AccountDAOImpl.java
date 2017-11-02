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
        if(acc == null) {
            try {
                boolean check = connection.getSqlSaveAccount().execute();
                connection.commit();
                return check;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;  
            }finally {
                connection.close();
            }
        }
        return false;
    }

    @Override
    public Account findByUsernameAndPassword(String username, String password)
    {
        Account acc = null;
        try {
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
        Account acc = null;
        try {
            connection.getSqlFindAccountByUsernameAndPassword()
                .setString(1, username);;
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
    
}
