
package todphod.ui;

import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import todphod.ui.pages.AddCategory;
import todphod.ui.pages.AddCustomer;
import todphod.ui.pages.AddProduct;
import todphod.ui.pages.AddSupplier;
import todphod.ui.pages.DisplayReports;
import todphod.ui.pages.ManageCategories;
import todphod.ui.pages.ManageCustomers;
import todphod.ui.pages.ManageOrders;
import todphod.ui.pages.ManageProducts;
import todphod.ui.pages.ManagePurchases;
import todphod.ui.pages.ManageSuppliers;
import todphod.ui.pages.PlaceOrder;
import todphod.ui.pages.PurchaseProduct;
import todphod.utilities.TOClient;

/**
 *
 * @author gauravpunjabi
 */
public class DashboardFrame extends javax.swing.JFrame {
    private static final int WIDTH = 1336;
    private static final int HEIGHT = 800;
    
    private JPanel currentPage;
    /**
     * Creates new form DashboardFrame
     */
    public DashboardFrame() {
        initComponents();
        this.setSize(WIDTH, HEIGHT);
        this.getContentPane().setBackground(Color.white);
        this.setShape(new RoundRectangle2D.Double(0,0,WIDTH, HEIGHT,20,20));
        this.setLocationRelativeTo(null);        
//        this.setMainPanel(new ManageCustomers(this));
    }
    
