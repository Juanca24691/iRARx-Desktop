package run;

public class index extends javax.swing.JFrame{

    static { System.setProperty("apple.awt.application.name", "iRARx"); }

    private index(){
        this.initComponents();
    }

    private void initComponents(){
        setLayout(null);

        // Icono de aplicación
        if (System.getProperty("os.name").toLowerCase().contains("mac") || System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {

            // Posicionar la barra de menus arriba
            System.setProperty("apple.laf.useScreenMenuBar", "true");

            // Carga la imagen para el icono de la aplicación
            java.awt.Toolkit herramientas = java.awt.Toolkit.getDefaultToolkit();
            java.awt.Image icono = herramientas.getImage(System.getProperty("user.dir") + "/container/images/icon.png");
            java.awt.Taskbar dock = java.awt.Taskbar.getTaskbar(); // Nuevo código des pues de JDK 9

            try {
                // Establecer icono para macOS (y otros sistemas que admiten este método)
                dock.setIconImage(icono);
            } catch (UnsupportedOperationException | SecurityException e) {
                e.printStackTrace(System.out);
            }
        }

        // Label
        this.OLoadFont.loadFonts(System.getProperty("user.dir") + "/container/fonts", "Pacifico-Regular", ".ttf", 75);
        this.labelTitle.setText("iRARx");
        this.labelTitle.setFont(this.OLoadFont.getFont());
        this.labelTitle.setForeground(new java.awt.Color(32, 32, 34));
        this.labelTitle.setBounds(235, 65, 260, 65);
        this.add(labelTitle);

        // Button buttonExtractExplorer
        this.buttonExtractExplorer.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/import.gif"));
        this.buttonExtractExplorer.setToolTipText("Abrir recurso");
        this.buttonExtractExplorer.setBounds(255, 150, 200, 200);
        this.buttonExtractExplorer.setBackground(null);
        this.buttonExtractExplorer.setVisible(true);
        this.buttonExtractExplorer.setBorder(null);
        this.add(buttonExtractExplorer);

        // Event buttonExtractExplorer
        this.buttonExtractExplorer.addActionListener(e -> OExplorer.openExplorer());

        // Button buttonExtract
        this.buttonExtract.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/extract.png"));
        this.buttonExtract.setToolTipText("Extraer recurso");
        this.buttonExtract.setBounds(175, 360, 48, 48);
        this.buttonExtract.setBorder(null);
        this.add(buttonExtract);

        // Event buttonExtract
        this.buttonExtract.addActionListener(e -> OExtractResource.commandResource());

        // Button buttonOpenDir
        this.buttonOpenDir.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/openDir.png"));
        this.buttonOpenDir.setToolTipText("Abrir directorio del recurso");
        this.buttonOpenDir.setBounds(255, 360, 48, 48);
        this.buttonOpenDir.setBorder(null);
        this.add(buttonOpenDir);

        // Event buttonExtract
        this.buttonOpenDir.addActionListener(e -> System.out.println("Funcion no disponible"));

        // Button buttonOpenDir
        this.buttonDelete.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/delete.png"));
        this.buttonDelete.setToolTipText("Remover recurso");
        this.buttonDelete.setBounds(335, 360, 48, 48);
        this.buttonDelete.setBorder(null);
        this.add(buttonDelete);

        // Event buttonExtract
        this.buttonDelete.addActionListener(e -> System.out.println("Funcion no disponible"));

        // Button buttonChangeLanguage
        this.buttonChangeLanguage.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/spanish.png"));
        this.buttonChangeLanguage.setToolTipText("Cambiar idioma");
        this.buttonChangeLanguage.setBounds(415, 360, 48, 48);
        this.buttonChangeLanguage.setBorder(null);
        this.add(buttonChangeLanguage);

        // Event buttonExtract
        this.buttonChangeLanguage.addActionListener(e -> System.out.println("Funcion no disponible"));

        // Button buttonChangeLanguage
        this.buttonPassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/password-requet.png"));
        this.buttonPassword.setToolTipText("Contraseña del recurso");
        this.buttonPassword.setBounds(490, 360, 48, 48);
        this.buttonPassword.setBorder(null);
        this.add(buttonPassword);

        // Event buttonExtract
        this.buttonPassword.addActionListener(e -> OShowDialog.message("Si el recurso requiere una contraseña, por favor\ncolocarla en el campo que se muestra abajo", System.getProperty("user.dir") + "/container/images/perfect-2.png", new String[]{"Aceptar"}));
    }

    public static void main(String[] args) {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("mac") || System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } else {
                System.exit(0);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace(System.out);
            throw new resource.showException("Excepción, No se pudo establecer el look de la aplicacón");
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            index.window = new index();
            index.window.setSize(700, 520);
            index.window.setVisible(true);
            index.window.setLocationRelativeTo(null);
            index.window.getContentPane().setBackground(java.awt.Color.white);
            if (index.depure == 1){
                index.window.setResizable(true);
            }else {
                index.window.setResizable(false);
            }
        });
    }

    // Var
    public static final int depure = 0;

    // Object
    public static index window = new index();

    // Object
    private final resource.explorer OExplorer = new resource.explorer();
    private final resource.loadFont OLoadFont = new resource.loadFont();
    private final resource.showDialog OShowDialog = new resource.showDialog();
    private final resource.extractResource OExtractResource = new resource.extractResource();
    //private final resource.showDialog OShowDialog = new resource.showDialog();


    // Object
    private final javax.swing.JLabel labelTitle = new javax.swing.JLabel();
    private final javax.swing.JButton buttonExtractExplorer = new javax.swing.JButton();
    private final javax.swing.JButton buttonExtract = new javax.swing.JButton();
    private final javax.swing.JButton buttonOpenDir = new javax.swing.JButton();
    private final javax.swing.JButton buttonDelete = new javax.swing.JButton();
    private final javax.swing.JButton buttonChangeLanguage = new javax.swing.JButton();
    private final javax.swing.JButton buttonPassword = new javax.swing.JButton();
}
