package components;

public class buttons extends javax.swing.JButton{

    public javax.swing.JButton imageButton(javax.swing.ImageIcon icon, String text, int x, int y, int width, int height, Boolean visible, Boolean enabled) {
        buttons imageButton = new buttons();
        imageButton.setIcon(icon);
        imageButton.setToolTipText(text);
        imageButton.setBounds(x, y, width, height);
        imageButton.setBackground(null);
        imageButton.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        imageButton.setBorder(null);
        imageButton.setBorderPainted(false);
        imageButton.setContentAreaFilled(false);
        imageButton.setVisible(visible);
        imageButton.setEnabled(enabled);
        return imageButton;
    }
}
