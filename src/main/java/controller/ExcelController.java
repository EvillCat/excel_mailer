package controller;

import message.ErrorMessager;
import model.mail.Sender;
import model.reader.ExcelApachePoi;
import org.apache.poi.ss.usermodel.Sheet;
import view.MainWindow;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExcelController implements Controller {

    private ExcelApachePoi excel;
    private MainWindow window;
    private Map<String, Sheet> sheetsWithNameKeys;
    private Map<String, Integer> columnsNamesWithIds;
    private List<String> columnContent;
    private Sender sender;

    //TODO Контроллер не должен принимать mainwindow
    //TODO Класс-модель должен быть проксирующим классом для других классов
    //TODO Sender и ExcelApachePoi должны передаваться в качестве параметров в конструкторе
    public ExcelController(MainWindow window) {
        excel = new ExcelApachePoi();
        this.window = window;
        columnContent = null;
        sender = new Sender(this);
    }

    @Override
    public void onSelectFile(File file) {
        try {
            excel.connectToExcelTable(file);
        } catch (Exception exception) {
            throwError(exception);
        }
    }

    @Override
    public List<String> getListOfSheets() {
        sheetsWithNameKeys = excel.getSheetsWithNameKeys();
        return new LinkedList<>(sheetsWithNameKeys.keySet());
    }

    @Override
    public List<String> getListOfColumns(String sheetName) {
        columnsNamesWithIds = excel.getColumnsNamesWithIds(sheetsWithNameKeys.get(sheetName));
        return new LinkedList<>(columnsNamesWithIds.keySet());
    }

    @Override
    public List<String> selectProperties(String sheetName, String columnName) {
        columnContent = excel.getAllStringValuesFromColumnById(
                sheetsWithNameKeys.get(sheetName), columnsNamesWithIds.get(columnName));
        columnContent.remove(0);
        return columnContent;
    }

    @Override
    public void sendLetters(String login, String password, String subject, String letterText) {
        try {
            sender.send(login, password, subject, letterText, columnContent);
            showSuccessText();
        } catch (ErrorMessager.IncorrectEmailAddressException e) {
            throwError(e);
        }

    }

    @Override
    public void throwError(Exception exception) {
        window.setResultLabelTextColorRed(ErrorMessager.getErrorMassage(exception));
    }

    private void showSuccessText() {
        window.setResultLabelTextColorGreen("Сообщение отправлено успешно");
    }
}
