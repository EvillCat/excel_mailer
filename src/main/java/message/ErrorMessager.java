package message;

public class ErrorMessager {


    public static String getErrorMassage(Exception exception) {

        switch (exception.getClass().getSimpleName()) {
            case "FileNotFoundException": return "Файл не найден";
                //break;
            case "IncorrectEmailAddressException": return "Адрес почты отправителя указан неверно \n" +
                    "Возможна отправка только с @gmail.com или @mail.ru";
            case "NotEnoughElementsOnForm": return "Указано недостаточно данных";
            case "MessagingException": return "Ошибка отправки почты";
            default: return "Неизвестная ошибка";

        }

    }

    public static class IncorrectEmailAddressException extends Exception {
    }

    public static class NotEnoughElementsOnForm extends Exception {
    }


}