    public void setMainPanel(JPanel jPanel) {
        this.jpPageContainer.removeAll();
        
        this.currentPage = jPanel;
        currentPage.setBounds(0, 0, 1090, 750);
        
        this.jpPageContainer.add(this.currentPage);
        
        this.validate();
        this.jpPageContainer.validate();
        this.jpPageContainer.updateUI();;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainContainer = new javax.swing.JPanel();
        jlDashboard = new javax.swing.JLabel();
        jlProducts = new javax.swing.JLabel();
        jlManageProducts = new javax.swing.JLabel();
        jlAddProduct = new javax.swing.JLabel();
        jlCustomer = new javax.swing.JLabel();
        jlAddCustomer = new javax.swing.JLabel();
        jlManageCustomers = new javax.swing.JLabel();
        jlSupplier = new javax.swing.JLabel();
        jlAddSupplier = new javax.swing.JLabel();
        jlManagerSuppliers = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jlOrder = new javax.swing.JLabel();
        jlAddOrder = new javax.swing.JLabel();
        jlManageOrders = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jlReports = new javax.swing.JLabel();
        jlSidebaar = new javax.swing.JLabel();
        jlHeader = new javax.swing.JLabel();
        jpPageContainer = new javax.swing.JPanel();
        pnlCharts = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainContainer.setBackground(new java.awt.Color(255, 255, 255));
        mainContainer.setLayout(null);

        jlDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/dashboard_hover.png"))); // NOI18N
        jlDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlDashboardMouseExited(evt);
            }
        });
        mainContainer.add(jlDashboard);
        jlDashboard.setBounds(20, 60, 230, 50);

        jlProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/products_hover.png"))); // NOI18N
        jlProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlProductsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlProductsMousePressed(evt);
            }
        });
        mainContainer.add(jlProducts);
        jlProducts.setBounds(20, 110, 230, 60);

        jlManageProducts.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlManageProducts.setForeground(new java.awt.Color(255, 255, 255));
        jlManageProducts.setText("Manage Products");
        jlManageProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlManageProductsMousePressed(evt);
            }
        });
        mainContainer.add(jlManageProducts);
        jlManageProducts.setBounds(50, 200, 200, 50);

        jlAddProduct.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        jlAddProduct.setText("Add Product");
        jlAddProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAddProductMousePressed(evt);
            }
        });
        mainContainer.add(jlAddProduct);
        jlAddProduct.setBounds(50, 160, 200, 50);

        jlCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/customer_hover.png"))); // NOI18N
        jlCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlCustomerMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlCustomerMousePressed(evt);
            }
        });
        mainContainer.add(jlCustomer);
        jlCustomer.setBounds(20, 250, 230, 50);

        jlAddCustomer.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlAddCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jlAddCustomer.setText("Add Customer");
        jlAddCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAddCustomerMousePressed(evt);
            }
        });
        mainContainer.add(jlAddCustomer);
        jlAddCustomer.setBounds(60, 290, 190, 50);

        jlManageCustomers.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlManageCustomers.setForeground(new java.awt.Color(255, 255, 255));
        jlManageCustomers.setText("Manage Customers");
        jlManageCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlManageCustomersMousePressed(evt);
            }
        });
        mainContainer.add(jlManageCustomers);
        jlManageCustomers.setBounds(60, 330, 190, 50);

        jlSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/supplier_hover.png"))); // NOI18N
        jlSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlSupplierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlSupplierMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlSupplierMousePressed(evt);
            }
        });
        mainContainer.add(jlSupplier);
        jlSupplier.setBounds(20, 380, 230, 50);

        jlAddSupplier.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlAddSupplier.setForeground(new java.awt.Color(255, 255, 255));
        jlAddSupplier.setText("Add Supplier");
        jlAddSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAddSupplierMousePressed(evt);
            }
        });
        mainContainer.add(jlAddSupplier);
        jlAddSupplier.setBounds(60, 420, 190, 50);

        jlManagerSuppliers.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlManagerSuppliers.setForeground(new java.awt.Color(255, 255, 255));
        jlManagerSuppliers.setText("Manage Suppliers");
        jlManagerSuppliers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlManagerSuppliersMousePressed(evt);
            }
        });
        mainContainer.add(jlManagerSuppliers);
        jlManagerSuppliers.setBounds(60, 460, 190, 50);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/close.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        mainContainer.add(jLabel20);
        jLabel20.setBounds(1295, 13, 24, 24);

        jlOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/order_hover.png"))); // NOI18N
        jlOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlOrderMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlOrderMousePressed(evt);
            }
        });
        mainContainer.add(jlOrder);
        jlOrder.setBounds(20, 520, 230, 50);

        jlAddOrder.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlAddOrder.setForeground(new java.awt.Color(255, 255, 255));
        jlAddOrder.setText("Add Order");
        jlAddOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlAddOrderMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jlAddOrderMouseReleased(evt);
            }
        });
        mainContainer.add(jlAddOrder);
        jlAddOrder.setBounds(60, 560, 190, 50);

        jlManageOrders.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jlManageOrders.setForeground(new java.awt.Color(255, 255, 255));
        jlManageOrders.setText("Manage Orders");
        jlManageOrders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlManageOrdersMousePressed(evt);
            }
        });
        mainContainer.add(jlManageOrders);
        jlManageOrders.setBounds(60, 600, 190, 50);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/logo.png"))); // NOI18N
        mainContainer.add(jLabel19);
        jLabel19.setBounds(5, 15, 240, 40);

        jlReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/reports_hover.png"))); // NOI18N
        jlReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlReportsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlReportsMousePressed(evt);
            }
        });
        mainContainer.add(jlReports);
        jlReports.setBounds(20, 660, 230, 50);

        jlSidebaar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/Facebook Messenger.jpg"))); // NOI18N
        mainContainer.add(jlSidebaar);
        jlSidebaar.setBounds(0, 0, 250, 800);

        jlHeader.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/Facebook Messenger.jpg"))); // NOI18N
        jlHeader.setText("jLabel2");
        mainContainer.add(jlHeader);
        jlHeader.setBounds(0, 0, 1340, 50);

        jpPageContainer.setBackground(new java.awt.Color(255, 255, 255));

        pnlCharts.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/dashboard/graph.png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/dashboard/trending.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/dashboard/pie.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/dashboard/eoq.png"))); // NOI18N

        javax.swing.GroupLayout pnlChartsLayout = new javax.swing.GroupLayout(pnlCharts);
        pnlCharts.setLayout(pnlChartsLayout);
        pnlChartsLayout.setHorizontalGroup(
            pnlChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChartsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(17, 17, 17)
                .addGroup(pnlChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChartsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlChartsLayout.setVerticalGroup(
            pnlChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChartsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlChartsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPageContainerLayout = new javax.swing.GroupLayout(jpPageContainer);
        jpPageContainer.setLayout(jpPageContainerLayout);
        jpPageContainerLayout.setHorizontalGroup(
            jpPageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCharts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpPageContainerLayout.setVerticalGroup(
            jpPageContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCharts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        mainContainer.add(jpPageContainer);
        jpPageContainer.setBounds(250, 50, 1090, 750);

        getContentPane().add(mainContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, 1336, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductsMousePressed
        this.setMainPanel(new AddProduct());
    }//GEN-LAST:event_jlProductsMousePressed

    private void jlManageProductsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlManageProductsMousePressed
        this.setMainPanel(new ManageProducts(this));
    }//GEN-LAST:event_jlManageProductsMousePressed

    private void jlAddProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddProductMousePressed
        this.setMainPanel(new AddProduct());
    }//GEN-LAST:event_jlAddProductMousePressed

    private void jlCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCustomerMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlCustomerMousePressed

    private void jlAddCustomerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddCustomerMousePressed
        this.setMainPanel(new AddCustomer());
    }//GEN-LAST:event_jlAddCustomerMousePressed

    private void jlManageCustomersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlManageCustomersMousePressed
        this.setMainPanel(new ManageCustomers(this));
    }//GEN-LAST:event_jlManageCustomersMousePressed

    private void jlSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSupplierMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlSupplierMousePressed

    private void jlAddSupplierMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddSupplierMousePressed
        this.setMainPanel(new AddSupplier());
    }//GEN-LAST:event_jlAddSupplierMousePressed

    private void jlManagerSuppliersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlManagerSuppliersMousePressed
        this.setMainPanel(new ManageSuppliers(this));
    }//GEN-LAST:event_jlManagerSuppliersMousePressed

    private void jlOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlOrderMousePressed
        
    }//GEN-LAST:event_jlOrderMousePressed

    private void jlAddOrderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddOrderMousePressed
        this.setMainPanel(new PlaceOrder());
    }//GEN-LAST:event_jlAddOrderMousePressed

    private void jlManageOrdersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlManageOrdersMousePressed
        this.setMainPanel(new ManageOrders());
    }//GEN-LAST:event_jlManageOrdersMousePressed

    private void jlReportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlReportsMousePressed
        // TODO add your handling code here:
        this.setMainPanel(new DisplayReports());
    }//GEN-LAST:event_jlReportsMousePressed

    private void jlAddOrderMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlAddOrderMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jlAddOrderMouseReleased

    private void jlDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlDashboardMouseEntered
        // TODO add your handling code here:
        jlDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/dashboard.png")));
    }//GEN-LAST:event_jlDashboardMouseEntered

    private void jlDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlDashboardMouseExited
        // TODO add your handling code here:
        jlDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/dashboard_hover.png")));
    }//GEN-LAST:event_jlDashboardMouseExited

    private void jlProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductsMouseEntered
    // TODO add your handling code here:
        jlProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/products.png"))); 
    }//GEN-LAST:event_jlProductsMouseEntered

    private void jlProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlProductsMouseExited
        // TODO add your handling code here:
        jlProducts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/products_hover.png")));
    }//GEN-LAST:event_jlProductsMouseExited

    private void jlCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCustomerMouseEntered
        // TODO add your handling code here:
        jlCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/customer.png"))); 
    }//GEN-LAST:event_jlCustomerMouseEntered

    private void jlCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCustomerMouseExited
        // TODO add your handling code here:
        jlCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/customer_hover.png"))); 
    }//GEN-LAST:event_jlCustomerMouseExited

    private void jlSupplierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSupplierMouseEntered
        // TODO add your handling code here:
        jlSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/supplier.png"))); 
    }//GEN-LAST:event_jlSupplierMouseEntered

    private void jlSupplierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSupplierMouseExited
        // TODO add your handling code here:
        jlSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/supplier_hover.png"))); 
    }//GEN-LAST:event_jlSupplierMouseExited

    private void jlOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlOrderMouseEntered
        // TODO add your handling code here:
        jlOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/order.png"))); 
    }//GEN-LAST:event_jlOrderMouseEntered

    private void jlOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlOrderMouseExited
        // TODO add your handling code here:
        jlOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/order_hover.png"))); 
    }//GEN-LAST:event_jlOrderMouseExited

    private void jlReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlReportsMouseEntered
        // TODO add your handling code here:
        jlReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/reports.png"))); 
    }//GEN-LAST:event_jlReportsMouseEntered

    private void jlReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlReportsMouseExited
        // TODO add your handling code here:
        jlReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/sidebar/reports_hover.png"))); 
    }//GEN-LAST:event_jlReportsMouseExited

    private void jlDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlDashboardMouseClicked
        // TODO add your handling code here:
        this.setMainPanel(pnlCharts);
    }//GEN-LAST:event_jlDashboardMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel20MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jlAddCustomer;
    private javax.swing.JLabel jlAddOrder;
    private javax.swing.JLabel jlAddProduct;
    private javax.swing.JLabel jlAddSupplier;
    private javax.swing.JLabel jlCustomer;
    private javax.swing.JLabel jlDashboard;
    private javax.swing.JLabel jlHeader;
    private javax.swing.JLabel jlManageCustomers;
    private javax.swing.JLabel jlManageOrders;
    private javax.swing.JLabel jlManageProducts;
    private javax.swing.JLabel jlManagerSuppliers;
    private javax.swing.JLabel jlOrder;
    private javax.swing.JLabel jlProducts;
    private javax.swing.JLabel jlReports;
    private javax.swing.JLabel jlSidebaar;
    private javax.swing.JLabel jlSupplier;
    private javax.swing.JPanel jpPageContainer;
    private javax.swing.JPanel mainContainer;
    private javax.swing.JPanel pnlCharts;
    // End of variables declaration//GEN-END:variables
}
