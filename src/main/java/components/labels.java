package components;

public class labels extends javax.swing.JLabel {

    public javax.swing.JLabel label(java.awt.Font font, String text, java.awt.Color color, int x, int y, int width, int height) {
        labels label = new labels();
        label.setFont(font);
        label.setText(text);
        label.setToolTipText(text);
        label.setForeground(color);
        label.setBounds(x, y, width, height);
        return label;
    }
}
