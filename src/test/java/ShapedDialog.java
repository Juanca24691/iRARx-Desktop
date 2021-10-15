
//import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ShapedDialog extends JDialog {

    // La forma de nuestro dialogo
    Shape dialogShape;

    public ShapedDialog() {
        super();
        /* Con esta instruccion eliminamos la barra superior y los botones de
         * minimizar, maximizar y cerrar.
         */
        this.setUndecorated(true);
        // Esta orden centra el dialogo en la pantalla
        this.setLocationRelativeTo(null);
    }

    /**
     * Establece la forma de la ventana.
     * @param shape
     */
    public void setShape(Shape shape) {
        this.dialogShape = shape;
        /* Imprescindible para mostrar el diálogo, hasta que no hagamos esto,
         * la ventana permanece invisible
         */
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {

        // Pintamos todo el contenido
        super.paint(g);
        this.setShape(new RoundRectangle2D.Double(0, 0, 500, 600, 80, 80));
        // Establecemos la forma de la ventana
        //AWTUtilities.setWindowShape(this, dialogShape);

    }

}