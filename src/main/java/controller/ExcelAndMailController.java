package controller;

import model.Model;

import java.io.File;

public class ExcelAndMailController implements Controller {

    private Model model;

    public ExcelAndMailController() {

    }

    public void initModel (Model model) {
        this.model = model;
    }

    @Override
    public void onSelectFile(File file) {
        model.getSource(file);
    }

    @Override
    public void onGetListOfSheets() {
        model.listOfSheetsRequest();
    }

    @Override
    public void onGetListOfColumns(String sheetName) {
        model.listOfColumnsRequest(sheetName);
    }

    @Override
    public void onSelectProperties(String sheetName, String columnName) {
        model.listOfColumnContentRequest(sheetName, columnName);
    }

    @Override
    public void onSend(String login, String password, String subject, String letterText) {
        model.sendRequest(login, password, subject, letterText);
    }
}
