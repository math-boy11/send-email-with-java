package com.mathboy11;

import jakarta.activation.FileDataSource;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //Uncomment the following methods to send all diffrent types of email

        //sendSimple();
        //sendHtml();
        //sendAttachment();
    }

    private static void sendSimple() {
        Email email = EmailBuilder.startingBlank()
                .from("Theo", "theostechtipsinquiries@gmail.com")
                .to("Other Theo", "theostechtipsinquiries@gmail.com")
                .withSubject("Hello world")
                .withPlainText("Hello world")
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "theostechtipsinquiries@gmail.com", "pbbasrnhepxwjalo")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();

        mailer.sendMail(email);
    }

    private static void sendHtml() {
        Email email = EmailBuilder.startingBlank()
                .from("Theo", "theostechtipsinquiries@gmail.com")
                .to("Other Theo", "theostechtipsinquiries@gmail.com")
                .withSubject("hey")
//                .withHTMLText("<h1>Hello world!</h1><p>Success!<p>")
                .withHTMLText(new File("/Users/theo/Downloads/test.html"))
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "theostechtipsinquiries@gmail.com", "pbbasrnhepxwjalo")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();

        mailer.sendMail(email);
    }

    private static void sendAttachment() {
        Email email = EmailBuilder.startingBlank()
                .from("Theo", "theostechtipsinquiries@gmail.com")
                .to("Other Theo", "theostechtipsinquiries@gmail.com")
                .withSubject("hey")
                .withPlainText("We should meet up! ;)")
                .withAttachment("test.pdf", new FileDataSource("/Users/theo/Downloads/test.pdf"))
                .buildEmail();

        Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "theostechtipsinquiries@gmail.com", "pbbasrnhepxwjalo")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .buildMailer();

        mailer.sendMail(email);
    }
}