package interfaces;

public interface IExtractFile {

    // Object
    src.showDialog OShowDialog = new src.showDialog();

    src.explorer OExplorer = new src.explorer();

    src.directory ODirectory = new src.directory();

    void commandLine() throws src.showException;

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