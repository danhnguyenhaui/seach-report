package sop.search.dao;

import java.sql.ResultSet;
import sop.search.entities.Account;

public interface AccountDAO
{
    boolean save(Account account);
    Account findByUsernameAndPassword(String username, String password);
    Account findByUsername(String username);
}
