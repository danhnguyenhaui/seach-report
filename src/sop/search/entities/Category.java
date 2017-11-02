package sop.search.entities;

public class Category
{
    private int categoryID = 0;
    private String categoryName = "";
    public int getCategoryID()
    {
        return categoryID;
    }
    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    }
    public String getCategoryName()
    {
        return categoryName;
    }
    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }
    public Category()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public Category(int categoryID, String categoryName)
    {
        super();
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }
    @Override
    public String toString()
    {
        return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
    }
    
}
