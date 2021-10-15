package interfaces;

import resource.showException;

public interface IShowDialog {
    void message(String message, String image, String[] buttons) throws showException;
}
