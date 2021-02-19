
package todphod.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import org.uikit.MaterialJTextField;

public class UIUtils {
    public static void configureTextField(MaterialJTextField materialJTextField) {
        JSeparator jSeparator = materialJTextField.getjSeparator();
        JTextField jTextField = materialJTextField.getjTextField();
        int width = (int) materialJTextField.getPreferredSize().getWidth();
        System.out.println("width = " + width);
        System.out.println("materialJTextField.getWidth() = " + materialJTextField.getWidth());
        jSeparator.setPreferredSize(new Dimension(width, jSeparator.getHeight()));
        jTextField.setPreferredSize(new Dimension(width, jTextField.getHeight()));
    }
    
    public static boolean verifyEmail(String email) {
    	String emailPatternString = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-\\+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    	Pattern emailPattern = Pattern.compile(emailPatternString);
    	Matcher emailMatcher = emailPattern.matcher(email);
        return emailMatcher.matches();
    }
    
    public static void styleTextField(final JTextField jTextField, final JSeparator jSeparator, final String placeholder, final Color color, final Color activeColor) {
        jTextField.setText(placeholder);
        jTextField.setCaretColor(activeColor);
        jTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(jTextField.getText().equals(placeholder))  {
                    jTextField.setText("");
                    jSeparator.setBackground(activeColor);
                    jSeparator.setForeground(activeColor);
                    jTextField.setForeground(activeColor);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(jTextField.getText().equals("")) {
                    jTextField.setText(placeholder);
                    jSeparator.setBackground(color);
                    jSeparator.setForeground(color);
                    jTextField.setForeground(color);
                }
            }
        });
    }
    
    
    public static void setIcon(JLabel jLabel, String name) {
        jLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/buttons/" + name + "_hover.png")));
            }
            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                jLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vendor/images/buttons/" + name + ".png")));
            }
        });
    }
}
