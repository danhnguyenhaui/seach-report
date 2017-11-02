package sop.search.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sop.search.dao.CategoryDAO;
import sop.search.entities.Category;

import sop.search.utility.ConnectionUtility;;
public class CategoryDAOImpl implements CategoryDAO
{
    ConnectionUtility connection;
    
    public CategoryDAOImpl()
    {
        connection = new ConnectionUtility();
    }

    @Override
    public List<Category> findAll()
    {
        List<Category> list = new ArrayList<Category>();
        try {
            ResultSet result = connection.getSqlFindAllCategories().executeQuery();
            while(result.next()) {
                Category category = new Category();
                category.setCategoryID(result.getInt("category_id"));
                category.setCategoryName(result.getString("category_name"));
                list.add(category);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return list;
    }

    @Override
    public Category findByCategoryID(int categoryID)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
}
