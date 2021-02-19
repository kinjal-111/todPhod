
package todphod.core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

public class Product {
    private static final String cols[] = {"product_id", "category_id", "product_name", "product_quantity", "product_selling_price", "product_eoq_level", "product_additional_specification"};
    
    private static final String primaryKey = "product_id";
    private List<String> columnNames;
    private static final String tableName = "product";
    
    private int productID;
    private int categoryID;
    private String productName;
    private int productQuantity;
    private double productSellingPrice;
    private int productEOQLevel;
    private String productAdditionalSpecification;
    private byte[] productImage;
    
    {
        columnNames = new ArrayList<>();
        for(String col: cols){
            columnNames.add(col);
        }
    }

    public Product() {
    }

    public Product(int productID, int categoryID, String productName, int productQuantity, double productSellingPrice, int productEOQLevel, String productAdditionalSpecification, byte[] productImage) {
        this.productID = productID;
        this.categoryID = categoryID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productSellingPrice = productSellingPrice;
        this.productEOQLevel = productEOQLevel;
        this.productAdditionalSpecification = productAdditionalSpecification;
        this.productImage = productImage;
    }

    

    public int getProductID() {
        return productID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductSellingPrice() {
        return productSellingPrice;
    }
    
    public int getProductEOQLevel() {
        return productEOQLevel;
    }
    
    public String getProductAdditionalSpecification() {
        return productAdditionalSpecification;
    }

    public byte[] getProductImage() {
        return productImage;
    }
    
    //All Pulic Methods
    public int insert(ArrayList<String> values, byte[] image){
        int insertID = CRUDOperations.insert(columnNames, values, tableName);
        if(image!=null)
            updatePhoto(image, insertID);
        return insertID;
    }
    
    public boolean updatePhoto(byte[] image, int id){
        if(image==null){
            return false;
        }
        String sql = "UPDATE "+tableName + " SET product_image = ? WHERE " + primaryKey + " = "+id;
        try{
            PreparedStatement ps = DBConnection.connectDB().prepareStatement(sql);
            ps.setBytes(1, image);
            int numRows = ps.executeUpdate();
            if(numRows>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Exception : " + e, "Error", JOptionPane.OK_OPTION);
            return false;
        }
    }
    
    public boolean update(ArrayList<String> columnNames, ArrayList<String> values, int id){
        return CRUDOperations.update(columnNames, values, tableName, primaryKey, id);
    }
    
    public boolean delete(int id){
        return CRUDOperations.delete(tableName, primaryKey, id);
    }
    
    public HashMap<Integer, Product>getAllProducts(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, null));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public HashMap<Integer, Product>getProductsBySupplierID(int supplierID){
        try{
            String sql = "SELECT * FROM product WHERE product_id in (SELECT product_id FROM supplier_product WHERE supplier_id = " + supplierID;
            return createHashMapFromResultSet(CRUDOperations.select(sql));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }

    public HashMap<Integer, Product>getAllProductsByCategoryID(int categoryID){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "category_id = " + categoryID));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    
    
    public HashMap<Integer, Product>getAllProductsBelowEOQ(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "product_quantity < product_eoq_level"));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public HashMap<Integer, Product>getAllProductsNearToEOQ(){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, "product_eoq_level >= (product_quantity-2)"));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    public Product getProductByID(int id){
        try{
            return createHashMapFromResultSet(CRUDOperations.select(tableName, primaryKey+" = " + id)).get(id);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, this.getClass() + " Something went Wrong while Fetching records!", "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    //END OF PUBLIC METHODS
    
    //PRIVATE FUNCTIONALITY
    private HashMap<Integer, Product> createHashMapFromResultSet(ResultSet rs) throws SQLException{
        HashMap<Integer, Product> tempHashMap = new HashMap<>();
//        "product_id", "product_name", "product_quantity", "product_selling_price", "product_additional_specification"
        while(rs.next()){
            int tempProductID                   =   rs.getInt("product_id");
            int tempCategoryID                  =   rs.getInt("category_id");
            String tempProductName              =   rs.getString("product_name");
            int tempProductQuantity             =   rs.getInt("product_quantity");
            double tempProductSellingPrice      =   rs.getDouble("product_selling_price");
            int tempProductEOQLevel             =   rs.getInt("product_eoq_level");
            String tempProductAdditionalSpec    =   rs.getString("product_additional_specification");
            byte[] tempProductImage             =   rs.getBytes("product_image");
            tempHashMap.put(tempProductID, new Product(tempProductID, tempCategoryID, tempProductName, tempProductQuantity, tempProductSellingPrice, tempProductEOQLevel, tempProductAdditionalSpec, tempProductImage ));
        }
        return tempHashMap;
    }
}
