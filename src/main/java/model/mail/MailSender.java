package model.mail;

import model.message.IncorrectEmailAddressException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class MailSender implements Sender {

    private Properties mailProperties;

    private void loadProperties(String senderEmail)
            throws IncorrectEmailAddressException {
        mailProperties = new Properties();
        mailProperties.put("mail.smtp.auth", "true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        if (senderEmail.contains("@gmail.com")) {
            mailProperties.put("mail.smtp.host", "smtp.gmail.com");
            mailProperties.put("mail.smtp.port", "587");

        } else if (senderEmail.contains("@mail.ru")) {
            mailProperties.put("mail.smtp.host", "smtp.mail.ru");
            mailProperties.put("mail.smtp.port", "465");
            mailProperties.put("mail.smtp.ssl.enable", "true");
            mailProperties.put("mail.smtp.socketFactory.port", "465");
            mailProperties.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
        } else {
            throw new IncorrectEmailAddressException();
        }
    }

    private InternetAddress[] convertStringsArrayToInternetAddressArray(List<String> addresses) {
        InternetAddress[] internetAdresses = new InternetAddress[addresses.size()];
        int i = 0;
        for (String address : addresses) {
            internetAdresses[i] = new InternetAddress();
            internetAdresses[i].setAddress(address);
            i++;
        }
        return internetAdresses;
    }

    /**
     * @param sendProperties requires String params 'senderMail', 'password', 'subject', 'text'.
     * @param receivers      requires a String List of receivers e-mail addresses.
     * @throws IncorrectEmailAddressException
     *                                                          when senderMail is incorrect.
     * @throws MessagingException when password incorrect, mail server don't respond and etc.
     */
    @Override
    public void send(Properties sendProperties, List<String> receivers)
            throws IncorrectEmailAddressException, MessagingException {
        String senderMail = sendProperties.getProperty("senderMail");
        String password = sendProperties.getProperty("password");
        String subject = sendProperties.getProperty("subject");
        String text = sendProperties.getProperty("text");
        loadProperties(senderMail);
        Session session = Session.getDefaultInstance(mailProperties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderMail, password);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderMail));
        message.setRecipients(Message.RecipientType.BCC,
                convertStringsArrayToInternetAddressArray(receivers));
        message.setSubject(subject);
        message.setText(text, "UTF-8");
        Transport.send(message);
    }
}
