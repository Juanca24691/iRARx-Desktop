package run;

import javax.swing.UIManager;
import resource.explorer;
import resource.extractResource;
import resource.loadFont;
import resource.showException;
import managerDatabase.connectDatabase;

public class main extends javax.swing.JFrame {

    // Object
    public static final main window = new main();

    private final explorer OExplorer = new explorer();
    private final loadFont OLoadFont = new loadFont();
    private final extractResource OExtractResource = new extractResource();
    private final connectDatabase connection = new connectDatabase();

    // Var
    public static int depure;

    public main() {
        
        connection.connect("localhost", 3306, "irarx", "root", "admin012345");

        main.depure = 1;

        try {
            // Font title
            this.OLoadFont.loadFonts(System.getProperty("user.dir") + "/" + "container" + "/" + "fonts", "Pacifico-Regular", ".ttf", 75);
        } catch (showException ex) {
            ex.getMessage();
        }

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroumd = new javax.swing.JPanel();
        buttonOpenDir = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        buttonExtractOne = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonChangeLanguage = new javax.swing.JButton();
        buttonExtract = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroumd.setBackground(new java.awt.Color(255, 255, 255));

        buttonOpenDir.setToolTipText("Abrir recurso");
        buttonOpenDir.setIcon(new javax.swing.ImageIcon("/Users/juanca24691/NetBeansProjects/iRARx/container/images/openDir.png")); // NOI18N
        buttonOpenDir.setBorder(null);

        title.setFont(this.OLoadFont.getFont()
        );
        title.setText(connection.get("name", "config", "string", 1));

        buttonExtractOne.setToolTipText("Seleccionar un recurso");
        buttonExtractOne.setIcon(new javax.swing.ImageIcon("/Users/juanca24691/NetBeansProjects/iRARx/container/images/import.gif")); // NOI18N
        buttonExtractOne.setBorder(null);
        buttonExtractOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExtractOneActionPerformed(evt);
            }
        });

        buttonDelete.setToolTipText("Remover recurso");
        buttonDelete.setIcon(new javax.swing.ImageIcon("/Users/juanca24691/NetBeansProjects/iRARx/container/images/delete.png")); // NOI18N
        buttonDelete.setBorder(null);

        buttonChangeLanguage.setToolTipText("Cambiar idioma");
        buttonChangeLanguage.setIcon(new javax.swing.ImageIcon("/Users/juanca24691/NetBeansProjects/iRARx/container/images/spanish.png")); // NOI18N
        buttonChangeLanguage.setBorder(null);

        buttonExtract.setToolTipText("Extraer recurso");
        buttonExtract.setIcon(new javax.swing.ImageIcon("/Users/juanca24691/NetBeansProjects/iRARx/container/images/extract.png")); // NOI18N
        buttonExtract.setBorder(null);
        buttonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExtractActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroumdLayout = new javax.swing.GroupLayout(backgroumd);
        backgroumd.setLayout(backgroumdLayout);
        backgroumdLayout.setHorizontalGroup(
            backgroumdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroumdLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(backgroumdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroumdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroumdLayout.createSequentialGroup()
                            .addComponent(buttonExtract)
                            .addGap(49, 49, 49)
                            .addComponent(buttonDelete)
                            .addGap(46, 46, 46)
                            .addComponent(buttonOpenDir)
                            .addGap(47, 47, 47)
                            .addComponent(buttonChangeLanguage))
                        .addGroup(backgroumdLayout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(buttonExtractOne))))
                .addContainerGap(216, Short.MAX_VALUE))
        );
        backgroumdLayout.setVerticalGroup(
            backgroumdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroumdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(buttonExtractOne)
                .addGap(45, 45, 45)
                .addGroup(backgroumdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonExtract)
                    .addComponent(buttonDelete)
                    .addComponent(buttonOpenDir)
                    .addComponent(buttonChangeLanguage))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroumd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroumd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExtractOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExtractOneActionPerformed
        try {
            this.OExplorer.openExplorer();
        } catch (showException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_buttonExtractOneActionPerformed

    private void buttonExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExtractActionPerformed
        try {
            this.OExtractResource.commandResource();
        } catch (showException ex) {
            ex.getMessage();
        }
    }//GEN-LAST:event_buttonExtractActionPerformed

    static {
        System.setProperty("apple.awt.application.name", "iRARx");
    }

    public static void main(String args[]) throws showException {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("mac") || System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
                javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } else {
                System.exit(0);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(System.out);
            throw new showException("Excepción, No se pudo establecer el look de la aplicacón");
        }

        java.awt.EventQueue.invokeLater(() -> {
            new main().setVisible(true);
            main.window.setLocationRelativeTo(window);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroumd;
    private javax.swing.JButton buttonChangeLanguage;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonExtract;
    private javax.swing.JButton buttonExtractOne;
    private javax.swing.JButton buttonOpenDir;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
