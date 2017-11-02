package sop.report.context;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import sop.search.dao.CategoryDAO;
import sop.search.dao.impl.CategoryDAOImpl;

public class ServletContextListennerImpl implements ServletContextListener
{
    public static ServletContext context;
    private CategoryDAO          categoryDAO;
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        // set category list from database into applicationScope
        context = arg0.getServletContext();
        categoryDAO = new CategoryDAOImpl();
        context.setAttribute("CATEGORY_LIST", categoryDAO.findAll());
        
        // set realPath
        context.setAttribute("REAL_PATH", context.getRealPath("/"));
    }
    
}
