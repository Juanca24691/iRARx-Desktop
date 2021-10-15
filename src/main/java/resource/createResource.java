package resource;

public class createResource implements interfaces.ICreateResource{
    
    private static java.io.File resource;

    @Override
    public void createDirResource(java.io.File dir) {
        if (!dir.exists() && dir.getAbsolutePath() != null) {
            createResource.resource = new java.io.File(dir.getAbsolutePath());
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
    public java.io.File getDirResource() {
        return createResource.resource;
    }
    
}
