package interfaces;

public interface IDirectory {

    resource.showDialog OShowDialog = new resource.showDialog();

    resource.extractFile OExtractFile = new resource.extractFile();

    void create(java.io.File directory) throws resource.showException;

    void open(java.io.File directory) throws resource.showException;

    void remove(java.io.File directory) throws resource.showException;

    java.io.File getDirectory();

    void setDirectory(java.io.File directory);

}