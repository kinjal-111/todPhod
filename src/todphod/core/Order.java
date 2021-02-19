
package todphod.core;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class Order {
    private static final String cols[] = {"order_id", "customer_id", "state", "order_date"};
    
    private static final String primaryKey = "category_id";
    private List<String> columnNames;
    private static final String tableName = "orders";
    
    private int orderID;
    private int customerID;
    private int state;
    private String orderDate;
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }

    public Order() {
    }

    public Order(int orderID, int customerID, int state, String orderDate) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.state = state;
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getState() {
        return state;
    }

    public String getOrderDate() {
        return orderDate;
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
    
    public HashMap<Integer, Order>getAllOrders(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public HashMap<Integer, Order>getAllOrdersOfCustomer(int customerID){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "customer_id = " + customerID));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
//    SELECT * FROM orders WHERE order_date between '2019-01-30' and '2019-02-26'
    
    public HashMap<Integer, Order>getAllOrdersBetweenDateRange(String startDate, String endDate){
        try{
            String sql = "SELECT * FROM "+tableName+" WHERE order_date between '"+startDate+"' and '"+endDate+"'";
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "customer_id = " + customerID));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    
    public HashMap<Integer, Order>getAllOrdersOfState(int state){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "state = " + state));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public Order getOrderByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, Order> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, Order> tempHashMap = new HashMap<>();
//        "order_id", "customer_id", "state"
        while(rs.next()){
            int tempOrderID             =   rs.getInt("order_id");
            int tempCustomerID          =   rs.getInt("customer_id");
            int tempState               =   rs.getInt("state");
            String tempDate             =   rs.getString("order_date");
            tempHashMap.put(tempOrderID, new Order(tempOrderID, tempCustomerID, tempState, tempDate));
        }
        return tempHashMap;
    }
}
