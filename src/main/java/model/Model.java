package model;

import view.SwingView;

import java.io.File;

public interface Model {

    void getSource(File file);

    void listOfSheetsRequest();

    void listOfColumnsRequest(String sheetName);

    void listOfColumnContentRequest(String sheetName, String columnName);

    void sendRequest(String login, String password, String subject, String letterText);

    void setViewInstance(SwingView view);
}
