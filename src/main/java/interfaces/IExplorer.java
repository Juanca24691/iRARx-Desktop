package interfaces;

public interface IExplorer {

    void selectFile() throws src.showException;

    void extractionPath() throws src.showException;

    java.io.File getFileName();

    void setFileName(java.io.File file);

    java.io.File getFilePath();

    void setFilePath(java.io.File filePath);

    java.io.File getExtractionPathOne();

    void setExtractionPathOne(java.io.File absoluteRoute);

    java.io.File getExtractionPathTwo();

    void setExtractionPathTwo(java.io.File absoluteRoute);
}