
package todphod.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;


public class Supplier {
    private static final String cols[] = {"supplier_id", "supplier_name", "supplier_address", "supplier_phone", "supplier_email", "has_gst", "supplier_gst_no"};
    
    private static final String primaryKey = "supplier_id";
    private List<String> columnNames;
    private static final String tableName = "supplier";
    
    private int supplierID;
    private String supplierName;
    private String supplierAddress;
    private String supplierPhone;
    private String supplierEmail;
    private boolean hasGST;
    private String supplierGSTNo;
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }

    public Supplier() {
    }

    public Supplier(int supplierID, String supplierName, String supplierAddress, String supplierPhone, String supplierEmail, boolean hasGST, String supplierGSTNo) {
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
        this.supplierPhone = supplierPhone;
        this.supplierEmail = supplierEmail;
        this.hasGST = hasGST;
        this.supplierGSTNo = supplierGSTNo;
    }
    
    //ALL GETTERS

    public int getSupplierID() {
        return supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public String getSupplierEmail() {
        return supplierEmail;
    }

    public boolean isHasGST() {
        return hasGST;
    }

    public String getSupplierGSTNo() {
        return supplierGSTNo;
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
    
    public HashMap<Integer, Supplier>getAllSuppliers(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public HashMap<Integer, Supplier>getAllSuppliersByProductID(int productID){
        try{
            String sql = "SELECT * FROM supplier WHERE supplier_id in (SELECT supplier_id FROM supplier_product WHERE product_id = " + productID;
            return createHashMapFromResultSet(CRUDOperations.select(sql));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public Supplier getSupplierByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, Supplier> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, Supplier> tempHashMap = new HashMap<>();
//"supplier_id", "supplier_name", "supplier_address", "supplier_phone", "supplier_email", "has_gst", "supplier_gst_no"
        while(rs.next()){
            int tempSupplierID              =   rs.getInt("supplier_id");
            String tempSupplierName         =   rs.getString("supplier_name");
            String tempSupplierAddress        =   rs.getString("supplier_address");
            String tempSupplierPhone      =   rs.getString("supplier_phone");
            String tempSupplierEmail        =   rs.getString("supplier_email");
            boolean tempHasGST               =   rs.getInt("has_gst")!=0;
            String tempSupplierGSTNo        =   rs.getString("supplier_gst_no");
            tempHashMap.put(tempSupplierID, new Supplier(tempSupplierID, tempSupplierName, tempSupplierAddress, tempSupplierPhone, tempSupplierEmail, tempHasGST, tempSupplierGSTNo));
        }
        return tempHashMap;
    }
}
