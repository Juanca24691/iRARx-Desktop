package resource;

import run.main;

public class directory implements interfaces.IDirectory {

    // Define a private instance variable of type java.io.File to hold the directory that will be created
    private java.io.File directory;

    // Override the createDirectory method from the ICreateDirectory interface
    @Override
    public void create(java.io.File directory) {
        // Check if the input directory is not null
        if (directory != null) {
            // Check if the input directory is has a valid absolute path
            if (directory.isAbsolute()) {
                // Check if the input directory does not already exist
                if (!directory.exists()) {
                    directory.mkdir(); // Create directory

                    // If all conditions are true, set the private directory variable to the input directory and create the directory on the file system
                    this.setDirectory(new java.io.File(directory.getAbsolutePath()));
                } else {
                    // If any of the conditions are false, display a message dialog to inform the user that the directory was not created and provide guidance on how to select a valid directory
                    new resource.showDialog().notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The directory already appears to exist\nPlease try again", "Accept");
                }
            } else {
                // If any of the conditions are false, display a message dialog to inform the user that the directory was not created and provide guidance on how to select a valid directory
                new resource.showDialog().notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "It seems that the directory is not absolute\nPlease try again", "Accept");
            }
        } else {
            // If any of the conditions are false, display a message dialog to inform the user that the directory was not created and provide guidance on how to select a valid directory
            new resource.showDialog().notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The directory appears to be null\nPlease try again", "Accept");
        }
    }

    @Override
    public void open(java.io.File directory) throws showException {
        if (directory != null) {
            if (directory.exists()) {
                if (directory.isAbsolute()) {
                    if (java.awt.Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)) {
                        try {
                            java.awt.Desktop.getDesktop().open(directory);
                        } catch (java.io.IOException ex) {
                            ex.printStackTrace(System.out);
                            throw new showException("(Exception): An error occurred while trying to open the specific path. class name: " + this.getClass());
                        }
                    } else {
                        directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "Directory opening is not supported on this operating system\nPlease try a different device", "Accept");
                    }
                } else {
                    directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "Unable to open the pull directory because this is not an absolute directory\nPlease try again", "Accept");
                }
            } else {
                directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "Unable to open the extract directory because it does not exist\nPlease try again", "Accept");
            }
        } else {
            directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "Unable to open extraction directory because extraction directory is null\nPlease try again", "Accept");
        }
    }

    @Override
    public void remove(java.io.File directory) throws showException {
        if (directory != null) {
            if (directory.exists()) {
                if (directory.isAbsolute()) {

                    if (this.OShowDialog.confirmation(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "You are about to delete the extraction directory\nDo you want to delete it?", new String[]{"Erase", "Cancel"})) {
                        javax.swing.SwingWorker<Void, String> worker = new javax.swing.SwingWorker<>() {
                            @Override
                            protected Void doInBackground() {
                                main.window.getSuccessfulDecompression().setEnabled(!main.window.getSuccessfulDecompression().isEnabled());
                                main.window.getExtractFile().setEnabled(!main.window.getExtractFile().isEnabled());
                                main.window.getOpenDirectory().setEnabled(!main.window.getOpenDirectory().isEnabled());
                                main.window.getRemoveExtraction().setEnabled(!main.window.getRemoveExtraction().isEnabled());
                                main.window.getChangeLanguage().setEnabled(!main.window.getChangeLanguage().isEnabled());
                                main.window.getSetPassword().setEnabled(!main.window.getSetPassword().isEnabled());

                                main.window.getOutputText().setForeground(new java.awt.Color(220, 74, 74));

                                java.nio.file.Path directories = java.nio.file.Paths.get(directory.toString());

                                try {
                                    java.nio.file.Files.walk(directories)
                                            .sorted(java.util.Comparator.reverseOrder())
                                            .map(java.nio.file.Path::toFile)
                                            .forEach(file -> {
                                                if (file.delete()) {
                                                    publish("Deleted directory or file " + file.getName());
                                                } else {
                                                    publish("Unable to delete directory or file " + file.getName());
                                                }
                                            });
                                } catch (java.io.IOException ex) {
                                    ex.printStackTrace(System.out);
                                    throw new showException("(Exception):  Unable to delete specified directory. class name" + this.getClass());
                                }
                                return null;
                            }

                            @Override
                            protected void process(java.util.List<String> chunks) {
                                for (String message : chunks) {
                                    main.window.setOutputText(message);
                                }
                            }

                            @Override
                            protected void done() {
                                main.window.getSuccessfulDecompression().setEnabled(!main.window.getSuccessfulDecompression().isEnabled());
                                main.window.getExtractFile().setEnabled(!main.window.getExtractFile().isEnabled());
                                main.window.getOpenDirectory().setEnabled(!main.window.getOpenDirectory().isEnabled());
                                main.window.getRemoveExtraction().setEnabled(!main.window.getRemoveExtraction().isEnabled());
                                main.window.getChangeLanguage().setEnabled(!main.window.getChangeLanguage().isEnabled());
                                main.window.getSetPassword().setEnabled(!main.window.getSetPassword().isEnabled());

                                main.window.getOutputText().setForeground(new java.awt.Color(187, 187, 187));

                                // Text for the label output text
                                String changeLabelOutputText = "The extraction directory " + directory.this.OExtractFile.getExtractionPathTwo().toString() + " was successfully eliminated";

                                // Change text on labelOutputText
                                main.window.setOutputText(changeLabelOutputText);
                                main.window.getOutputText().setToolTipText(changeLabelOutputText);

                                if (!directory.this.OExtractFile.getExtractionPathTwo().exists()) {
                                    directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/done.png"), "The extraction path was successfully deleted", "Accept");
                                } else {
                                    directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The extraction path could not be deleted correctly\nPlease try again", "Accept");
                                }
                            }
                        };

                        worker.execute();
                    }
                } else {
                    directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "Unable to delete extraction directory because this is not an absolute directory\nPlease try again", "Accept");
                }
            } else {
                directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "Unable to delete extraction directory because it does not exist\nPlease try again", "Accept");
            }
        } else {
            directory.this.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "Unable to delete extraction directory because it is null\nPlease try again", "Accept");
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
