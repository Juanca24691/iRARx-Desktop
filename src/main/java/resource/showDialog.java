package resource;

import run.main;

public class showDialog extends javax.swing.JDialog implements interfaces.IShowDialog {

    private Boolean confirmationStatus = null;

    @Override
    public void notify(javax.swing.ImageIcon icon, String message, String button) throws showException {

        // Create an instance of JDialog and set it to be modal
        javax.swing.JDialog dialog = new javax.swing.JDialog(main.window, true);

        // Create a JOptionPane with the specified message, icon, and buttons
        javax.swing.JOptionPane JOP = new javax.swing.JOptionPane(message, javax.swing.JOptionPane.INFORMATION_MESSAGE, javax.swing.JOptionPane.YES_NO_OPTION, icon, new String[]{button});

        // Add a property change listener to dispose the dialog when a button is clicked
        JOP.addPropertyChangeListener((java.beans.PropertyChangeEvent e) -> {
            if(dialog.isVisible() && JOP.isVisible() && e.getSource() == JOP && button.equals(e.getNewValue())) {
                dialog.dispose();
            }
        });

        // Customize dialog
        this.roundedEdges(main.window, true, dialog, JOP);
    }

    @Override
    public Boolean confirmation(javax.swing.ImageIcon icon, String message, String[] buttons) {

        // Create an instance of JDialog and set it to be modal
        javax.swing.JDialog dialog = new javax.swing.JDialog(main.window, true);

        // Create a JOptionPane with the specified message, icon, and buttons
        javax.swing.JOptionPane JOP = new javax.swing.JOptionPane(message, javax.swing.JOptionPane.INFORMATION_MESSAGE, javax.swing.JOptionPane.YES_NO_OPTION, icon, buttons);

        // Add a property change listener to dispose the dialog when a button is clicked
        JOP.addPropertyChangeListener((java.beans.PropertyChangeEvent e) -> {
            if(dialog.isVisible() && JOP.isVisible() && e.getSource() == JOP) {
                if (buttons[0].equals(e.getNewValue())) {
                    this.confirmationStatus = true;
                    dialog.dispose();
                } else {
                    this.confirmationStatus = false;
                    dialog.dispose();
                }
            }
        });

        // Customize dialog
        this.roundedEdges(main.window, true, dialog, JOP);
        return this.confirmationStatus;
    }

    @Override
    public String input(javax.swing.ImageIcon icon, String message, String[] buttons) {
        return null;
    }

    @Override
    public void roundedEdges(javax.swing.JFrame parent, Boolean modal, javax.swing.JDialog dialog, javax.swing.JOptionPane JOP) throws showException {

        javax.swing.UIManager.put("Panel.background", new javax.swing.plaf.ColorUIResource(240, 242, 245));

        // Override the maximum characters per line to avoid message wrapping
        JOP.setUI(new javax.swing.plaf.basic.BasicOptionPaneUI() {
            @Override
            protected int getMaxCharactersPerLineCount() {
                return Integer.MAX_VALUE;
            }
        });

        // Create a JPanel to hold the JOptionPane
        javax.swing.JPanel contentPanel = new javax.swing.JPanel();
        contentPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Add the JOptionPane to the content panel and set its appearance
        contentPanel.add(JOP, java.awt.BorderLayout.CENTER);
        dialog.add(contentPanel, java.awt.BorderLayout.CENTER);
        dialog.setUndecorated(true);
        dialog.getRootPane().setWindowDecorationStyle(javax.swing.JRootPane.NONE); // remove the border and buttons from the window
        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.setShape(new java.awt.geom.RoundRectangle2D.Double(0, 0, dialog.getWidth(), dialog.getHeight(), 30, 30));

        // Add a ComponentListener to the container object to update the position of the JDialog
        parent.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentMoved(java.awt.event.ComponentEvent e) {
                java.awt.Point p = parent.getLocation();
                dialog.setLocation(p.x + (parent.getWidth() - dialog.getWidth()) / 2, p.y + (parent.getHeight() - dialog.getHeight()) / 2);
            }
        });

        // Show the JDialog as a modal dialog
        dialog.setVisible(true);
    }
}