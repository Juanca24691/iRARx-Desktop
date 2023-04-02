package resource;

public class showDialog extends javax.swing.JDialog implements interfaces.IShowDialog {

    @Override
    public String input(boolean type, String message, javax.swing.ImageIcon icon, String[] buttons) throws showException {

        javax.swing.UIManager.put("Panel.background", new javax.swing.plaf.ColorUIResource(240, 242, 245));

// Create an instance of JDialog and set it to be modal
        javax.swing.JDialog dialog = new javax.swing.JDialog(run.main.window, true);

// Create a JPanel to hold the JOptionPane
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

// Create a JOptionPane with the specified message, icon, and buttons
        String input = javax.swing.JOptionPane.showInputDialog(dialog, message);

// Override the maximum characters per line to avoid message wrapping
        javax.swing.JOptionPane JOP = new javax.swing.JOptionPane(input, type ? javax.swing.JOptionPane.PLAIN_MESSAGE : javax.swing.JOptionPane.INFORMATION_MESSAGE, javax.swing.JOptionPane.YES_NO_OPTION, icon, buttons, buttons[0]);

// Add a property change listener to dispose the dialog when a button is clicked
        JOP.addPropertyChangeListener((java.beans.PropertyChangeEvent e) -> {
            if ("value".equals(e.getPropertyName()) && "Aceptar".equals(e.getNewValue())) {
                dialog.dispose();
            }
        });

// Add the JOptionPane to the content panel and set its appearance
        contentPanel.add(JOP, java.awt.BorderLayout.CENTER);
        dialog.add(contentPanel, java.awt.BorderLayout.CENTER);
        dialog.setUndecorated(true);
        dialog.getRootPane().setWindowDecorationStyle(javax.swing.JRootPane.NONE); // remove the border and buttons from the window
        dialog.pack();
        dialog.setLocationRelativeTo(run.main.window);
        dialog.setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, dialog.getWidth(), dialog.getHeight(), 30, 30));

// Add a ComponentListener to the container object to update the position of the JDialog
        run.main.window.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentMoved(java.awt.event.ComponentEvent e) {
                java.awt.Point p = run.main.window.getLocation();
                dialog.setLocation(p.x + (run.main.window.getWidth() - dialog.getWidth()) / 2, p.y + (run.main.window.getHeight() - dialog.getHeight()) / 2);
            }
        });

// Show the JDialog as a modal dialog
        dialog.setVisible(true);
        return null;

    }

    @Override
    public void message(boolean type, String message, javax.swing.ImageIcon icon, String[] buttons) throws showException {
        javax.swing.UIManager.put("Panel.background", new javax.swing.plaf.ColorUIResource(240, 242, 245));

        // Create an instance of JDialog and set it to be modal
        javax.swing.JDialog dialog = new javax.swing.JDialog(run.main.window, true);

        // Create a JPanel to hold the JOptionPane
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Create a JOptionPane with the specified message, icon, and buttons
        javax.swing.JOptionPane JOP = new javax.swing.JOptionPane(message, type ? javax.swing.JOptionPane.PLAIN_MESSAGE : javax.swing.JOptionPane.INFORMATION_MESSAGE, javax.swing.JOptionPane.YES_NO_OPTION, icon, buttons, buttons[0]);

        // Override the maximum characters per line to avoid message wrapping
        JOP.setUI(new javax.swing.plaf.basic.BasicOptionPaneUI() {
            @Override
            protected int getMaxCharactersPerLineCount() {
                return Integer.MAX_VALUE;
            }
        });

        // Add a property change listener to dispose the dialog when a button is clicked
        JOP.addPropertyChangeListener((java.beans.PropertyChangeEvent e) -> {
            if ("value".equals(e.getPropertyName()) && "Aceptar".equals(e.getNewValue())) {
                dialog.dispose();
            }
        });

        // Add the JOptionPane to the content panel and set its appearance
        contentPanel.add(JOP, java.awt.BorderLayout.CENTER);
        dialog.add(contentPanel, java.awt.BorderLayout.CENTER);
        dialog.setUndecorated(true);
        dialog.getRootPane().setWindowDecorationStyle(javax.swing.JRootPane.NONE); // remove the border and buttons from the window
        dialog.pack();
        dialog.setLocationRelativeTo(run.main.window);
        dialog.setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, dialog.getWidth(), dialog.getHeight(), 30, 30));

        // Add a ComponentListener to the container object to update the position of the JDialog
        run.main.window.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentMoved(java.awt.event.ComponentEvent e) {
                java.awt.Point p = run.main.window.getLocation();
                dialog.setLocation(p.x + (run.main.window.getWidth() - dialog.getWidth()) / 2, p.y + (run.main.window.getHeight() - dialog.getHeight()) / 2);
            }
        });

        // Show the JDialog as a modal dialog
        dialog.setVisible(true);
    }
}
