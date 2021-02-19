
package todphod.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;


public class Customer {
    private static final String cols[] = {"customer_id", "customer_name", "customer_phone", "customer_address", "customer_email", "has_gst", "customer_gst_no"};
    
    private static final String primaryKey = "customer_id";
    private List<String> columnNames;
    private static final String tableName = "customer";
    
    int customerID;
    String customerName;
    String customerPhone;
    String customerAddress;
    String customerEmail;
    boolean hasGST;
    String customerGSTNo;
    
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }
    
    public Customer() {
    }

    public Customer(int customerID, String customerName, String customerPhone, String customerAddress, String customerEmail, boolean hasGST, String customerGSTNo) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
        this.hasGST = hasGST;
        this.customerGSTNo = customerGSTNo;
    }
    
    //ALL GETTERS
    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean isHasGST() {
        return hasGST;
    }

    public String getCustomerGSTNo() {
        return customerGSTNo;
    }
    
    //PUBLIC METHODS
    public int insert(ArrayList<String> values){
        return CRUDOperations.insert(columnNames, values, tableName);
    }
    
    public boolean update(ArrayList<String> columnNames, ArrayList<String> values, int id){
        return CRUDOperations.update(columnNames, values, tableName, primaryKey, id);
    }
    
    public boolean delete(int id){
        return CRUDOperations.delete(tableName, primaryKey, id);
    }
    
    public HashMap<Integer, Customer>getAllCustomers(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public Customer getCustomerByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, Customer> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, Customer> tempHashMap = new HashMap<>();
//        "customer_id", "customer_name", "customer_phone", "customer_address", "customer_email", "has_gst", "customer_gst_no"
        while(rs.next()){
            int tempCustomerID              =   rs.getInt("customer_id");
            String tempCustomerName         =   rs.getString("customer_name");
            String tempCustomerPhone        =   rs.getString("customer_phone");
            String tempCustomerAddress      =   rs.getString("customer_address");
            String tempCustomerEmail        =   rs.getString("customer_email");
            boolean tempHasGST              =   rs.getInt("has_gst")!=0;
            String tempCustomerGSTNo        =   rs.getString("customer_gst_no");
            tempHashMap.put(tempCustomerID, new Customer(tempCustomerID, tempCustomerName, tempCustomerPhone, tempCustomerAddress, tempCustomerEmail, tempHasGST, tempCustomerGSTNo));
        }
        return tempHashMap;
    }
    
    
    
}
