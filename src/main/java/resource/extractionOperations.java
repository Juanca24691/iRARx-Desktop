package resource;

public class extractionOperations implements interfaces.IExtractionOperations {

    @Override
    public void openExtraction(java.io.File route) throws resource.showException {
        if (route != null) {
            if (route.exists()) {
                if (route.isAbsolute()) {
                    if (java.awt.Desktop.getDesktop().isSupported(java.awt.Desktop.Action.OPEN)) {
                        try {
                            java.awt.Desktop.getDesktop().open(route);
                        } catch (java.io.IOException ex) {
                            ex.printStackTrace(System.out);
                            throw new showException("[Excepción]: Se ha producido un error al intentar abrir la ruta específica");
                        }
                    } else {
                        extractionOperations.OShowDialog.message(false, "La apertura del directorio no es compatible con este sistema operativo\nPor favor, intentalo en un dispositivo diferente", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                    }
                } else {
                    extractionOperations.OShowDialog.message(false, "No se puede abrir el directorio de extracción porque este no es un directorio absoluto\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                }
            } else {
                extractionOperations.OShowDialog.message(false, "No se puede abrir el directorio de extracción porque este no existe\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
            }
        } else {
            extractionOperations.OShowDialog.message(false, "No se puede abrir el directorio de extracción porque este es nulo\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
        }
    }

    @Override
    public void removeExtraction(java.io.File route) throws showException {
        if (route != null) {
            if (route.exists()) {
                if (route.isAbsolute()) {
                    javax.swing.SwingWorker<Void, String> worker = new javax.swing.SwingWorker<Void, String>() {
                        @Override
                        protected Void doInBackground() throws Exception {
                            run.main.window.getButtonSuccessfulDecompression().setEnabled(!run.main.window.getButtonSuccessfulDecompression().isEnabled());
                            run.main.window.getButtonExtractResources().setEnabled(!run.main.window.getButtonExtractResources().isEnabled());
                            run.main.window.getButtonOpenDirectory().setEnabled(!run.main.window.getButtonOpenDirectory().isEnabled());
                            run.main.window.getButtonRemoveResource().setEnabled(!run.main.window.getButtonRemoveResource().isEnabled());
                            run.main.window.getButtonChangeLanguage().setEnabled(!run.main.window.getButtonChangeLanguage().isEnabled());
                            run.main.window.getButtonSetPassword().setEnabled(!run.main.window.getButtonSetPassword().isEnabled());

                            run.main.window.getLabelOutputText().setForeground(new java.awt.Color(220, 74, 74));

                            java.nio.file.Path directories = java.nio.file.Paths.get(route.toString());

                            try {
                                java.nio.file.Files.walk(directories)
                                        .sorted(java.util.Comparator.reverseOrder())
                                        .map(java.nio.file.Path::toFile)
                                        .forEach(file -> {
                                            if (file.delete()) {
                                                publish("Eliminado el archivo y/o fichero " + file.getName());
                                            } else {
                                                publish("No se pudo eliminar el archivo y/o fichero " + file.getName());
                                            }
                                        });
                            } catch (java.io.IOException ex) {
                                ex.printStackTrace(System.out);
                                throw new showException("[Excepción]: No se puede eliminar la ruta especificada");
                            }
                            return null;
                        }

                        @Override
                        protected void process(java.util.List<String> chunks) {
                            for (String message : chunks) {
                                run.main.window.setLabelOutputText(message);
                            }
                        }

                        @Override
                        protected void done() {
                            run.main.window.getButtonSuccessfulDecompression().setEnabled(!run.main.window.getButtonSuccessfulDecompression().isEnabled());
                            run.main.window.getButtonExtractResources().setEnabled(!run.main.window.getButtonExtractResources().isEnabled());
                            run.main.window.getButtonOpenDirectory().setEnabled(!run.main.window.getButtonOpenDirectory().isEnabled());
                            run.main.window.getButtonRemoveResource().setEnabled(!run.main.window.getButtonRemoveResource().isEnabled());
                            run.main.window.getButtonChangeLanguage().setEnabled(!run.main.window.getButtonChangeLanguage().isEnabled());
                            run.main.window.getButtonSetPassword().setEnabled(!run.main.window.getButtonSetPassword().isEnabled());

                            run.main.window.getLabelOutputText().setForeground(new java.awt.Color(187, 187, 187));

                            // Text for the label output text
                            String changeLabelOutputText = "El directorio de extracción " + extractionOperations.OExtractFile.getExtractionPathTwo().toString() + " fue eliminada satisfactoriamente";

                            // Change text on labelOutputText
                            run.main.window.setLabelOutputText(changeLabelOutputText);
                            run.main.window.getLabelOutputText().setToolTipText(changeLabelOutputText);

                            if (!extractionOperations.OExtractFile.getExtractionPathTwo().exists()) {
                                extractionOperations.OShowDialog.message(false, "La ruta de extración fue eliminada correctamente", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/perfect-2.png"), new String[]{"Aceptar"});
                            } else {
                                extractionOperations.OShowDialog.message(false, "La ruta de extracción no se pudo eliminar correctamente\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                            }
                        }
                    };

                    worker.execute();
                } else {
                    extractionOperations.OShowDialog.message(false, "No se puede eliminar el directorio de extracción por qué este no es un directorio absoluto\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
                }
            } else {
                extractionOperations.OShowDialog.message(false, "No se puede eliminar el directorio de extracción por qué este no existe\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
            }
        } else {
            extractionOperations.OShowDialog.message(false, "No se puede eliminar el directorio de extracción por qué este es nulo\nPor favor, vuelve a intentarlo", new javax.swing.ImageIcon(System.getProperty("user.dir") + "/container/images/cancel.png"), new String[]{"Aceptar"});
        }
    }
}
