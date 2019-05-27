package controller;

import model.Model;

import java.io.File;
import java.util.List;

public interface Controller {

    void initModel (Model model);

    void onSelectFile(File file);

    void onGetListOfSheets();

    void onGetListOfColumns(String sheetName);

    void onSelectProperties(String sheetName, String columnName);

    void onSend(String login, String password, String subject, String letterText);

}
