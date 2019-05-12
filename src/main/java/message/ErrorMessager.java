package message;

public class ErrorMessager {


    public static String getErrorMassage(Exception exception) {

        switch (exception.getClass().getSimpleName()) {
            case "FileNotFoundException": return "���� �� ������";
                //break;
            case "IncorrectEmailAddressException": return "����� ����� ����������� ������ ������� \n" +
                    "�������� �������� ������ � @gmail.com ��� @mail.ru";
            case "NotEnoughElementsOnForm": return "������� ������������ ������";
            case "MessagingException": return "������ �������� �����";
            default: return "����������� ������";

        }

    }

    public static class IncorrectEmailAddressException extends Exception {
    }

    public static class NotEnoughElementsOnForm extends Exception {
    }


}
