package model.message;

import view.SwingView;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ExcelAndMailerToSwingViewMessager implements ResultAndErrorMessager {

    private Map<Exception, String> errors;
    private SwingView swingView;

    public ExcelAndMailerToSwingViewMessager(SwingView swingView) {
        this.swingView = swingView;
        errors = new HashMap<>();
        addErrorsToMap();
    }

    @Override
    public void sendErrorMessage(Exception exception) {
        swingView.showErrorMessage(errors.get(exception));

    }

    @Override
    public void sendResultMessage(String message) {
        swingView.showResultMessage(message);
    }

    private void addErrorsToMap() {
        errors.put(new FileNotFoundException(), "Файл не найден");
        errors.put(new IncorrectEmailAddressException(), "Адрес почты отправителя указан неверно. \n" +
                "Возможна отправка только с @gmail.com или @mail.ru");
        errors.put(new NotEnoughElementsOnForm(), "Указано недостаточно данных");
        errors.put(new MessagingException(), "Ошибка отправки почты");
    }
}
