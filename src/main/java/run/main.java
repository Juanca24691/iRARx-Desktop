package run;

public class main extends javax.swing.JFrame {

    // Global var
    public static String operatingSystem = System.getProperty("os.name").toLowerCase().contains("mac os x") || System.getProperty("os.name").toLowerCase().contains("darwin") ? "osx" : System.getProperty("os.name").toLowerCase(); // Operating system

    // App name
    public static String appName = "iRARx";

    // Window object
    public static main window = new main();

    static {
        if (main.operatingSystem.contains("osx")) {
            // Set the application name on osx
            System.setProperty("apple.awt.application.name", main.appName);
        }
    }

    // Object
    private final resource.loadFont OLoadFont = new resource.loadFont();
    private final resource.showDialog OShowDialog = new resource.showDialog();
    private final resource.extractFile OExtractFile = new resource.extractFile();

    // Components
    private final javax.swing.JLabel labelTitle = new javax.swing.JLabel();
    private final javax.swing.JButton buttonImportResource = new javax.swing.JButton();
    private final javax.swing.JButton buttonSuccessfulDecompression = new javax.swing.JButton();
    private final javax.swing.JButton buttonError = new javax.swing.JButton();
    private final javax.swing.JButton buttonExtractResources = new javax.swing.JButton();
    private final javax.swing.JButton buttonOpenDirectory = new javax.swing.JButton();
    private final javax.swing.JButton buttonRemoveResource = new javax.swing.JButton();
    private final javax.swing.JButton buttonChangeLanguage = new javax.swing.JButton();
    private final javax.swing.JButton buttonSetPassword = new javax.swing.JButton();
    private final javax.swing.JLabel labelOutputText = new javax.swing.JLabel();

