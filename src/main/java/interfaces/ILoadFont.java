package interfaces;

import java.awt.Font;
import resource.showException;

public interface ILoadFont {
    
    void loadFonts(String dir, String name, String format, int width) throws showException;
    
    Font getFont();
    
    void setFont(Font font);
}
