/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todphod.core;



import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import todphod.ui.components.ProductOrderPanel;
import todphod.ui.pages.PlaceOrder;
import todphod.utilities.TOClient;

public class BillGenTP {
    private int id;
    private String customerName;
    private String productName;
    private int productCount;
    double price;
    private double GST ,totalPrice;

    LocalDate todaysDate;
    
    int columnWidths = 5;
    
    PlaceOrder placeOrder;
    
    //private int selectedCustomer;
    private List<ProductOrderPanel> products;
    
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    BillGenTP(){
       placeOrder = new PlaceOrder();
//        customerName = placeOrder.getJcbCustomerName();
//        System.out.println(customerName);
        this.products = new ArrayList<>();
        customerName = placeOrder.getJcbCustomers().getSelectedItem().toString();
  //      this.selectedCustomer = this.customers.get(customerName);
        try {
            todaysDate = LocalDate.now();
            Document document = new Document();
            String FILE = customerName+".pdf";
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
           //document.add(new Chunk(""));
            addMetaData(document);
            addTitlePage(document);
            addContent(document);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public void addMetaData(Document document) {
        document.addTitle(customerName + "Bill");
    }
   
     public void addContent(Document document) throws DocumentException {

        Paragraph subPara = new Paragraph();
        // add a table
        createTable(subPara);
        document.add(subPara);

    }
     public void addTitlePage(Document document)throws DocumentException {
        Paragraph preface = new Paragraph();
        
        addEmptyLine(preface, 1);

        Paragraph p=new Paragraph();
        p.add(new Paragraph("       Customer's Name" + customerName,catFont));
        document.add(p);
        
//        preface.add(new Paragraph("       regd No -TNA/KLN/HSG-11660/99-2000 KALYAN(W) 421 301",subFont));
//        preface.add(new Paragraph("______________________________________________________________________________"));
//        addEmptyLine(preface,1);
//        addTab(preface,6);
          preface.add(("Date: "+todaysDate));
          addTab(preface,1);
//        preface.add("             Due date: "+(dueDate));
//        addEmptyLine(preface,1);
//        preface.add(new Paragraph("Owner name: "+(owner),smallBold));
//        preface.add(new Paragraph("FLAT NO: "+(flatNo),smallBold));
//
        addEmptyLine(preface,1);
//
//        
        document.add(preface);
    }
     public void createTable(Paragraph subPara) throws BadElementException {
            PdfPTable table = new PdfPTable(columnWidths);
        try{
            PdfPCell c1 = new PdfPCell(new Phrase("Product Name",smallBold));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Quantity",smallBold));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Total Price",smallBold));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

//            c1 = new PdfPCell(new Phrase("GST",smallBold));
//            c1.setHorizontalAlignment(0);
//            table.addCell(c1);
//
//            c1 = new PdfPCell(new Phrase("Total Amount",smallBold ));
//            c1.setHorizontalAlignment(0);
//            table.addCell(c1);

Order order = new Order();
        
       // int customerId = this.selectedCustomer;
        ArrayList<Integer> productsList = new ArrayList<>();
        ArrayList<Integer> quantityList = new ArrayList<>();
        for(ProductOrderPanel productOrderPanel : this.products) {
            int productId = productOrderPanel.getProductId();
            int quantity = productOrderPanel.getQuantity();
            if(productId == -1) {
                //JOptionPane.showMessageDialog(this, "Please select a product for all the items");
                return;
            } else if(quantity == 0) {
               // JOptionPane.showMessageDialog(this, "Please specify the quantity for all the products");
            }
            productsList.add(productId);
            quantityList.add(quantity);
        }
        
//        if(customerId == -1) {
//           // JOptionPane.showMessageDialog(this, "Please Select a customer");
//            return;
//        }
        
        ArrayList<String> values = new ArrayList<>();
        // Customer ID
        //values.add(customerId + "");
        // State of the order
        values.add(1 + "");
        // Date of Order
        values.add(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        
        int id = order.insert(values);
        if(id != -1) {
            OrderProducts orderProducts = new OrderProducts();
            for(int i=0;i<productsList.size();i++) {
                values = new ArrayList<>();
                
                // Order ID
                values.add(id + "");
                // Product ID
                values.add(productsList.get(i) + "");
                // Quantity 
                values.add(quantityList.get(i) + "");
                
                int orderProductId = orderProducts.insert(values);
                if(orderProductId == -1) {
                    return;
                }
            }
           // JOptionPane.showMessageDialog(this, "Order Placed successfully");
           // TOClient.sendSMS(new Customer().getCustomerByID(this.selectedCustomer).getCustomerPhone(), "Your order has been placed sucessfully at Tod Phod.");
        }
/*
            Order order = new Order();
        List<JComponent> components = new ArrayList<>();
        
        Map<Integer, Order> orderMap = order.getAllOrders();
        
        for(Order orderInfo : orderMap.values()) {
            int id = orderInfo.getOrderID();
            String customerName = new Customer().getCustomerByID(orderInfo.getCustomerID()).getCustomerName();
            int productCount = new OrderProducts().getAllOrderProductsByOrderID(id).keySet().size();
         
                
                for(OrderProducts orderProducts : new OrderProducts().getAllOrderProductsByOrderID(id).values()) {
                totalPrice += orderProducts.getQuantity() * new Product().getProductByID(orderProducts.getProductID()).getProductSellingPrice();
            }
            this.GST = totalPrice / 9.3;
            this.price = this.totalPrice - this.GST;
            table.addCell(productName+"");
            table.addCell(productCount+"");
            table.addCell(price+"");
            table.addCell(GST+"");
            table.addCell(totalPrice+"");
                
            System.out.println("totalPrice = " + totalPrice);
        }
               
  */      
        }catch(Exception e){}
        subPara.add(table);
        

    }
    public static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    public static void addTab(Paragraph paragraph,int number){
        String tab="    ";
        Chunk chunk=new Chunk("");
        for(int i=0;i<number;i++){
            chunk.append(tab);
            paragraph.add(chunk);
        }
    }
    public static void main(String args[]){
        new BillGenTP();
    }
}
