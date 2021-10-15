package interfaces;

public interface ICreateResource {

    void createDirResource(java.io.File dir) throws resource.showException;

    java.io.File getDirResource();
}
