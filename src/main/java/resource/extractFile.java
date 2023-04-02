package resource;

public class extractFile implements interfaces.IExtractFile {

    private static Integer exitCode = null;

    private String password = new String();

    @Override
    public void commandLine() throws showException {
        // Conditions before processing the command line
        if (extractFile.OExplorer.getFilePath() != null) {
            if (extractFile.OExplorer.getFilePath().isAbsolute()) {
                if (extractFile.OExplorer.getFilePath().exists()) {
                    if (extractFile.OExplorer.getFilePath().isFile()) {

                        // Open a dialog to choose the extraction directory
                        extractFile.OExplorer.extractionPath();

                        // Conditions before processing the command line
                        if (extractFile.OExplorer.getExtractionPathOne() != null) {
                            if (extractFile.OExplorer.getExtractionPathOne().isAbsolute()) {

                                // Create a directory to extract the selected file
                                extractFile.OCreatePath.createDirectory(extractFile.OExplorer.getExtractionPathOne());

                                // Conditions before processing the command line
                                if (extractFile.OExplorer.getExtractionPathOne().exists()) {
                                    if (extractFile.OCreatePath.getDirectory() != null) {
                                        if (extractFile.OCreatePath.getDirectory().exists()) {
                                            if (extractFile.OCreatePath.getDirectory().isAbsolute()) {

                                                // Create a new SwingWorker to execute a task in the background thread
                                                javax.swing.SwingWorker<Void, String> worker = new javax.swing.SwingWorker<Void, String>() {
                                                    // Override doInBackground method to perform the task in the background
                                                    @Override
                                                    protected Void doInBackground() throws Exception {
                                                        try {
                                                            // Create a new ProcessBuilder with the command to execute in the shell
                                                            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", String.format("'%s/container/winrar/%s/rar' x '%s' '%s'", System.getProperty("user.dir"), run.main.operatingSystem, extractFile.OExplorer.getFilePath(), extractFile.OCreatePath.getDirectory()));
                                                            Process process = pb.start(); // Start the process
                                                            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream())); // Read the process output using a BufferedReader

                                                            // Set the text color of the output label to green
                                                            run.main.window.getLabelOutputText().setForeground(new java.awt.Color(88, 217, 139));

                                                            if (run.main.window.getButtonImportResource().isVisible()) {
                                                                // Disable button extract resources
                                                                run.main.window.getButtonImportResource().setEnabled(!run.main.window.getButtonImportResource().isEnabled());
                                                            } else if (run.main.window.getButtonSuccessfulDecompression().isVisible()) {
                                                                run.main.window.getButtonSuccessfulDecompression().setEnabled(!run.main.window.getButtonSuccessfulDecompression().isEnabled());
                                                            }

                                                            // Disable some buttons while the task is running
                                                            run.main.window.getButtonExtractResources().setEnabled(!run.main.window.getButtonExtractResources().isEnabled());
                                                            run.main.window.getButtonOpenDirectory().setEnabled(!run.main.window.getButtonOpenDirectory().isEnabled());
                                                            run.main.window.getButtonRemoveResource().setEnabled(!run.main.window.getButtonRemoveResource().isEnabled());
                                                            run.main.window.getButtonChangeLanguage().setEnabled(!run.main.window.getButtonChangeLanguage().isEnabled());
                                                            run.main.window.getButtonSetPassword().setEnabled(!run.main.window.getButtonSetPassword().isEnabled());

                                                            String line;

                                                            // Read the process output line by line and publish it to the EDT for processing
                                                            while ((line = reader.readLine()) != null) {
                                                                publish(line);
                                                            }

                                                            extractFile.exitCode = process.waitFor(); // Get the exit code of the process

                                                        } catch (InterruptedException e) {
                                                            e.printStackTrace(System.out);
                                                            // Throw a custom exception if an error occurs while executing the command
                                                            throw new showException("[Exception]: An exception occurred while trying to execute console commands. class name: (" + this.getClass() + ")\n\n");
                                                        }
                                                        return null;
                                                    }

                                                    // Override process method to update the GUI on the EDT with the published chunks
                                                    @Override
                                                    protected void process(java.util.List<String> chunks) {
                                                        for (String line : chunks) {
                                                            run.main.window.setLabelOutputText(line);
                                                        }
                                                    }

                                                    // Override done method to perform some actions on the EDT after the task is completed
                                                    @Override
                                                    protected void done() {
                                                        // Hide the Import button
                                                        run.main.window.getButtonImportResource().setVisible(false);

                                                        // Set the text color of the output label to green or red depending on the exit code
                                                        run.main.window.getLabelOutputText().setForeground(new java.awt.Color(187, 187, 187));
                                                        String changeLabelOutputText = extractFile.exitCode != 0 ? "Some errors seem to have occurred while trying to extract the file" : "The file " + (extractFile.this.getFileName().toString().length() > 20 ? extractFile.this.getFileName().toString().substring(0, 13) + "..." + extractFile.this.getFileName().toString().substring(extractFile.this.getFileName().toString().length() - 7) : extractFile.this.getFileName().toString()) + " has been successfully decompressed";
                                                        run.main.window.setLabelOutputText(changeLabelOutputText);
                                                        run.main.window.getLabelOutputText().setToolTipText(changeLabelOutputText);

                                                        // Enable some buttons and show a dialog with a message and options based on the exit code
                                                        if (extractFile.exitCode != 0) {
                                                            run.main.window.getButtonError().setEnabled(!run.main.window.getButtonError().isEnabled());
                                                            run.main.window.getButtonError().setVisible(!run.main.window.getButtonError().isVisible());

                                                            // Display an error message dialog with options to accept
                                                            extractFile.OShowDialog.message(false, "Ha ocurrido un error al descomprimir el fichero\nPuede que este contengan caracteres no apropiados\nPor favor, rectifica el nombre del fichero y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});

                                                        } else {
                                                            // Enable button of successful decompression
                                                            run.main.window.getButtonSuccessfulDecompression().setEnabled(true);
                                                            run.main.window.getButtonSuccessfulDecompression().setVisible(true);

                                                            // Enable all other necessary buttons
                                                            run.main.window.getButtonExtractResources().setEnabled(!run.main.window.getButtonExtractResources().isEnabled());
                                                            run.main.window.getButtonOpenDirectory().setEnabled(!run.main.window.getButtonOpenDirectory().isEnabled());
                                                            run.main.window.getButtonRemoveResource().setEnabled(!run.main.window.getButtonRemoveResource().isEnabled());
                                                            run.main.window.getButtonChangeLanguage().setEnabled(!run.main.window.getButtonChangeLanguage().isEnabled());
                                                            run.main.window.getButtonSetPassword().setEnabled(!run.main.window.getButtonSetPassword().isEnabled());

                                                            // Set the extraction path to null
                                                            extractFile.this.setExtractionPathOne(null);

                                                            // Display a success message dialog with options to donate via Paypal or accept
                                                            extractFile.OShowDialog.message(false, "¡Enhorabuena! El fichero se ha extraído correctamente\n\nSí, usted considera que le ha sido de utilidad este software puede ayudar\nAl desarrollador con una donación vía PayPal", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/perfect-2.png"), new String[]{"Donar vía Paypal", "Aceptar"});
                                                        }
                                                    }
                                                };

                                                // Execute the worker thread to perform the extraction process
                                                worker.execute();

                                            } else {
                                                // Display an error message dialog with options to accept
                                                extractFile.OShowDialog.message(false, "Parece que el directorio de extracción no es absoluto\nPor favor, selecciona un directorio de extracción válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                                            }
                                        } else {
                                            // Display an error message dialog with options to accept
                                            extractFile.OShowDialog.message(false, "Parece que el directorio de extracción no existe\nPor favor, selecciona un directorio de extracción válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                                        }
                                    } else {
                                        // Display an error message dialog with options to accept
                                        extractFile.OShowDialog.message(false, "Parece que el directorio de extracción no existe\nPor favor, selecciona un directorio de extracción válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                                    }
                                } else {
                                    // Display an error message dialog with options to accept
                                    extractFile.OShowDialog.message(false, "Parece que el directorio de extracción no existe\nPor favor, selecciona un directorio de extracción válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                                }
                            } else {
                                // Display an error message dialog with options to accept
                                extractFile.OShowDialog.message(false, "Parece que el directorio seleccionado no es absoluto\nPor favor, selecciona un directorio de extracción válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                            }
                        } else {
                            // Display an error message dialog with options to accept
                            extractFile.OShowDialog.message(false, "Parece que el directorio de extracción es nula\nPor favor, selecciona un directorio de extracción válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                        }
                    } else {
                        // Display an error message dialog with options to accept
                        extractFile.OShowDialog.message(false, "Parece que no has seleccionado un fichero válido\nPor favor, selecciona un fichero válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                    }
                } else {
                    // Display an error message dialog with options to accept
                    extractFile.OShowDialog.message(false, "El fichero seleccionado no existe\nPor favor, selecciona un fichero válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                }
            } else {
                // Display an error message dialog with options to accept
                extractFile.OShowDialog.message(false, "El directorio del fichero de extracción no es absoluto\nPor favor, selecciona un fichero válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
            }
        } /*else {
            // Display an error message dialog with options to accept
            extractFile.OShowDialog.message(false, "El fichero de extracción es nulo\nPor favor, selecciona un fichero válido y vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
        }*/
    }

    // Implements the selectFile method from the Extractor interface to select a file
    @Override
    public void selectFile() {
        extractFile.OExplorer.selectFile();
    }

    // Implements the getFileName method from the Extractor interface to get the file name
    @Override
    public java.io.File getFileName() {
        return extractFile.OExplorer.getFileName();
    }

    // Implements the setFileName method from the Extractor interface to set the file name
    @Override
    public void setFileName(java.io.File fileName) {
        extractFile.OExplorer.setFileName(fileName);
    }

    // Implements the getFilePath method from the Extractor interface to get the file path
    @Override
    public java.io.File getFilePath() {
        return extractFile.OExplorer.getFilePath();
    }

    // Implements the setFilePath method from the Extractor interface to set the file path
    @Override
    public void setFilePath(java.io.File filePath) {
        extractFile.OExplorer.setFilePath(filePath);
    }

    // Implements the extractionPath method from the Extractor interface to select a file
    @Override
    public void extractionPath() {
        extractFile.OExplorer.extractionPath();
    }

    // Implements the getExtractionPathOne method from the Extractor interface to get the extraction path one
    @Override
    public java.io.File getExtractionPathOne() {
        return extractFile.OExplorer.getExtractionPathOne();
    }

    // Implements the setExtractionPathOne method from the Extractor interface to set the extraction path one
    @Override
    public void setExtractionPathOne(java.io.File extractionPathOne) {
        extractFile.OExplorer.setExtractionPathOne(extractionPathOne);
    }

    // Implements the getExtractionPathTwo method from the Extractor interface to get the extraction path two
    @Override
    public java.io.File getExtractionPathTwo() {
        return extractFile.OExplorer.getExtractionPathTwo();
    }

    // Implements the setExtractionPathTwo method from the Extractor interface to set the extraction path two
    @Override
    public void setExtractionPathTwo(java.io.File extractionPathTwo) {
        extractFile.OExplorer.setExtractionPathTwo(extractionPathTwo);
    }

    // Implements the restoreOperations method from the Extractor interface to set the file path
    @Override
    public void restoreOperations() {
        if (extractFile.exitCode != 0) { // If the exit code is not zero
            // Disable the error button
            run.main.window.getButtonError().setVisible(!run.main.window.getButtonError().isVisible());
            run.main.window.getButtonError().setEnabled(!run.main.window.getButtonError().isEnabled());

            // Enable the extraction resources, open directory, remove resource, change language and password buttons
            run.main.window.getButtonExtractResources().setEnabled(!run.main.window.getButtonExtractResources().isEnabled());
            run.main.window.getButtonOpenDirectory().setEnabled(!run.main.window.getButtonOpenDirectory().isEnabled());
            run.main.window.getButtonRemoveResource().setEnabled(!run.main.window.getButtonRemoveResource().isEnabled());
            run.main.window.getButtonChangeLanguage().setEnabled(!run.main.window.getButtonChangeLanguage().isEnabled());
            run.main.window.getButtonSetPassword().setEnabled(!run.main.window.getButtonSetPassword().isEnabled());

        } else { // If the exit code is zero
            // Disable the successful decompression button
            run.main.window.getButtonSuccessfulDecompression().setVisible(!run.main.window.getButtonSuccessfulDecompression().isValid());
            run.main.window.getButtonSuccessfulDecompression().setEnabled(!run.main.window.getButtonSuccessfulDecompression().isEnabled());
        }

        // Enable the resource import button
        run.main.window.getButtonImportResource().setEnabled(!run.main.window.getButtonImportResource().isEnabled());
        run.main.window.getButtonImportResource().setVisible(!run.main.window.getButtonImportResource().isVisible());

        // Set the output label text to "Output..." and add a tooltip
        run.main.window.setLabelOutputText("Output...");
        run.main.window.getLabelOutputText().setToolTipText("Here you will see all the tasks that are executing");

        // Set the extraction path, filename, and filepath to null
        this.setFileName(null);
        this.setFilePath(null);
        this.setExtractionPathTwo(null);
    }

    // Implements the getPassword method from the Extractor interface to set the file path
    @Override
    public String getPassword() {
        return this.password; // Return the current password
    }

    // Implements the setPassword method from the Extractor interface to set the file path
    @Override
    public void setPassword(String text) {
        this.password = text; // Set the current password to the value passed as an argument
    }
}
