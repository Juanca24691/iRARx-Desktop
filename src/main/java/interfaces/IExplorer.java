package interfaces;

import java.io.File;
import resource.showException;

public interface IExplorer {
    
    void openExplorer() throws showException;
    
    void save() throws showException;
    
    File getArchive();
    
    File getDir();
}
