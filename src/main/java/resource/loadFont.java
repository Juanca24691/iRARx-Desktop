package resource;

public class loadFont implements interfaces.ILoadFont {

    java.awt.Font font;
    java.io.InputStream loadFonts;

    @Override
    public void loadFonts(String dir, String name, String format, int width) throws showException {
        try {
            this.loadFonts = new java.io.BufferedInputStream(
                    new java.io.FileInputStream(dir + "/" + name + format));
            this.font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, this.loadFonts);
            this.font = this.font.deriveFont(java.awt.Font.PLAIN, width);
        } catch (java.awt.FontFormatException | java.io.IOException ex) {
            ex.printStackTrace(System.out);
            throw new showException("Excepción, No se pudo cargar la fuente requerida(" + this.getClass() + ")\n\n");
        }
    }

    @Override
    public java.awt.Font getFont() {
        return this.font;
    }

    @Override
    public void setFont(java.awt.Font font) {
        this.font = font;
    }

}
