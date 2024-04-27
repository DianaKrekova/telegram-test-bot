package ru.telegram;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.telegram.bot.Bot;


public class App {
    public static void main(String[] args) throws TelegramApiException {
       Bot test = new Bot("6887676371:AAEawN1-FVH0OgkoFAx7nZDB5RX6hxvS3Es", "test");
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(test);
    }
}
