package resource;

public class extractResource implements interfaces.IExtractResource {

    // Proceso de comandos
    Process command = null;
    java.io.InputStream is = null;
    java.io.BufferedInputStream bis = null;

    // Object
    showDialog OShowDialog = new showDialog();

    @Override
    public void commandResource() throws showException {

        if (extractResource.OExplorer.getArchive().exists() && extractResource.OExplorer.getArchive().isFile()) {

            extractResource.OExplorer.save();

            if (extractResource.OExplorer.getArchive().getAbsolutePath() != null && extractResource.OExplorer.getDir().getAbsolutePath() != null){
                extractResource.OCreateResource.createDirResource(extractResource.OExplorer.getDir());

                StringBuilder cd = new StringBuilder();
                cd.append(System.getProperty("user.dir")).append("/").append("container").append("/").append("winrar").append("/").append("rar").append(" ").append("x").append(" ").append(extractResource.OExplorer.getArchive()).append(" ").append(extractResource.OCreateResource.getDirResource());

                if (extractResource.OCreateResource.getDirResource().exists() && extractResource.OCreateResource.getDirResource() != null && extractResource.OCreateResource.getDirResource().isDirectory() == true) {
                    try {
                        this.command = Runtime.getRuntime().exec(cd.toString());
                    } catch (showException | java.io.IOException e) {
                        e.printStackTrace(System.out);
                        throw new showException("Se produjo una excepción al intentar ejecutar comandos en consola(" + this.getClass() + ")\n\n");
                    }
                    this.is = this.command.getInputStream();
                    this.bis = new java.io.BufferedInputStream(this.is);

                    // Mensaje
                    this.OShowDialog.message("Recurso descomprimido correctamente, Puede que tome tiempo en ver resultados.\n\nSi usted considera que le ha sido de utilidad este software puede hacer\nuna donacion vía Paypal para que la herramienta se mantenga en pie", System.getProperty("user.dir") + "/container/images/perfect-2.png", new String[]{"Donar vía Paypal", "Aceptar"});
                } else {
                    this.OShowDialog.message("No has seleccionado una ruta para extraer el recurso\npor favor selecciona una ruta y vuelve a intentarlo", System.getProperty("user.dir") + "/container/images/cancel.png", new String[]{"Aceptar"});
                    if (run.index.depure == 1) {
                        System.out.println("El condicional anidado no se cumplío, Posiblemente el directorio de guardado no existe o es nulo(" + this.getClass() + ")\n\n");
                    }
                }
            }
        } else {
            this.OShowDialog.message("No has seleccionado un recurso o el formato de este no es soportado\npor favor seleccione un recurso correcto y vuelva a intentarlo", System.getProperty("user.dir") + "/container/images/cancel.png", new String[]{"Aceptar"});
            if (run.index.depure == 1) {
                System.out.println("El condicional no se cumplió, Posible mente no se a seleccionado un recurso o es null la ruta(" + this.getClass() + ")\n\n");
            }
        }
    }
}
