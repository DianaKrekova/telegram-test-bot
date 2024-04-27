package ru.telegram.bot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {
    private static final Logger log = Logger.getLogger(Bot.class);

    @Getter
    @Setter
    private String botName;

    @Setter
    private String botToken;

    public Bot(String botToken, String botName) {
        this.botName = botName;
        this.botToken = botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        log.debug("Receive new Update. updateID: "+update.getUpdateId());

        Long chatId = update.getMessage().getChatId();
        String inputText = update.getMessage().getText();

        if (inputText.startsWith("/start")) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Hi! Let's start!");
            try {
                execute(message);
            }catch (TelegramApiException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        log.debug("Bot name"+botName);
        return botName;
    }

    @Override
    public String getBotToken() {
        log.debug("Bot token"+botToken);
        return botToken;
    }
}
