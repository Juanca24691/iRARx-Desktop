package resource;

public class explorer implements interfaces.IExplorer {

    private static java.io.File getDir;
    private static java.io.File archive;

    // Object
    showDialog OShowDialog = new showDialog();

    @Override
    public void openExplorer() throws showException {
        java.awt.FileDialog openResource = new java.awt.FileDialog(run.index.window, "Abrir recurso", java.awt.FileDialog.LOAD);
        openResource.setFilenameFilter((java.io.File directorio, String nombre) -> nombre.endsWith(".rar"));
        openResource.setVisible(true);

        if (openResource.getFile() != null) {

            // Se recupera el directorio absoluto
            explorer.archive = new java.io.File(openResource.getDirectory() + openResource.getFile());

            // Mensaje
            this.OShowDialog.message("Fichero seleccionado correcta mente, Ahora estas listo para extraerlo\ndando clic al boton 'Extraer'", System.getProperty("user.dir") + "/container/images/perfect-2.png", new String[]{"Aceptar"});

            if (run.index.depure == 1) {
                System.out.println(this.getArchive() + " ruta del recurso obtenida"
                        + "\n + Atributos: "
                        + "\n\t Es una ruta: " + this.getArchive().isDirectory()
                        + "\n\t Es un archivo: " + this.getArchive().isFile()
                        + "\n\t Existe: " + this.getArchive().exists()
                        + "\n\t Esta oculto: " + this.getArchive().isHidden()
                        + "\n\n");
            }
        } else {
            this.OShowDialog.message("Aun no has seleccioado un fichero, Debe seleccionar uno\npara poder extraerlo, Por favor vuelve a intentarlo cuando estes listo", System.getProperty("user.dir") + "/container/images/cancel.png", new String[]{"Aceptar"});
            if (run.index.depure == 1) {
                System.out.println("Se cancelo la operacion o la ruta del recurso es nula(" + this.getClass() + ")\n\n");
            }
        }
    }

    @Override
    public void save() throws showException {
        java.awt.FileDialog saveResource = new java.awt.FileDialog(run.index.window, "Guardar recurso", java.awt.FileDialog.SAVE);
        saveResource.setVisible(true);

        if (saveResource.getDirectory() != null) {

            // Se recupera el directorio absoluto
            explorer.getDir = new java.io.File(saveResource.getDirectory() + saveResource.getFile());

            if (run.index.depure == 1) {
                System.out.println(this.getDir() + " ruta de guardado obtenido"
                        + "\n + Atributos: "
                        + "\n\t Es una ruta: " + this.getDir().isDirectory()
                        + "\n\t Es un archivo: " + this.getDir().isFile()
                        + "\n\t Existe: " + this.getDir().exists()
                        + "\n\t Esta oculto: " + this.getDir().isHidden()
                        + "\n\n");
            }
        } else {
            this.OShowDialog.message("Debes seleccionar una ruta para poder extraer el fichero\npor favor selecciona una ruta y vuelve a intentarlo", System.getProperty("user.dir") + "/container/images/cancel.png", new String[]{"Aceptar"});
            if (run.index.depure == 1) {
                System.out.println("Se cancelo la operacion o la ruta de guardado es nula(" + this.getClass() + ")\n\n");
            }
        }
    }

    @Override
    public java.io.File getArchive() {
        return explorer.archive;
    }

    @Override
    public java.io.File getDir() {
        return explorer.getDir;
    }
}
