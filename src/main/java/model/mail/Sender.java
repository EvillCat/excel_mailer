package model.mail;

import controller.Controller;
import message.ErrorMessager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class Sender {

    private Properties mailProperties;
    private Controller controller;

    public Sender (Controller controller) {
        this.controller = controller;
    }

    private void loadProperties(String senderEmail) throws ErrorMessager.IncorrectEmailAddressException {
        mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        if (senderEmail.contains("@gmail.com")) {
            mailProperties.put("mail.smtp.host", "smtp.gmail.com");
            mailProperties.put("mail.smtp.port", "587");

        } else if (senderEmail.contains("@mail.ru")) {
            mailProperties.put("mail.smtp.host", "smtp.mail.ru");
            mailProperties.put("mail.smtp.port", "465");
        } else {
            throw new ErrorMessager.IncorrectEmailAddressException();
        }
    }

    private InternetAddress[] convertStringsArrayToInternetAddressArray (List<String> addresses) {
        InternetAddress[] internetAdresses = new InternetAddress[addresses.size()];
        int i = 0;
        for (String address : addresses) {
            internetAdresses[i] = new InternetAddress();
            internetAdresses[i].setAddress(address);
            i++;
        }
        return internetAdresses;
    }

    public void send(String senderMail, String password, String subject, String text, List<String> addresses)
            throws ErrorMessager.IncorrectEmailAddressException {

        loadProperties(senderMail);
        Session session = Session.getDefaultInstance(mailProperties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderMail));
            message.setRecipients(Message.RecipientType.BCC,
                    convertStringsArrayToInternetAddressArray(addresses));
            message.setSubject(subject);
            message.setText(text, "UTF-8");
            Transport.send(message);
        } catch (MessagingException e) {
            controller.throwError(e);
        }
    }


}
