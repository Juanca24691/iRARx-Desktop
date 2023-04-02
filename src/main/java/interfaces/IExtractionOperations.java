package interfaces;

public interface IExtractionOperations {

    resource.showDialog OShowDialog = new resource.showDialog();

    resource.extractFile OExtractFile = new resource.extractFile();

    void openExtraction(java.io.File route) throws resource.showException;

    void removeExtraction(java.io.File routes) throws resource.showException;
}
