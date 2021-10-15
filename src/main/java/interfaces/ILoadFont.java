package interfaces;

public interface ILoadFont {
    
    void loadFonts(String dir, String name, String format, int width) throws resource.showException;

    java.awt.Font getFont();
    
    void setFont(java.awt.Font font);
}
