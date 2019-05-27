package model;

import model.mail.MailSender;
import model.mail.Sender;
import model.message.ExcelAndMailerToSwingViewMessager;
import model.message.IncorrectEmailAddressException;
import model.message.NotEnoughElementsOnForm;
import model.message.ResultAndErrorMessager;
import model.reader.ExcelApachePoi;
import model.reader.ExcelRepository;
import org.apache.poi.ss.usermodel.Sheet;
import view.SwingView;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExcelAndMailModel implements Model {

    private ExcelRepository excel;
    private Sender sender;
    private SwingView swingView;
    private ResultAndErrorMessager messager;

    private Map<String, Sheet> sheetsWithNameKeys;
    private Map<String, Integer> columnsNamesWithIds;
    private List<String> columnContent;

    public ExcelAndMailModel(SwingView swingView) {
        this.swingView = swingView;
        excel = new ExcelApachePoi();
        sender = new MailSender();
        messager = new ExcelAndMailerToSwingViewMessager(swingView);

    }

    private void throwErrorMessage(Exception exception) {
        messager.sendErrorMessage(exception);
    }

    private void throwResultMessage(String message) {
        messager.sendResultMessage(message);
    }

    public void onNullData() {
        messager.sendErrorMessage(new NotEnoughElementsOnForm());
    }

    public void onIncorrectMailingData() {
        messager.sendErrorMessage(new IncorrectEmailAddressException());
    }

    public void getSource(File file) {
        try {
            excel.connectToExcelTable(file);
        } catch (IOException e) {
            e.printStackTrace();
            throwErrorMessage(e);
        }
    }


    public void listOfSheetsRequest() {
        sheetsWithNameKeys = excel.getSheetsWithNameKeys();
        swingView.fillSheetsBox(new LinkedList<>(sheetsWithNameKeys.keySet()));
    }

    public void listOfColumnsRequest(String sheetName) {
        columnsNamesWithIds = excel.getColumnsNamesWithIds(sheetsWithNameKeys.get(sheetName));
        swingView.showColumnsOfSheet(new LinkedList<>(columnsNamesWithIds.keySet()));
    }

    public void listOfColumnContentRequest(String sheetName, String columnName) {
        columnContent = excel.getAllStringValuesFromColumnById(
                sheetsWithNameKeys.get(sheetName), columnsNamesWithIds.get(columnName));
        columnContent.remove(0);
        swingView.showSelectedContent(columnContent);
    }

    public void sendRequest(String login, String password, String subject, String letterText) {
        Properties sendProperties = new Properties();
        sendProperties.put("senderMail", login);
        sendProperties.put("password", password);
        sendProperties.put("subject", subject);
        sendProperties.put("text", letterText);
        try {
            sender.send(sendProperties, columnContent);
            throwResultMessage("Mails sent successfully");
        } catch (Exception e) {
            throwErrorMessage(e);
        }
    }

    @Override
    public void setViewInstance(SwingView view) {
        swingView = view;
        messager = new ExcelAndMailerToSwingViewMessager(swingView);
    }

}
