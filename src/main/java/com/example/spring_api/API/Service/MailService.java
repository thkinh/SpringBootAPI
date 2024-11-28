package com.example.spring_api.API.Service;

import java.util.Properties;


import org.springframework.stereotype.Service;
import jakarta.mail.*;
import jakarta.mail.internet.*;



@Service
public class MailService {  

    private final String from;
    private final String password;
    private final String host;
    // Default constructor
    public MailService() {
        this.from = "thkinh2008@gmail.com";
        this.password = "yuemkfwazqipomrg"; // Make sure this is a secure app-specific password
        this.host = "smtp.gmail.com";
    }

    
    // Parameterized constructor
    public MailService(String from, String password, String host) {
        this.from = from;
        this.password = password;
        this.host = host;
    }

    public Boolean sendEmail(String to) {
        try {
            // Set up properties for the SMTP server
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "465");

            // Create a new session with an authenticator
            Session session = Session.getInstance(properties, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            });

            String subject;
            String body;
            subject = "Android Pot Hole Detector ";
            body = "Your serect code: 5555";

            // Create the email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            // Send the email
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            return false;
        }
    };
}