    public main() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);

        // Label
        this.OLoadFont.loadFonts(System.getProperty("user.dir") + "/container/fonts", "Pacifico-Regular", ".ttf", 75);
        this.labelTitle.setFont(this.OLoadFont.getFont());
        this.labelTitle.setText(main.appName);
        this.labelTitle.setForeground(new java.awt.Color(32, 32, 34));
        this.labelTitle.setBounds(235, 65, 260, 65);
        this.add(labelTitle);

        // Button buttonImportResource
        this.buttonImportResource.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/import.gif"));
        this.buttonImportResource.setToolTipText("Abrir recurso");
        this.buttonImportResource.setBounds(255, 150, 200, 200);
        this.buttonImportResource.setBackground(null);
        this.buttonImportResource.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonImportResource.setBorder(null);
        this.buttonImportResource.setBorderPainted(false);
        this.buttonImportResource.setContentAreaFilled(false);
        this.buttonImportResource.setVisible(true);
        this.add(buttonImportResource);

        // Event buttonImportResource
        this.buttonImportResource.addActionListener(e -> this.OExtractFile.selectFile());

        // Button buttonSuccessfulDecompression
        this.buttonSuccessfulDecompression.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/perfect.gif"));
        this.buttonSuccessfulDecompression.setToolTipText("Importar nuevo fichero");
        this.buttonSuccessfulDecompression.setBounds(255, 150, 200, 200);
        this.buttonSuccessfulDecompression.setBackground(null);
        this.buttonSuccessfulDecompression.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonSuccessfulDecompression.setBorder(null);
        this.buttonSuccessfulDecompression.setBorderPainted(false);
        this.buttonSuccessfulDecompression.setContentAreaFilled(false);
        this.buttonSuccessfulDecompression.setEnabled(false);
        this.buttonSuccessfulDecompression.setVisible(false);
        this.add(buttonSuccessfulDecompression);

        // Event buttonSuccessfulDecompression
        this.buttonSuccessfulDecompression.addActionListener(e -> this.OExtractFile.restoreOperations());

        // Button buttonError
        this.buttonError.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/error.gif"));
        this.buttonError.setToolTipText("Se ha producido un error al extraer el fichero seleccionado");
        this.buttonError.setBounds(255, 150, 200, 200);
        this.buttonError.setBackground(null);
        this.buttonError.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonError.setBorder(null);
        this.buttonError.setBorderPainted(false);
        this.buttonError.setContentAreaFilled(false);
        this.buttonError.setEnabled(false);
        this.buttonError.setVisible(false);
        this.add(buttonError);

        // Event buttonError
        this.buttonError.addActionListener(e -> this.OExtractFile.restoreOperations());

        // Button buttonExtractResources
        this.buttonExtractResources.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/extract.png"));
        this.buttonExtractResources.setToolTipText("Extraer fichero");
        this.buttonExtractResources.setBounds(175, 360, 48, 48);
        this.buttonExtractResources.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonExtractResources.setBorder(null);
        this.buttonExtractResources.setBorderPainted(false);
        this.buttonExtractResources.setContentAreaFilled(false);
        this.add(buttonExtractResources);

        // Event buttonExtractResources
        this.buttonExtractResources.addActionListener(e -> this.OExtractFile.commandLine());

        // Button buttonOpenDirectory
        this.buttonOpenDirectory.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/openDir.png"));
        this.buttonOpenDirectory.setToolTipText("Abrir directorio de extracción");
        this.buttonOpenDirectory.setBounds(255, 360, 48, 48);
        this.buttonOpenDirectory.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonOpenDirectory.setBorder(null);
        this.buttonOpenDirectory.setBorderPainted(false);
        this.buttonOpenDirectory.setContentAreaFilled(false);
        this.add(buttonOpenDirectory);

        // Event buttonOpenDirectory
        this.buttonOpenDirectory.addActionListener(e -> new resource.extractionOperations().openExtraction(this.OExtractFile.getExtractionPathTwo()));

        // Button buttonRemoveResource
        this.buttonRemoveResource.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/delete.png"));
        this.buttonRemoveResource.setToolTipText("Eliminar extracción");
        this.buttonRemoveResource.setBounds(335, 360, 48, 48);
        this.buttonRemoveResource.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonRemoveResource.setBorder(null);
        this.buttonRemoveResource.setBorderPainted(false);
        this.buttonRemoveResource.setContentAreaFilled(false);
        this.add(buttonRemoveResource);

        // Event buttonRemoveResource
        this.buttonRemoveResource.addActionListener(e -> new resource.extractionOperations().removeExtraction(this.OExtractFile.getExtractionPathTwo()));

        // Button buttonChangeLanguage
        this.buttonChangeLanguage.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/spanish.png"));
        this.buttonChangeLanguage.setToolTipText("Cambiar idioma");
        this.buttonChangeLanguage.setBounds(415, 360, 48, 48);
        this.buttonChangeLanguage.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonChangeLanguage.setBorder(null);
        this.buttonChangeLanguage.setBorderPainted(false);
        this.buttonChangeLanguage.setContentAreaFilled(false);
        this.add(this.buttonChangeLanguage);

        // Event buttonChangeLanguage
        this.buttonChangeLanguage.addActionListener(e -> System.out.println("Funcion no disponible"));

        // Button buttonSetPassword
        this.buttonSetPassword.setIcon(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/password-requet.png"));
        this.buttonSetPassword.setToolTipText("Establecer contraseña del fichero");
        this.buttonSetPassword.setBounds(490, 360, 48, 48);
        this.buttonSetPassword.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        this.buttonSetPassword.setBorder(null);
        this.buttonSetPassword.setBorderPainted(false);
        this.buttonSetPassword.setContentAreaFilled(false);
        this.add(this.buttonSetPassword);

        // Event buttonSetPassword
        this.buttonSetPassword.addActionListener(e -> OShowDialog.input(true, "Si el recurso requiere una contraseña, por favor\ncolocarla en el campo que se muestra abajo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/perfect-2.png"), new String[]{"Aceptar"}));

        // Label labelOutputText 
        this.OLoadFont.loadFonts(System.getProperty("user.dir") + "/container/fonts", "Quicksand-SemiBold", ".ttf", 15);
        this.labelOutputText.setFont(this.OLoadFont.getFont());
        this.labelOutputText.setText("Salida...");
        this.labelOutputText.setToolTipText("Aquí veras todas las tareas que se estan ejecutando");
        this.labelOutputText.setBounds(15, 455, 615, 15);
        this.labelOutputText.setForeground(new java.awt.Color(187, 187, 187));
        this.add(this.labelOutputText);
    }

    public static void main(String args[]) {
        try {
            if (main.operatingSystem.contains("osx")) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } else if (main.operatingSystem.contains("linux")) {
                javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            } else {
                System.exit(0);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            throw new resource.showException("[Excepción]: No se pudo establecer el diseño para la aplicacón. Class name: (" + ex.getClass() + ")");
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            main.window = new main();
            main.window.setTitle(main.appName);
            main.window.setSize(700, 520);
            main.window.setLocationRelativeTo(null);
            main.window.getContentPane().setBackground(new java.awt.Color(241, 247, 249));
            main.window.setResizable(false);
            main.window.setDefaultCloseOperation(EXIT_ON_CLOSE);

            // Set icon for application on osx
            if (main.operatingSystem.contains("osx")) {

                // Position the menu bar above
                System.setProperty("apple.laf.useScreenMenuBar", "true");

                // Load the image for the app tile
                java.awt.Toolkit herramientas = java.awt.Toolkit.getDefaultToolkit();
                java.awt.Image icono = herramientas.getImage(System.getProperty("user.dir") + "/container/images/icon.png");
                java.awt.Taskbar dock = java.awt.Taskbar.getTaskbar(); // New code after JDK 9

                try {
                    // Set icon for macOS (and other systems that support this method)
                    dock.setIconImage(icono);
                } catch (UnsupportedOperationException | SecurityException e) {
                    e.printStackTrace(System.out);
                }
            } else if (main.operatingSystem.contains("linux")) // Set icon for application on linux
            {
                main.window.setIconImage(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/icon.png").getImage()); // Set the icon image for the JFrame
            }

            main.window.setVisible(true);
        });
    }

    public javax.swing.JLabel getLabelTitle() {
        return this.labelTitle;
    }

    public void setLabelTitle(String text) {
        this.labelTitle.setText(text);
    }

    public javax.swing.JButton getButtonImportResource() {
        return this.buttonImportResource;
    }

    public void setButtonImportResource(String text) {
        this.buttonImportResource.setToolTipText(text);
    }

    public javax.swing.JButton getButtonSuccessfulDecompression() {
        return this.buttonSuccessfulDecompression;
    }

    public void setButtonSuccessfulDecompression(String text) {
        this.buttonSuccessfulDecompression.setToolTipText(text);
    }

    public javax.swing.JButton getButtonError() {
        return this.buttonError;
    }

    public void setButtonError(String text) {
        this.buttonError.setToolTipText(text);
    }

    public javax.swing.JButton getButtonExtractResources() {
        return this.buttonExtractResources;
    }

    public void setButtonExtractResources(String text) {
        this.buttonExtractResources.setToolTipText(text);
    }

    public javax.swing.JButton getButtonOpenDirectory() {
        return this.buttonOpenDirectory;
    }

    public void setButtonOpenDirectory(String text) {
        this.buttonOpenDirectory.setToolTipText(text);
    }

    public javax.swing.JButton getButtonRemoveResource() {
        return this.buttonRemoveResource;
    }

    public void setButtonRemoveResource(String text) {
        this.buttonRemoveResource.setToolTipText(text);
    }

    public javax.swing.JButton getButtonChangeLanguage() {
        return this.buttonChangeLanguage;
    }

    public void setButtonChangeLanguage(String text) {
        this.buttonChangeLanguage.setToolTipText(text);
    }

    public javax.swing.JButton getButtonSetPassword() {
        return this.buttonSetPassword;
    }

    public void setButtonSetPassword(String text) {
        this.buttonSetPassword.setToolTipText(text);
    }

    public javax.swing.JLabel getLabelOutputText() {
        return this.labelOutputText;
    }

    public void setLabelOutputText(String text) {
        this.labelOutputText.setText(text);
    }
}
