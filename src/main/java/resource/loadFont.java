package resource;

import interfaces.ILoadFont;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class loadFont implements ILoadFont {

    Font font;
    InputStream loadFonts;

    @Override
    public void loadFonts(String dir, String name, String format, int width) throws showException {
        try {
            this.loadFonts = new BufferedInputStream(
                    new FileInputStream(dir + "/" + name + format));
            this.font = Font.createFont(Font.TRUETYPE_FONT, this.loadFonts);
            this.font = this.font.deriveFont(Font.PLAIN, width);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace(System.out);
            throw new showException("Excepción, No se pudo cargar la fuente requerida(" + this.getClass() + ")\n\n");
        }
    }

    @Override
    public Font getFont() {
        return this.font;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

}
