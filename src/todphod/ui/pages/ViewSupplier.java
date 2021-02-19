
package todphod.ui.pages;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import todphod.core.Supplier;
import todphod.ui.UIUtils;


public class ViewSupplier extends javax.swing.JPanel {

    /**
     * Creates new form AddCustomer
     */
    public ViewSupplier(int supplierId) {
        initComponents();
        this.setSize(1090, 750);
        
        Supplier supplier = new Supplier().getSupplierByID(supplierId);
        this.jtfSupplierAddress.getjTextField().setText(supplier.getSupplierAddress());
        this.jtfSupplierEmail.getjTextField().setText(supplier.getSupplierEmail());
        this.jtfSupplierGSTNo.getjTextField().setText(supplier.getSupplierGSTNo());
        this.jtfSupplierName.getjTextField().setText(supplier.getSupplierName());
        this.jtfSupplierPhoneNo.getjTextField().setText(supplier.getSupplierPhone());
        
        this.jtfSupplierAddress.getjTextField().setEnabled(false);
        this.jtfSupplierName.getjTextField().setEnabled(false);
        this.jtfSupplierEmail.getjTextField().setEnabled(false);
        this.jtfSupplierPhoneNo.getjTextField().setEnabled(false);
        this.jtfSupplierGSTNo.getjTextField().setEnabled(false);
        
        
        this.customInitComponents();
    }
    
    private void customInitComponents() {
        UIUtils.configureTextField(jtfSupplierName);
        UIUtils.configureTextField(jtfSupplierAddress);
        UIUtils.configureTextField(jtfSupplierPhoneNo);
        UIUtils.configureTextField(jtfSupplierEmail);
        UIUtils.configureTextField(jtfSupplierGSTNo);
        
        UIUtils.setIcon(this.jLabel2, "save");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfSupplierName = new org.uikit.MaterialJTextField();
        jtfSupplierAddress = new org.uikit.MaterialJTextField();
        jtfSupplierPhoneNo = new org.uikit.MaterialJTextField();
        jtfSupplierEmail = new org.uikit.MaterialJTextField();
        jtfSupplierGSTNo = new org.uikit.MaterialJTextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Raleway", 0, 32)); // NOI18N
        jLabel1.setText("View Supplier");

        jtfSupplierName.setLabelText("Supplier Name : ");
        jtfSupplierName.setPlaceholderText("Enter the name of the supplier : ");
        jtfSupplierName.setPreferredSize(new java.awt.Dimension(435, 81));

        jtfSupplierAddress.setLabelText("Supplier Address : ");
        jtfSupplierAddress.setPlaceholderText("Enter the supplier's address : ");
        jtfSupplierAddress.setPreferredSize(new java.awt.Dimension(961, 81));

        jtfSupplierPhoneNo.setLabelText("Supplier Phone No : ");
        jtfSupplierPhoneNo.setPlaceholderText("Enter the supplier's phone number : ");
        jtfSupplierPhoneNo.setPreferredSize(new java.awt.Dimension(435, 81));

        jtfSupplierEmail.setLabelText("Supplier Email : ");
        jtfSupplierEmail.setPlaceholderText("Enter the supplier's email id : ");
        jtfSupplierEmail.setPreferredSize(new java.awt.Dimension(435, 81));

        jtfSupplierGSTNo.setLabelText("Customer GST NO : ");
        jtfSupplierGSTNo.setPlaceholderText("Enter the supplier's GST NO : ");
        jtfSupplierGSTNo.setPreferredSize(new java.awt.Dimension(435, 81));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtfSupplierAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfSupplierPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jtfSupplierEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(jtfSupplierGSTNo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfSupplierName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSupplierPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addComponent(jtfSupplierAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfSupplierEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSupplierGSTNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
        String name = this.jtfSupplierName.getjTextField().getText();
        String phoneNo = this.jtfSupplierPhoneNo.getjTextField().getText();
        String address = this.jtfSupplierAddress.getjTextField().getText();
        String email = this.jtfSupplierEmail.getjTextField().getText();
        String gstNo = this.jtfSupplierGSTNo.getjTextField().getText();
        String hasGst = "0";

        if(!phoneNo.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "The phone number should be numeric");
            return;
        } else if(phoneNo.length() != 10) {
            JOptionPane.showMessageDialog(this, "The phone number should be of 10 digits");
            return;
        } else if(!UIUtils.verifyEmail(email)) {
            JOptionPane.showMessageDialog(this, "The email is invalid.");
            return;
        } else if(!gstNo.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "The GST number should be numeric");
            return;
        } else if(gstNo.length() != 6) {
            JOptionPane.showMessageDialog(this, "The GST NO should be of 6 digits");
            return;
        }

        if(!gstNo.isEmpty())
        hasGst = "1";

        Supplier supplier = new Supplier();

        ArrayList<String> values = new ArrayList<>();
        values.add(name);
        values.add(address);
        values.add(phoneNo);
        values.add(email);
        values.add(hasGst);
        values.add(gstNo);

        int id = supplier.insert(values);
        if(id != -1) {
            JOptionPane.showMessageDialog(this, "Supplier Added successfully");
        }
    }//GEN-LAST:event_jLabel2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private org.uikit.MaterialJTextField jtfSupplierAddress;
    private org.uikit.MaterialJTextField jtfSupplierEmail;
    private org.uikit.MaterialJTextField jtfSupplierGSTNo;
    private org.uikit.MaterialJTextField jtfSupplierName;
    private org.uikit.MaterialJTextField jtfSupplierPhoneNo;
    // End of variables declaration//GEN-END:variables
}
