package com.tapas.whatsapp;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class WhatsappApplication {
    /**
     * From the Free Twillio Account
     */
    public static final String ACCOUNT_SID = "ACf3501e00ce056c4d7f5854d2dffe72d8";
    public static final String AUTH_TOKEN = "7490fc9d4a4fea99a2318fdaf0a86f5b";

    public static void main(String[] args) {
        SpringApplication.run(WhatsappApplication.class, args);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        String text = "Hello from your friendly neighborhood Java application!!";

        /**
         * Send the whole text
         */
        WhatsappApplication.sendMsg(text);

        /**
         * Send every word of the text as a new message
         */
        String[] st = text.split("\\s+");
        Arrays.stream(st).forEach(WhatsappApplication::sendMsg);

    }

    private static void sendMsg(String text) {

        Message.creator(
                new PhoneNumber("whatsapp:+917978675991"),
                new PhoneNumber("whatsapp:+14155238886"),
                text)
                .create();
    }
}
