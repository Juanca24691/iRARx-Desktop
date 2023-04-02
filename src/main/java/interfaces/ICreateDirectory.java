package interfaces;

public interface ICreateDirectory {

    void createDirectory(java.io.File directory) throws resource.showException;

    java.io.File getDirectory();
    void setDirectory(java.io.File directory);
}
