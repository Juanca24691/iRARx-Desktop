package interfaces;

import resource.createResource;
import resource.explorer;
import resource.showException;

public interface IExtractResource {
    
    // Object
    explorer OExplorer = new explorer();
    createResource OCreateResource = new createResource();
    
    void commandResource() throws showException;
    
}
