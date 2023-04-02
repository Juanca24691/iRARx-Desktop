package interfaces;

public interface IExtractFile {

    // Object
    resource.showDialog OShowDialog = new resource.showDialog();
    resource.explorer OExplorer = new resource.explorer();
    resource.createDirectory OCreatePath = new resource.createDirectory();

    void commandLine() throws resource.showException;

    void selectFile();

    java.io.File getFileName();

    void setFileName(java.io.File fileName);

    java.io.File getFilePath();

    void setFilePath(java.io.File filePath);

    void extractionPath();

    java.io.File getExtractionPathOne();

    void setExtractionPathOne(java.io.File extractionPathOne);

    java.io.File getExtractionPathTwo();

    void setExtractionPathTwo(java.io.File extractionPathTwo);

    void restoreOperations();

    String getPassword();

    void setPassword(String text);

}
