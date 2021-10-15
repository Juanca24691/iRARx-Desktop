import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Ejemplos de dialogos");

        final ShapedDialog dialog = new ShapedDialog();
        // Este sera el contenido de nuestro dialogo
        JPanel dialogContent = new JPanel(new BorderLayout());
        dialogContent.add(new JLabel("Interior del dialogo", JLabel.CENTER), BorderLayout.CENTER);

        // Dado que eliminamos el boton de cerrar el dialogo, tendremos que añadirle un boton para ello
        JButton close = new JButton(new AbstractAction("Cerrar") {

            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialogContent.add(close, BorderLayout.SOUTH);


        dialog.setContentPane(dialogContent);
        dialog.setSize(400, 200);

        JButton openDialog = new JButton();
        openDialog.setAction(new AbstractAction("Dialogo redondo") {

            @Override
            public void actionPerformed(ActionEvent e) {
                Shape oval = new Ellipse2D.Float(0, 0, 400, 200);
                dialog.setShape(oval);
            }
        });
        JButton openDialog2 = new JButton();
        openDialog2.setAction(new AbstractAction("Dialogo bordes redondeado") {

            @Override
            public void actionPerformed(ActionEvent e) {
                Shape roundRectangle = new RoundRectangle2D.Float(0, 0, 400, 200, 20, 20);
                dialog.setShape(roundRectangle);
            }
        });

        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(openDialog);
        frame.getContentPane().add(openDialog2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 150);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}