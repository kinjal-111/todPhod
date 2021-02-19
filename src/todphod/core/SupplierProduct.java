
package todphod.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;


public class SupplierProduct {
    private static final String cols[] = {"id","supplier_id", "product_id"};
    
    private static final String primaryKey = "id";
    private List<String> columnNames;
    private static final String tableName = "supplier_product";
    
    private int id;
    private int supplier_id;
    private int product_id;
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }

    public SupplierProduct() {
    }

    public SupplierProduct(int id, int supplier_id, int product_id) {
        this.id = id;
        this.supplier_id = supplier_id;
        this.product_id = product_id;
    }

    public int getId() {
        return id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public int getProduct_id() {
        return product_id;
    }
    
    public int insert(ArrayList<String> values){
        return CRUDOperations.insert(columnNames, values, tableName);
    }
    
    public boolean update(ArrayList<String> columnNames, ArrayList<String> values, int id){
        return CRUDOperations.update(columnNames, values, tableName, primaryKey, id);
    }
    
    public boolean delete(int id){
        return CRUDOperations.delete(tableName, primaryKey, id);
    }
    
    public HashMap<Integer, SupplierProduct>getAllSupplierProducts(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public SupplierProduct getSupplierProductByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, SupplierProduct> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, SupplierProduct> tempHashMap = new HashMap<>();
        //"category_id", "category_name"
        while(rs.next()){
            int tempID              =   rs.getInt("id");
            int tempSupplierID      =   rs.getInt("supplier_id");
            int tempProductID       =   rs.getInt("product_id");
            tempHashMap.put(tempID, new SupplierProduct(tempID, tempSupplierID, tempProductID));
        }
        return tempHashMap;
    }
}
