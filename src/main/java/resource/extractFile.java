package resource;

import run.main;

public class extractFile implements interfaces.IExtractFile {

    private static Integer exitCode = null;

    private String password = null;

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
                                extractFile.this.ODirectory.create(extractFile.OExplorer.getExtractionPathOne());

                                // Conditions before processing the command line
                                if (extractFile.OExplorer.getExtractionPathOne().exists()) {
                                    if (extractFile.this.ODirectory.getDirectory() != null) {
                                        if (extractFile.this.ODirectory.getDirectory().exists()) {
                                            if (extractFile.this.ODirectory.getDirectory().isAbsolute()) {

                                                // Create a new SwingWorker to execute a task in the background thread
                                                javax.swing.SwingWorker<Void, String> worker = new javax.swing.SwingWorker<>() {
                                                    // Override doInBackground method to perform the task in the background
                                                    @Override
                                                    protected Void doInBackground() throws Exception {
                                                        try {
                                                            // Create a new ProcessBuilder with the command to execute in the shell
                                                            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", String.format("'%s/resources/rar_commandline/%s/rar' x '%s' '%s'", System.getProperty("user.dir"), main.operatingSystem, extractFile.OExplorer.getFilePath(), extractFile.this.ODirectory.getDirectory()));
                                                            Process process = pb.start(); // Start the process
                                                            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream())); // Read the process output using a BufferedReader

                                                            // Set the text color of the output label to green
                                                            main.window.getOutputText().setForeground(new java.awt.Color(88, 217, 139));

                                                            if (main.window.getImportFile().isVisible()) {
                                                                // Disable button extract resources
                                                                main.window.getImportFile().setEnabled(!main.window.getImportFile().isEnabled());
                                                            } else if (main.window.getSuccessfulDecompression().isVisible()) {
                                                                main.window.getSuccessfulDecompression().setEnabled(!main.window.getSuccessfulDecompression().isEnabled());
                                                            }

                                                            // Disable some buttons while the task is running
                                                            main.window.getExtractFile().setEnabled(!main.window.getExtractFile().isEnabled());
                                                            main.window.getOpenDirectory().setEnabled(!main.window.getOpenDirectory().isEnabled());
                                                            main.window.getRemoveExtraction().setEnabled(!main.window.getRemoveExtraction().isEnabled());
                                                            main.window.getChangeLanguage().setEnabled(!main.window.getChangeLanguage().isEnabled());
                                                            main.window.getSetPassword().setEnabled(!main.window.getSetPassword().isEnabled());

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
                                                            main.window.setOutputText(line);
                                                        }
                                                    }

                                                    // Override done method to perform some actions on the EDT after the task is completed
                                                    @Override
                                                    protected void done() {
                                                        // Hide the Import button
                                                        main.window.getImportFile().setVisible(false);

                                                        // Set the text color of the output label to green or red depending on the exit code
                                                        main.window.getOutputText().setForeground(new java.awt.Color(187, 187, 187));
                                                        String changeLabelOutputText = extractFile.exitCode != 0 ? "Some errors seem to have occurred while trying to extract the file" : "The file " + (extractFile.this.getFileName().toString().length() > 20 ? extractFile.this.getFileName().toString().substring(0, 13) + "..." + extractFile.this.getFileName().toString().substring(extractFile.this.getFileName().toString().length() - 7) : extractFile.this.getFileName().toString()) + " has been successfully decompressed";
                                                        main.window.setOutputText(changeLabelOutputText);
                                                        main.window.getOutputText().setToolTipText(changeLabelOutputText);

                                                        // Enable some buttons and show a dialog with a message and options based on the exit code
                                                        if (extractFile.exitCode != 0) {
                                                            main.window.getFailedDecompression().setEnabled(!main.window.getFailedDecompression().isEnabled());
                                                            main.window.getFailedDecompression().setVisible(!main.window.getFailedDecompression().isVisible());

                                                            // Display an error message dialog with options to accept
                                                            extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "An error occurred while unzipping the file\nMay contain inappropriate characters\nPlease rectify the file name and try again", "Accept");

                                                        } else {
                                                            // Enable button of successful decompression
                                                            main.window.getSuccessfulDecompression().setEnabled(true);
                                                            main.window.getSuccessfulDecompression().setVisible(true);

                                                            // Enable all other necessary buttons
                                                            main.window.getExtractFile().setEnabled(!main.window.getExtractFile().isEnabled());
                                                            main.window.getOpenDirectory().setEnabled(!main.window.getOpenDirectory().isEnabled());
                                                            main.window.getRemoveExtraction().setEnabled(!main.window.getRemoveExtraction().isEnabled());
                                                            main.window.getChangeLanguage().setEnabled(!main.window.getChangeLanguage().isEnabled());
                                                            main.window.getSetPassword().setEnabled(!main.window.getSetPassword().isEnabled());

                                                            // Set the extraction path to null
                                                            extractFile.this.setExtractionPathOne(null);

                                                            // Display a success message dialog with options to donate or accept
                                                            extractFile.OShowDialog.confirmation(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/done.png"), "Congratulations! The file has been extracted successfully\n\nYes, you think you have found this software useful can help\nTo the developer with a donation via PayPal", new String[]{"Donate", "Accept"});
                                                        }
                                                    }
                                                };

                                                // Execute the worker thread to perform the extraction process
                                                worker.execute();

                                            } else {
                                                // Display an error message dialog with options to accept
                                                extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "It seems that the extract directory is not absolute\nPlease select a valid extraction directory and try again", "Accept");
                                            }
                                        } else {
                                            // Display an error message dialog with options to accept
                                            extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The extract directory does not appear to exist\nPlease select a valid extraction directory and try again", "Accept");
                                        }
                                    } else {
                                        // Display an error message dialog with options to accept
                                        extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The extraction directory appears to be null\nPlease select a valid extraction directory and try again", "Accept");
                                    }
                                } else {
                                    // Display an error message dialog with options to accept
                                    extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The extract directory does not appear to exist\nPlease select a valid extraction directory and try again", "Accept");
                                }
                            } else {
                                // Display an error message dialog with options to accept
                                extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The selected directory appears to be absolute\nPlease select a valid extraction directory and try again", "Accept");
                            }
                        } else {
                            // Display an error message dialog with options to accept
                            extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The extraction directory appears to be null\nPlease select a valid extraction directory and try again", "Accept");
                        }
                    } else {
                        // Display an error message dialog with options to accept
                        extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "It looks like you haven't selected a valid file\nPlease select a valid file and try again", "Accept");
                    }
                } else {
                    // Display an error message dialog with options to accept
                    extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The selected file does not exist\nPlease select a valid file and try again", "Accept");
                }
            } else {
                // Display an error message dialog with options to accept
                extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The extraction file directory is not absolute\nPlease select a valid file and try again", "Accept");
            }
        } else {
            // Display an error message dialog with options to accept
            extractFile.OShowDialog.notify(new javax.swing.ImageIcon(System.getProperty("user.dir") + "/resources/images/failed.png"), "The extraction file is null\nPlease select a valid file and try again", "Accept");
        }
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
            main.window.getFailedDecompression().setVisible(!main.window.getFailedDecompression().isVisible());
            main.window.getFailedDecompression().setEnabled(!main.window.getFailedDecompression().isEnabled());

            // Enable the extraction resources, open directory, remove resource, change language and password buttons
            main.window.getExtractFile().setEnabled(!main.window.getExtractFile().isEnabled());
            main.window.getOpenDirectory().setEnabled(!main.window.getOpenDirectory().isEnabled());
            main.window.getRemoveExtraction().setEnabled(!main.window.getRemoveExtraction().isEnabled());
            main.window.getChangeLanguage().setEnabled(!main.window.getChangeLanguage().isEnabled());
            main.window.getSetPassword().setEnabled(!main.window.getSetPassword().isEnabled());

        } else { // If the exit code is zero
            // Disable the successful decompression button
            main.window.getSuccessfulDecompression().setVisible(!main.window.getSuccessfulDecompression().isValid());
            main.window.getSuccessfulDecompression().setEnabled(!main.window.getSuccessfulDecompression().isEnabled());
        }

        // Enable the resource import button
        main.window.getImportFile().setEnabled(!main.window.getImportFile().isEnabled());
        main.window.getImportFile().setVisible(!main.window.getImportFile().isVisible());

        // Set the output label text to "Output..." and add a tooltip
        main.window.setOutputText("Output...");
        main.window.getOutputText().setToolTipText("Here you will see all the tasks that are executing");

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
