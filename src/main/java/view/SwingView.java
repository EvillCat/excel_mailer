package view;

import java.util.Collection;
import java.util.List;

public interface SwingView {

    void fillSheetsBox(List<String> sheets);

    void showColumnsOfSheet(List<String> columns);

    void showSelectedContent(List<String> columnContent);

    void showErrorMessage(String text);

    void showResultMessage(String text);

    void start();

}
