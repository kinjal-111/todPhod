
package todphod.ui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class ItemList extends JScrollPane {
    private JPanel jpContainer;
    private List<JComponent> listItems;
    private int width;
    
    public ItemList(List<JComponent> listItems, int width) {
        this.listItems = listItems;
        this.width = width;
        this.jpContainer = new JPanel();
        super.setLayout(null);
        this.jpContainer.setLayout(null);
        this.setBackground(new Color(255, 255, 255));
        this.jpContainer.setBackground(this.getBackground());
        this.jpContainer.setBounds(0, 0, width, 0);
        this.jpContainer.setVisible(true);
        this.jpContainer.setPreferredSize(new Dimension(690, 0));
        this.add(jpContainer);
        
        this.addAll(listItems);
    }
    
    public ItemList(int width) {
        this(new ArrayList<>(), width);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
    
    
    public void removeAll() {
        for(int i=0;i<this.listItems.size(); i++) {
            this.removeItemAt(i);
        }
    }
    
    public void addAll(List<JComponent> jComponents) {
        // Adding all the items to the pane
        for(JComponent component : this.listItems) {
            this.addItem(component);
        }
    }
    
    public void refresh(List<JComponent> jComponents) {
        this.removeAll();
        this.addAll(jComponents);
    }
    
    public void addItem(JComponent component) throws IllegalArgumentException {
        this.jpContainer.add(component);
        component.setVisible(true);
        component.setLocation(new Point(0, jpContainer.getHeight()));
        this.jpContainer.setSize(jpContainer.getWidth(), jpContainer.getHeight() + component.getHeight());
        this.jpContainer.setPreferredSize(new Dimension(jpContainer.getWidth(), jpContainer.getHeight()));
        this.setSize(965, 550);
        this.setPreferredSize(new Dimension(965, 550));
        System.out.println("jpContainer.getPreferredSize() = " + jpContainer.getPreferredSize());
        System.out.println("this.getPreferredSize() = " + this.getPreferredSize());
    }
    
    public JComponent removeItemAt(int index) {
        JComponent component = this.listItems.remove(index);
        this.jpContainer.setSize(this.jpContainer.getWidth(), jpContainer.getHeight() - component.getHeight());
        this.jpContainer.setPreferredSize(new Dimension(this.jpContainer.getWidth(), jpContainer.getHeight() - component.getHeight()));
        this.validate();
        this.updateUI();
        this.jpContainer.validate();
        this.jpContainer.updateUI();
        
        return component;
    }
}
