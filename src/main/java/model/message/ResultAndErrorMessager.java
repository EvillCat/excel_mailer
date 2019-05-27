package model.message;

public interface ResultAndErrorMessager {

    void sendErrorMessage(Exception exception);

    void sendResultMessage(String message);
}
