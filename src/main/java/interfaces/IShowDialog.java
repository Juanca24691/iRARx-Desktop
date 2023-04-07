package interfaces;

public interface IShowDialog {

    void notify(javax.swing.ImageIcon icon, String message, String button);

    Boolean confirmation(javax.swing.ImageIcon icon, String message, String[] buttons);

    String input(javax.swing.ImageIcon icon, String message, String[] buttons);

    void roundedEdges(javax.swing.JFrame parent, Boolean modal, javax.swing.JDialog dialog, javax.swing.JOptionPane JOP);

}