package interfaces;

import java.io.File;
import resource.showException;

public interface ICreateResource {
    
    void createDirResource(File dir) throws showException;
    
    File getDirResource();
}
