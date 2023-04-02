package interfaces;

public interface IShowDialog {

    String input(boolean type, String message, javax.swing.ImageIcon icon, String[] buttons) throws resource.showException;

    void message(boolean type, String message, javax.swing.ImageIcon icon, String[] buttons) throws resource.showException;
}
