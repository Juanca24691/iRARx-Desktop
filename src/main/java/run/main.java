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

    public static void main(String args[]) {
        try {
            if (main.operatingSystem.contains("osx")) {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } else if (main.operatingSystem.contains("linux")) {
                javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            } else {
                System.exit(0);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 javax.swing.UnsupportedLookAndFeelException ex) {
            throw new resource.showException("(Exception): Unable to set design for application. Class name: " + ex.getClass());
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
                java.awt.Toolkit tools = java.awt.Toolkit.getDefaultToolkit();
                java.awt.Image icon = tools.getImage(System.getProperty("user.dir") + "/resources/images/app_icon.png");
                java.awt.Taskbar dock = java.awt.Taskbar.getTaskbar(); // New code after JDK 9

                try {
                    // Set icon for macOS (and other systems that support this method)
                    dock.setIconImage(icon);
                } catch (UnsupportedOperationException | SecurityException e) {
                    e.printStackTrace(System.out);
                }
            } else if (main.operatingSystem.contains("linux")) // Set icon for application on linux
            {
                main.window.setIconImage(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/app_icon.png").getImage()); // Set the icon image for the JFrame
            }

            main.window.setVisible(true);
        });
    }

    private main() {
        initComponents();
    }

    /*private String path = null;

    {
        try {
            //path = new java.io.File(run.main.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getPath();
            path = new java.io.File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }*/

    // Object
    private final tools.fonts OFonts = new tools.fonts();
    private final resource.showDialog OShowDialog = new resource.showDialog();
    private final resource.extractFile OExtractFile = new resource.extractFile();

    // Buttons
    private javax.swing.JLabel titleTag;
    private javax.swing.JButton importFile;
    private javax.swing.JButton successfulDecompression;
    private javax.swing.JButton failedDecompression;
    private javax.swing.JButton extractFile;
    private javax.swing.JButton openDirectory;
    private javax.swing.JButton removeExtraction;
    private javax.swing.JButton changeLanguage;
    private javax.swing.JButton setPassword;
    private javax.swing.JLabel outputText;

    private void initComponents() {
        setLayout(null);

        // Title tag
        this.titleTag = new components.labels().label(this.OFonts.load(System.getProperty("user.dir") + "/resources/fonts", "Pacifico-Regular", ".ttf", 75), main.appName, new java.awt.Color(32, 32, 34), 235, 65, 260, 65);
        this.add(this.titleTag);

        // Button importFile
        this.importFile = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/import.gif"), "Open Resource", 255, 150, 200, 200, true, true);
        this.add(this.importFile);

        // Event importFile
        this.importFile.addActionListener(e -> this.OExtractFile.selectFile());

        // Button successfulDecompression
        this.successfulDecompression = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/done.gif"), "Import new file", 255, 150, 200, 200, false, false);
        this.add(this.successfulDecompression);

        // Event successfulDecompression
        this.successfulDecompression.addActionListener(e -> this.OExtractFile.restoreOperations());

        // Button failedDecompression
        this.failedDecompression = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/warning.gif"), "Import new file", 255, 150, 200, 200, false, false);
        this.add(this.failedDecompression);

        // Event failedDecompression
        this.failedDecompression.addActionListener(e -> this.OExtractFile.restoreOperations());

        // Button extractFile
        this.extractFile = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/extract_file.png"), "Extract file", 175, 360, 48, 48, true, true);
        this.add(this.extractFile);

        // Event extractFile
        this.extractFile.addActionListener(e -> this.OExtractFile.commandLine());

        // Button openDirectory
        this.openDirectory = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/open_directory.png"), "Open extract directory", 255, 360, 48, 48, true, true);
        this.add(this.openDirectory);

        // Event openDirectory
        this.openDirectory.addActionListener(e -> new resource.directory().open(this.OExtractFile.getExtractionPathTwo()));

        // Button removeExtraction
        this.removeExtraction = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/remove_extraction.png"), "Remove extraction", 335, 360, 48, 48, true, true);
        this.add(this.removeExtraction);

        // Event removeExtraction
        this.removeExtraction.addActionListener(e -> new resource.directory().remove(this.OExtractFile.getExtractionPathTwo()));

        // Button changeLanguage
        this.changeLanguage = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/english.png"), "Change language", 415, 360, 48, 48, true, true);
        this.add(this.changeLanguage);

        // Event changeLanguage
        this.changeLanguage.addActionListener(e -> System.out.println("Feature not available"));

        // Button setPassword
        this.setPassword = new components.buttons().imageButton(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/set_password.png"), "Set file password", 490, 360, 48, 48, true, true);
        this.add(this.setPassword);

        // Event setPassword
        this.setPassword.addActionListener(e -> System.out.println("Feature not available"));

        // Title tag
        this.outputText = new components.labels().label(this.OFonts.load(System.getProperty("user.dir") + "/resources/fonts", "Quicksand-SemiBold", ".ttf", 15), "Output...", new java.awt.Color(187, 187, 187), 15, 455, 615, 15);
        this.add(this.outputText);
    }

    public javax.swing.JLabel getTitleTag() {
        return this.titleTag;
    }

    public void setTitleTag(String text) {
        this.titleTag.setText(text);
    }

    public javax.swing.JButton getImportFile() {
        return this.importFile;
    }

    public void setImportFile(String text) {
        this.importFile.setToolTipText(text);
    }

    public javax.swing.JButton getSuccessfulDecompression() {
        return this.successfulDecompression;
    }

    public void setSuccessfulDecompression(String text) {
        this.successfulDecompression.setToolTipText(text);
    }

    public javax.swing.JButton getFailedDecompression() {
        return this.failedDecompression;
    }

    public void setFailedDecompression(String text) {
        this.failedDecompression.setToolTipText(text);
    }

    public javax.swing.JButton getExtractFile() {
        return this.extractFile;
    }

    public void setExtractFile(String text) {
        this.extractFile.setToolTipText(text);
    }

    public javax.swing.JButton getOpenDirectory() {
        return this.openDirectory;
    }

    public void setOpenDirectory(String text) {
        this.openDirectory.setToolTipText(text);
    }

    public javax.swing.JButton getRemoveExtraction() {
        return this.removeExtraction;
    }

    public void setRemoveExtraction(String text) {
        this.removeExtraction.setToolTipText(text);
    }

    public javax.swing.JButton getChangeLanguage() {
        return this.changeLanguage;
    }

    public void setChangeLanguage(String text) {
        this.changeLanguage.setToolTipText(text);
    }

    public javax.swing.JButton getSetPassword() {
        return this.setPassword;
    }

    public void setSetPassword(String text) {
        this.setPassword.setToolTipText(text);
    }

    public javax.swing.JLabel getOutputText() {
        return this.outputText;
    }

    public void setOutputText(String text) {
        this.outputText.setText(text);
    }
}
