package resource;

public class createDirectory implements interfaces.ICreateDirectory {

    // Define a private instance variable of type java.io.File to hold the directory that will be created
    private java.io.File directory;

    // Override the createDirectory method from the ICreateDirectory interface
    @Override
    public void createDirectory(java.io.File directory) {
        // Check if the input directory is not null
        if (directory != null) {
            // Check if the input directory is has a valid absolute path
            if (directory.getAbsolutePath() != null) {
                // Check if the input directory does not already exist
                if (!directory.exists()) {
                    // If all conditions are true, set the private directory variable to the input directory and create the directory on the file system
                    this.setDirectory(new java.io.File(directory.getAbsolutePath()));
                    this.getDirectory().mkdir();
                } else {
                    // If any of the conditions are false, display a message dialog to inform the user that the directory was not created and provide guidance on how to select a valid directory
                    new resource.showDialog().message(false, "Parece que el directorio ya existe\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                }
            } else {
                // If any of the conditions are false, display a message dialog to inform the user that the directory was not created and provide guidance on how to select a valid directory
                new resource.showDialog().message(false, "Paree que el directorio no es absoluto\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
            }
        } else {
            // If any of the conditions are false, display a message dialog to inform the user that the directory was not created and provide guidance on how to select a valid directory
            new resource.showDialog().message(false, "Parece que el directorio en nulo\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
        }
    }

    // Override the getDirectory method from the ICreateDirectory interface
    @Override
    public java.io.File getDirectory() {
        // Return the private directory variable
        return this.directory;
    }

    // Override the setDirectory method from the ICreateDirectory interface
    @Override
    public void setDirectory(java.io.File directory) {
        // Set the private directory variable to the input directory
        this.directory = directory;
    }
}
