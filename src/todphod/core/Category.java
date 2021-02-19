
package todphod.core;

import todphod.core.CRUDOperations;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;


public class Category {
    private static final String cols[] = {"category_id", "category_name"};
    
    private static final String primaryKey = "category_id";
    private List<String> columnNames;
    private static final String tableName = "category";
    
    private int categoryID;
    private String categoryName;
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }

    public Category() {
    }

    public Category(int categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }
    
    //All Getters

    public int getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }
    
    //ALL PUBLIC METHODS
    public int insert(ArrayList<String> values){
        return CRUDOperations.insert(columnNames, values, tableName);
    }
    
    public boolean update(ArrayList<String> columnNames, ArrayList<String> values, int id){
        return CRUDOperations.update(columnNames, values, tableName, primaryKey, id);
    }
    
    public boolean delete(int id){
        return CRUDOperations.delete(tableName, primaryKey, id);
    }
    
    public HashMap<Integer, Category>getAllCategories(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public Category getCategoryByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, Category> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, Category> tempHashMap = new HashMap<>();
        //"category_id", "category_name"
        while(rs.next()){
            int tempCategoryID              =   rs.getInt("category_id");
            String tempCategoryName         =   rs.getString("category_name");
            tempHashMap.put(tempCategoryID, new Category(tempCategoryID, tempCategoryName));
        }
        return tempHashMap;
    }
}
