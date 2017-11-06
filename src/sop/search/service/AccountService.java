package sop.search.service;

import sop.search.dao.AccountDAO;
import sop.search.dao.impl.AccountDAOImpl;
import sop.search.entities.Account;

public class AccountService
{
    private AccountDAO accountDAO;

    public AccountService()
    {
        accountDAO = new AccountDAOImpl();
    }
    
    public boolean signUP(String username, String password, boolean permission, String email, String fullname) {
        Account acc = accountDAO.findByUsername(username);
        if(acc != null) return false;
        acc = new Account();
        acc.setEmail(email);
        acc.setFullname(fullname);
        acc.setPassword(password);
        acc.setPermission(permission);
        acc.setUsername(username);
        boolean signup = accountDAO.save(acc);
        return signup;
    }
}
