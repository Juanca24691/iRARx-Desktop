package resource;

import java.io.File;
import interfaces.ICreateResource;

public class createResource implements ICreateResource{
    
    private static File resource;

    @Override
    public void createDirResource(File dir) {
        if (dir.exists() == false && dir.getAbsolutePath() != null) {
            createResource.resource = new File(dir.getAbsolutePath());
            this.getDirResource().mkdir();
            if (run.index.depure == 1) {
                System.out.println("Se creo el recurso requerido(" + this.getClass() + ")\n\n");
            }
        }else{
            if (run.index.depure == 1) {
                System.out.println("No se pudo crear el recurso requerido(" + this.getClass() + ")\n\n");
            }
        }
    }

    @Override
    public File getDirResource() {
        return createResource.resource;
    }
    
}
