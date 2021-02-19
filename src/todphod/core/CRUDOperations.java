
package todphod.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class CRUDOperations {
    private static Connection conn;
    
    static{
        conn = DBConnection.connectDB();
    }
    static ResultSet select(String customQuery){
        try {
            PreparedStatement ps =conn.prepareStatement(customQuery);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Exception : " + e, "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    static ResultSet select(String tableName, String condition){
        String sql;
        if(condition==null){
            condition = "1";
        }
        sql = "SELECT * FROM "+ tableName + " WHERE "+ condition;
        try {
            PreparedStatement ps =conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Exception : " + e, "Error", JOptionPane.OK_OPTION);
            return null;
        }
    }
    
    static int insert(List<String> columnNames, List<String> columnValues, String tableName) throws NullPointerException, IllegalArgumentException{
        int id=-1;
        if(columnNames == null){
            throw new NullPointerException("Column Names cannot be NULL");
        }
        if(columnValues == null){
            throw new NullPointerException("Column Values cannot be NULL");
        }
        if(columnNames.size()!=(columnValues.size()+1)){
            throw new IllegalArgumentException("Column Count and Value Count Does Not Match! ColumnNameCount: " +columnNames.size()+" ColumnValueCount: " +columnValues.size());
        }
        StringBuffer s = new StringBuffer("INSERT INTO " + tableName + "(");
        
        for(int i=1;i<columnNames.size();i++){
            s.append(columnNames.get(i)+ ((i<columnNames.size()-1)?", ":""));
        }
        
        s.append(") VALUES (");
        for(int i=0;i<columnValues.size();i++){
            s.append("?"+ ((i<columnValues.size()-1)?", ":""));
        }
        
        
        s.append(")");
        String sql = s.toString();
        try{
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for(int i=0;i<columnValues.size(); i++){
                ps.setString((i+1), columnValues.get(i));
            }
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
            return id;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Exception : " + e, "Error", JOptionPane.OK_OPTION);
            return -1;
        }
    }
    
    static boolean update(List<String> columnNames, List<String> columnValues, String tableName, String conditionalColumnName, int id){
        if(conditionalColumnName == null){
            throw new NullPointerException("Conditional Column Cannot be NULL");
        }
        if(id<=0){
            throw new IllegalArgumentException("ID cannot be 0 or less!");
        }
        if(columnNames == null){
            throw new NullPointerException("Column Names cannot be NULL");
        }
        if(columnValues == null){
            throw new NullPointerException("Column Values cannot be NULL");
        }
        if(columnNames.size()!=columnValues.size()){
            throw new IllegalArgumentException("Column Count and Value Count Does Not Match! ");
        }
        
        StringBuffer s = new StringBuffer("UPDATE " + tableName + " SET ");
        for(int i=0; i<columnNames.size(); i++){
            s.append(columnNames.get(i) + " = ?" + ((i<columnValues.size()-1)?", ":""));
        }
        s.append(" WHERE " + conditionalColumnName + " = " + id);
        String sql = s.toString();
        try{
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for(int i=0;i<columnValues.size(); i++){
                ps.setString((i+1), columnValues.get(i));
            }
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
    
    static boolean delete(String tableName, String conditionalColumnName, int id){
        if(conditionalColumnName == null){
            throw new NullPointerException("Conditional Column Cannot be NULL");
        }
        if(id<=0){
            throw new IllegalArgumentException("ID cannot be 0 or less!");
        }
        String sql = "DELETE FROM "+tableName+" WHERE "+conditionalColumnName+" = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int numRows = ps.executeUpdate();
            if(numRows>0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error while deleting record!");
            return false;
        }
    }
}
