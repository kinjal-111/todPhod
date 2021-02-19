/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todphod.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class OrderProducts {
    private static final String cols[] = {"id", "order_id", "product_id", "quantity"};
    
    private static final String primaryKey = "id";
    private List<String> columnNames;
    private static final String tableName = "order_products";
    
    private int id;
    private int orderID;
    private int productID;
    private int quantity;
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }

    public OrderProducts() {
    }

    public OrderProducts(int id, int orderID, int productID, int quantity) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
    }
    
    //All GETTERS

    public int getId() {
        return id;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public int insert(ArrayList<String> values){
//        "id", "order_id", "product_id", "quantity"
        int tempQuantity = Integer.parseInt(values.get(values.size()-1));
        Product p = new Product();
        p = p.getProductByID(Integer.parseInt(values.get(1)));
        if(tempQuantity > p.getProductQuantity()){
            JOptionPane.showMessageDialog(null, "Ohh Snap!! Im running low with this product!", "Sorry!", JOptionPane.OK_OPTION + JOptionPane.ERROR_MESSAGE);
            return -1;
        }else{
            ArrayList<String> columns = new ArrayList<>();
            columns.add("product_quantity");
            tempQuantity -= p.getProductQuantity();
            ArrayList<String> tempValues = new ArrayList<>();
            tempValues.add(tempQuantity+"");
        }
        int id = CRUDOperations.insert(columnNames, values, tableName);
        return id;
    }
    
    public boolean update(ArrayList<String> columnNames, ArrayList<String> values, int id){
        return CRUDOperations.update(columnNames, values, tableName, primaryKey, id);
    }
    
    public boolean delete(int id){
        return CRUDOperations.delete(tableName, primaryKey, id);
    }
    
    public HashMap<Integer, OrderProducts>getAllOrderProducts(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public HashMap<Integer, OrderProducts>getAllOrderProductsByOrderID(int orderID){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "order_id = " + orderID));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public HashMap<Integer, OrderProducts>getAllOrderOrdersByProductID(int productID){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "product_id = " + productID));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public OrderProducts getOrderProductByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, OrderProducts> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, OrderProducts> tempHashMap = new HashMap<>();
//        "id", "order_id", "product_id", "quantity"
        while(rs.next()){
            int tempID              =   rs.getInt("id");
            int tempOrderID         =   rs.getInt("order_id");
            int tempProductID       =   rs.getInt("product_id");
            int tempQuantity        =   rs.getInt("quantity");
            tempHashMap.put(tempID, new OrderProducts(tempID, tempOrderID, tempProductID, tempQuantity));
        }
        return tempHashMap;
    }
}
