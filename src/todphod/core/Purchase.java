
package todphod.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;


public class Purchase {
    private static final String cols[] = {"purchase_id", "product_id", "supplier_id", "quantity", "purchase_rate", "purchase_date"};
    
    private static final String primaryKey = "purchase_id";
    private List<String> columnNames;
    private static final String tableName = "purchase";
    
    private int purchaseID;
    private int productID;
    private int supplierID;
    private int quantity;
    private double purchaseRate;
    private String purchaseDate;
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }
    
    public Purchase() {
    }

    public Purchase(int purchaseID, int productID, int supplierID, int quantity, double purchaseRate, String date) {
        this.purchaseID = purchaseID;
        this.productID = productID;
        this.supplierID = supplierID;
        this.quantity = quantity;
        this.purchaseRate = purchaseRate;
        this.purchaseDate = date;
    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public int getProductID() {
        return productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPurchaseRate() {
        return purchaseRate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }
    
    
    public int insert(ArrayList<String> values){
        int id =  CRUDOperations.insert(columnNames, values, tableName);
        int quantity = Integer.parseInt(values.get(2));
        Product p = new Product();
        p = p.getProductByID(Integer.parseInt(values.get(0)));
        ArrayList<String> columns = new ArrayList<>();
        columns.add("product_quantity");
        quantity += p.getProductQuantity();
        ArrayList<String> tempValues = new ArrayList<>();
        tempValues.add(quantity+"");
        p.update(columns, tempValues, p.getProductID());
        return id;
    }
    
    public boolean update(ArrayList<String> columnNames, ArrayList<String> values, int id){
        return CRUDOperations.update(columnNames, values, tableName, primaryKey, id);
    }
    
    public boolean delete(int id){
        return CRUDOperations.delete(tableName, primaryKey, id);
    }
    
    public HashMap<Integer, Purchase>getAllPurchases(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //SELECT * FROM orders WHERE order_date between '2019-01-30' and '2019-02-26'
    public HashMap<Integer, Purchase>getAllPurchasesBetweenDateRange(String startDate, String endDate){
        try{
            String sql = "SELECT * FROM "+tableName +"WHERE order_date between '"+startDate+"' and '"+endDate+"'";
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public Purchase getPurchaseByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, Purchase> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, Purchase> tempHashMap = new HashMap<>();
//        "purchase_id", "product_id", "supplier_id", "quantity", "purchase_rate", "purchase_date"
        while(rs.next()){
            int tempPurchaseID              =   rs.getInt("purchase_id");
            int tempProductID         =   rs.getInt("product_id");
            int tempSupplierID          =   rs.getInt("supplier_id");
            int tempQuantity            =   rs.getInt("quantity");
            double tempPurchaseRate     =   rs.getDouble("purchase_rate");
            String tempPurchaseDate     =   rs.getString("purchase_date");
            tempHashMap.put(tempPurchaseID, new Purchase(tempPurchaseID, tempProductID, tempSupplierID, tempQuantity, tempPurchaseRate, tempPurchaseDate));
        }
        return tempHashMap;
    }
}
