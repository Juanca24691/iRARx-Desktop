package resource;

import interfaces.IExplorer;
import java.awt.FileDialog;
import java.io.File;
import run.main;

public class explorer implements IExplorer {

    private static File getDir;
    private static File archive;

    @Override
    public void openExplorer() throws showException {
        FileDialog openResource = new FileDialog(main.window, "Abrir recurso", FileDialog.LOAD);
        openResource.setFilenameFilter((File directorio, String nombre) -> nombre.endsWith(".rar"));
        openResource.setVisible(true);

        if (openResource.getFile() != null) {

            // Se recupera el directorio absoluto
            explorer.archive = new File(openResource.getDirectory() + openResource.getFile());
            if (main.depure == 1) {
                System.out.println(this.getArchive() + " ruta del recurso obtenida"
                        + "\n + Atributos: "
                        + "\n\t Es una ruta: " + this.getArchive().isDirectory()
                        + "\n\t Es un archivo: " + this.getArchive().isFile()
                        + "\n\t Existe: " + this.getArchive().exists()
                        + "\n\t Esta oculto: " + this.getArchive().isHidden()
                        + "\n\n");
            }
        } else {
            if (main.depure == 1) {
                System.out.println("Se cancelo la operacion o la ruta del recurso es nula(" + this.getClass() + ")\n\n");
            }
        }
    }

    @Override
    public void save() throws showException {
        FileDialog saveResource = new FileDialog(main.window, "Guardar recurso", FileDialog.SAVE);
        saveResource.setVisible(true);

        if (saveResource.getDirectory() != null) {

            // Se recupera el directorio absoluto
            explorer.getDir = new File(saveResource.getDirectory() + saveResource.getFile());

            if (main.depure == 1) {
                System.out.println(this.getDir() + " ruta de guardado obtenido"
                        + "\n + Atributos: "
                        + "\n\t Es una ruta: " + this.getDir().isDirectory()
                        + "\n\t Es un archivo: " + this.getDir().isFile()
                        + "\n\t Existe: " + this.getDir().exists()
                        + "\n\t Esta oculto: " + this.getDir().isHidden()
                        + "\n\n");
            }
        } else {
            if (main.depure == 1) {
                System.out.println("Se cancelo la operacion o la ruta de guardado es nula(" + this.getClass() + ")\n\n");
            }
        }
    }

    @Override
    public File getArchive() {
        return explorer.archive;
    }

    @Override
    public File getDir() {
        return explorer.getDir;
    }
}
