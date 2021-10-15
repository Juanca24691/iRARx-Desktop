package resource;

public class showDialog extends javax.swing.JDialog implements interfaces.IShowDialog {

    @Override
    public void message(String message, String image, String[] buttons) throws showException {
        javax.swing.UIManager UI = new javax.swing.UIManager();
        UI.put("Panel.background", new javax.swing.plaf.ColorUIResource(240,242,245));
        javax.swing.JDialog dialog = new javax.swing.JDialog(run.index.window, true);
        javax.swing.JOptionPane JOP = new javax.swing.JOptionPane(message, javax.swing.JOptionPane.INFORMATION_MESSAGE, javax.swing.JOptionPane.YES_NO_OPTION, new javax.swing.ImageIcon(image), buttons, buttons[0]);

        JOP.addPropertyChangeListener((java.beans.PropertyChangeEvent e) -> {
            String buttonClick = e.getPropertyName();
            if ("value".equals(buttonClick)) {

                dialog.dispose();

            }
        });


        dialog.setUndecorated(true);
        dialog.setLayout(new java.awt.BorderLayout());
        dialog.add(JOP);
        dialog.pack();
        dialog.setLocationRelativeTo(run.index.window);
        dialog.setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, dialog.getWidth(), dialog.getHeight(), 30, 30));
        JOP.setBackground(new javax.swing.plaf.ColorUIResource(240,242,245));
        dialog.setVisible(true);
    }
}
