package resource;

import interfaces.IExtractResource;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import run.main;

public class extractResource implements IExtractResource {

    // Proceso de comandos
    Process command = null;
    InputStream is = null;
    BufferedInputStream bis = null;

    @Override
    public void commandResource() throws showException {

        try {
            
            extractResource.OExplorer.save();

            if (extractResource.OExplorer.getArchive().exists() && extractResource.OExplorer.getArchive().isFile() && extractResource.OExplorer.getArchive().getAbsolutePath() != null && extractResource.OExplorer.getDir().getAbsolutePath() != null) {
                extractResource.OCreateResource.createDirResource(extractResource.OExplorer.getDir());

                StringBuilder cd = new StringBuilder();
                cd.append(System.getProperty("user.dir")).append("/").append("container").append("/").append("winrar").append("/").append("rar").append(" ").append("x").append(" ").append(extractResource.OExplorer.getArchive()).append(" ").append(extractResource.OCreateResource.getDirResource());

                if (extractResource.OCreateResource.getDirResource().exists() && extractResource.OCreateResource.getDirResource() != null && extractResource.OCreateResource.getDirResource().isDirectory() == true) {
                    this.command = Runtime.getRuntime().exec(cd.toString());
                    this.is = this.command.getInputStream();
                    this.bis = new BufferedInputStream(this.is);
                } else {
                    if (main.depure == 1) {
                        System.out.println("El condicional anidado no se cumplio(" + this.getClass() + ")\n\n");
                    }
                }
            } else {
                if (main.depure == 1) {
                    System.out.println("El condicional no se cumplio(" + this.getClass() + ")\n\n");
                }
            }
        } catch (IOException | NullPointerException e) {
            throw new showException("Se produjo una excepción al intentar ejecutar comandos en consola(" + this.getClass() + ")\n\n");
        }
    }
}
