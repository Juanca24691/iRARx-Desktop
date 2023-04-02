package resource;

public class explorer implements interfaces.IExplorer {

    // These are private variables of type "File" in the "explorer" class.
    private java.io.File fileName;
    private java.io.File filePath;
    private java.io.File extractionPathOne;
    private java.io.File extractionPathTwo;

    /* An object of the "showDialog" class is created and initialized with the constructor.
    It is marked as final to ensure that its value cannot be changed after initialization. */
    private final showDialog OShowDialog = new showDialog();

    // This is the implementation of the "selectFile()" method from the "IExplorer" interface.
    @Override
    public void selectFile() throws showException {

        // A file dialog box is created to allow the user to select a file.
        java.awt.FileDialog selectFile = new java.awt.FileDialog(run.main.window, "Seleccionar fichero", java.awt.FileDialog.LOAD);

        // A filter is set on the dialog box to show only files that end with ".rar"
        selectFile.setFilenameFilter((java.io.File directorio, String nombre) -> nombre.endsWith(".rar"));

        // The file dialog box is made visible to the user
        selectFile.setVisible(true);

        // If the user has selected a file, then its name and path are stored in the corresponding private variables
        if (selectFile.getFile() != null) {
            this.setFilePath(new java.io.File(selectFile.getDirectory() + selectFile.getFile()));
            this.setFileName(new java.io.File(selectFile.getFile()));

            // Convert file name
            String convertFileName = (selectFile.getFile().length() > 20 ? selectFile.getFile().substring(0, 13) + "..." + selectFile.getFile().substring(selectFile.getFile().length() - 7) : selectFile.getFile());

            // Change the output label
            run.main.window.setLabelOutputText("Fichero seleccionado: " + convertFileName);

            // A dialog box is created to display a success message to the user
            this.OShowDialog.message(false, "El fichero " + convertFileName + " se ha seleccionado correctamente\nAhora puedes extraerlo dando clic en el botón azul", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/perfect-2.png"), new String[]{"Aceptar"});
        } else {
            // If the user has not selected a file, then an error message is displayed to the user.
            this.OShowDialog.message(false, "Parece que el fichero de seleccion es nulo\nPor favor, selecciona un fichero válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
        }
    }

    // This is the implementation of the "extractionPath()" method from the "IExplorer" interface
    @Override
    public void extractionPath() throws showException {

        // A file dialog box is created to allow the user to select a path to save the extracted files
        java.awt.FileDialog saveResource = new java.awt.FileDialog(run.main.window, "Ruta de extración", java.awt.FileDialog.SAVE);

        // The file dialog box is made visible to the user.
        saveResource.setVisible(true);

        // If the user has selected a path, then two private variables are set to store the path.
        if (saveResource.getDirectory() != null) {
            
            // Save extraction directory
            this.setExtractionPathOne(new java.io.File(saveResource.getDirectory() + saveResource.getFile()));
            this.setExtractionPathTwo(new java.io.File(saveResource.getDirectory() + saveResource.getFile()));
        } else {
            // If the user has not selected a path, then an error message is displayed to the user.
            this.OShowDialog.message(false, "Parece que el directorio de extracción en nulo\nPor favor, selecciona una ruta, asígnale un nombre y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
        }
    }

    // Returns the file name associated with this object
    @Override
    public java.io.File getFileName() {
        return this.fileName;
    }

    // Sets the file name associated with this object
    @Override
    public void setFileName(java.io.File fileName) {
        this.fileName = fileName;
    }

    // Returns the file path associated with this object
    @Override
    public java.io.File getFilePath() {
        return this.filePath;
    }

    // Sets the file path associated with this object
    @Override
    public void setFilePath(java.io.File filePath) {
        this.filePath = filePath;
    }

    // Returns the first extraction path associated with this object
    @Override
    public java.io.File getExtractionPathOne() {
        return this.extractionPathOne;
    }

    // Sets the first extraction path associated with this object
    @Override
    public void setExtractionPathOne(java.io.File absoluteRouteOne) {
        this.extractionPathOne = absoluteRouteOne;
    }

    // Returns the second extraction path associated with this object
    @Override
    public java.io.File getExtractionPathTwo() {
        return this.extractionPathTwo;
    }

    // Sets the second extraction path associated with this object
    @Override
    public void setExtractionPathTwo(java.io.File extractionPath) {
        this.extractionPathTwo = extractionPath;
    }
}
