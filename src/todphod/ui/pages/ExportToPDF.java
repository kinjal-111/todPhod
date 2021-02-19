
package todphod.ui.pages;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import todphod.core.Customer;
import todphod.core.Order;
import todphod.core.OrderProducts;
import todphod.core.Product;
import todphod.ui.components.ItemList;
import todphod.ui.components.MailSending;
import todphod.ui.components.ReportInfoPanel;

public class ExportToPDF {
 
    private int id;
    private String customerName;
    private int productCount;
    double price;
    private double GST ,totalPrice;

    int columnWidths = 5;
    
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    ExportToPDF(){
        try {
            Document document = new Document();
            String FILE = "Sales.pdf";
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
           //document.add(new Chunk(""));
            addMetaData(document);
            addContent(document);
            document.close();
            new MailSending();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PDF generated");
        
    }

     public void addMetaData(Document document) {
        document.addTitle("Bill");
    }
   
     public void addContent(Document document) throws DocumentException {

        Paragraph subPara = new Paragraph();
        // add a table
        createTable(subPara);
        document.add(subPara);

    }
     public void createTable(Paragraph subPara) throws BadElementException {
        PdfPTable table = new PdfPTable(columnWidths);
        try{
            PdfPCell c1 = new PdfPCell(new Phrase("Customer",smallBold));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Quantity",smallBold));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Price",smallBold));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("GST",smallBold));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Total Amount",smallBold ));
            c1.setHorizontalAlignment(0);
            table.addCell(c1);

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
            table.addCell(customerName+"");
            table.addCell(productCount+"");
            table.addCell(price+"");
            table.addCell(GST+"");
            table.addCell(totalPrice+"");
                
            System.out.println("totalPrice = " + totalPrice);
        }
               
        
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
}
