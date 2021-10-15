package interfaces;

public interface IExplorer {
    
    void openExplorer() throws resource.showException;
    
    void save() throws resource.showException;

    java.io.File getArchive();

    java.io.File getDir();
}
