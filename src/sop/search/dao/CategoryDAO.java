package sop.search.dao;
import java.util.List;

import sop.search.entities.Category;
public interface CategoryDAO
{
    List<Category> findAll();
    Category findByCategoryID(int categoryID);
}
