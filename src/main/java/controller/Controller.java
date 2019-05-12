package controller;

import java.io.File;
import java.util.List;

public interface Controller {

    void onSelectFile(File file);

    List<String> getListOfSheets();

    List<String> getListOfColumns(String sheetName);

    List<String> selectProperties(String sheetName, String columnName);

    void sendLetters(String login, String password, String subject, String letterText);

    void throwError(Exception exception);


}
