package com.awstraining.backend.business.notifyme;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotifyMeService {

    private final MessageSender messageSender;
//    private final Translator translator;
//    private final Sentiment sentiment;

    public String notifyMe(NotifyMeDO notifyMe) {
        String notifyMessage = notifyMe.text();
        messageSender.send(notifyMessage);
        return notifyMessage;

        // TODO: lab2
        //  1. Translate text from using translator.
        //  2. Change sending of text to "translated text" and return it.
        // TODO: lab3
        //  1. Detect sentiment of translated message.
        //  2. Change sending of text to "setiment: translated text" and return it.
    }
    
}
