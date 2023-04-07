package interfaces;

public interface IDirectory {

    src.showDialog OShowDialog = new src.showDialog();

    src.extractFile OExtractFile = new src.extractFile();

    void create(java.io.File directory) throws src.showException;

    void open(java.io.File directory) throws src.showException;

    void remove(java.io.File directory) throws src.showException;

    java.io.File getDirectory();

    void setDirectory(java.io.File directory);
}