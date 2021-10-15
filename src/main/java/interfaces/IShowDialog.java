package interfaces;

public interface IShowDialog {
    void message(String message, String image, String[] buttons) throws resource.showException;
}
