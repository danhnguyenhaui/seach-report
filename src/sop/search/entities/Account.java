package sop.search.entities;

public class Account
{
    private int accountID = 0;
    private String username = "";
    private String password = "";
    private boolean isPermission = false;
    private String email = "";
    private String fullname = "";
    
    
    public int getAccountID()
    {
        return accountID;
    }
    public void setAccountID(int accountID)
    {
        this.accountID = accountID;
    }
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public boolean isPermission()
    {
        return isPermission;
    }
    public void setPermission(boolean isPermission)
    {
        this.isPermission = isPermission;
    }
        public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getFullname()
    {
        return fullname;
    }
    public void setFullname(String fullname)
    {
        this.fullname = fullname;
    }
    public Account()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public Account(String username, String password, boolean isPermission, String email, String fullname)
    {
        super();
        this.username = username;
        this.password = password;
        this.isPermission = isPermission;
        this.email = email;
        this.fullname = fullname;
    }
    @Override
    public String toString()
    {
        return "Account [accountID=" + accountID + ", username=" + username + ", password=" + password
                + ", isPermission=" + isPermission + ", email=" + email + ", fullname=" + fullname + "]";
    }
    
    
}
