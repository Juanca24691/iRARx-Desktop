package tools;

import src.showException;

public class fonts {

    public java.awt.Font load(String dir, String name, String format, int height) throws showException {

        java.awt.Font font;

        try {
            java.io.InputStream loadFonts = new java.io.BufferedInputStream(new java.io.FileInputStream(dir + "/" + name + format));
            font = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, loadFonts);
            font = font.deriveFont(java.awt.Font.PLAIN, height);
        } catch (java.awt.FontFormatException | java.io.IOException ex) {
            ex.printStackTrace(System.out);
            throw new showException("(Exception): Failed to load required font. class name: " + this.getClass());
        }
        return font;
    }
}