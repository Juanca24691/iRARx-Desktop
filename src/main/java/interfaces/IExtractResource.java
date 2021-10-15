package interfaces;

public interface IExtractResource {
    
    // Object
    resource.explorer OExplorer = new resource.explorer();
    resource.createResource OCreateResource = new resource.createResource();
    
    void commandResource() throws resource.showException;
    
}
