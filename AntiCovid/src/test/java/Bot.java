import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    public Bot() {
    }

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try {
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException var3) {
            var3.printStackTrace();
        }

    }

    public void sendMsg(Message message, String text, int lang) {
        SendMessage sendMessage = new SendMessage();
//        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);

        try {
            if (lang == 1) {
                this.setButtonsRussian(sendMessage);
            } else if (lang == 2) {
                this.setButtonsKazakh(sendMessage);
            } else if (lang == 3) {
                this.setLanguageButtons(sendMessage);
            }
            this.sendMessage(sendMessage);
        } catch (TelegramApiException var5) {
            var5.printStackTrace();
        }

    }

    public void sendImage(Message message, int choice) {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(message.getChatId().toString());
        switch (choice) {
            case 0:
                sendPhoto.setPhoto("https://imbt.ga/sVjQSWtPVY");
                break;
            case 1:
                sendPhoto.setPhoto("https://imbt.ga/y0342bSLcE");
                break;
            case 2:
                sendPhoto.setPhoto("https://imbt.ga/XPSRMyXpBm");
                break;
            case 3:
                sendPhoto.setPhoto("https://imbt.ga/U9AO7jtnpT");
                break;
            case 4:
                sendPhoto.setPhoto("https://imbt.ga/tVb0ECkDdX");
                break;
            case 5:
                sendPhoto.setPhoto("https://imbt.ga/9dkbEmW4Ip");
                break;
            case 6:
                sendPhoto.setPhoto("https://imbt.ga/mwWm4NA0FT");
                break;
            case 7:
                sendPhoto.setPhoto("https://imbt.ga/KwLo2208uq");
                break;
            case 8:
                sendPhoto.setPhoto("https://imbt.ga/SKLF5zb40I");
                break;
            case 9:
                sendPhoto.setPhoto("https://imbt.ga/mlx2EAK62i");
                break;
            default:
        }
        try {
            this.sendPhoto(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }


    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            String var4 = message.getText();
            byte var5 = -1;
            if (var4.equalsIgnoreCase("/start")) {
                var5 = 0;
            } else if (var4.equalsIgnoreCase("Русский")) {
                var5 = 1;
            } else if (var4.equalsIgnoreCase("Қазақша")) {
                var5 = 2;
            } else if (var4.equalsIgnoreCase("КАК ПРАВИЛЬНО ПРОВОДИТЬ ДЕЗИНФЕКЦИЮ?")) {
                var5 = 3;
            } else if (var4.equalsIgnoreCase("ОСНОВНЫЕ СИМПТОМЫ КОРОНАВИРУСА")) {
                var5 = 4;
            } else if (var4.equalsIgnoreCase("ТОП СТРАН КОТОРЫЕ НЕ СТОИТ ПОСЕЩАТЬ В БЛИЖАЙШЕЕ ВРЕМЯ")) {
                var5 = 5;
            } else if (var4.equalsIgnoreCase("ГДЕ В КЗ(Алматы) ПРОВОДИТСЯ ТЕСТ НА ВЫЯВЛЕНИЕ КОРОНАВИРУСА?")) {
                var5 = 6;
            } else if (var4.equalsIgnoreCase("ИНТЕРЕСНЫЕ ФАКТЫ О КОРОНАВИРУСЕ")) {
                var5 = 7;
            } else if (var4.equalsIgnoreCase("ДЕЗИНФЕКЦИЯНЫ ДҰРЫС ҚАЛАЙ ЖҮРГІЗУ ҚАЖЕТ?")) {
                var5 = 8;
            } else if (var4.equalsIgnoreCase("КОРОНАВИРУСТЫҢ БАСТЫ БЕЛГІЛЕРІ")) {
                var5 = 9;
            } else if (var4.equalsIgnoreCase("ЖАҚЫН АРАДА БАРУҒА БОЛМАЙТЫН ТОП ЕЛДЕР")) {
                var5 = 10;
            } else if (var4.equalsIgnoreCase("Қазақстанда(Алматыда) қай жерде коронавирусты анықтау тесті жүргізіледі?")) {
                var5 = 11;
            } else if (var4.equalsIgnoreCase("КОРОНАВИРУС ТУРАЛЫ ҚЫЗЫҚТЫ ФАКТІЛЕР")) {
                var5 = 12;
            } else if (var4.equalsIgnoreCase("НОВОСТИ ПРО КОРОНОВИРУС") || var4.equalsIgnoreCase("КОРОНОВИРУС ТУРАЛЫ ЖАҢАЛЫҚТАР")) {
                var5 = 13;
            } else if (var4.equalsIgnoreCase("ТОП 10 АПТЕК В АЛМАТЕ") || var4.equalsIgnoreCase("АЛМАТЫДАҒЫ ТОП 10 ДӘРІХАНАЛАР")) {
                var5 = 14;
            } else if (var4.equalsIgnoreCase("ЗАКОНЫ О КАРАНТИНЕ") || var4.equalsIgnoreCase("КАРАНТИН ТУРАЛЫ ЗАҢНАМА")) {
                var5 = 15;
            }else if (var4.equalsIgnoreCase("ЧИСЛО ЗАРАЖЕННЫХ В ТОПЕ ЗАРАЖЕННЫХ СТРАН И В КАЗАХСТАНЕ") || var4.equalsIgnoreCase("КОРОНОВИРУСПЕН АУЫРҒАНДАРДЫҢ САНЫ")) {
                var5 = 16;
            }else if (var4.equalsIgnoreCase("ЧРЕЗВЫЧАЙНОЕ ПОЛОЖЕНИЕ") || var4.equalsIgnoreCase("ТӨТЕНШЕ ЖАҒДАЙ ТУРАЛЫ")) {
                var5 = 17;
            }

            switch (var5) {
                case 0:
                    this.sendMsg(message, "Здравствуйте, выберите язык: ", 3);
                    break;
                case 16:
                    Parsing parsingConfirms = null;
                    try {
                        parsingConfirms = new Parsing();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    this.sendMsg(message, parsingConfirms.getConfirms(), 1);
                    break;
                case 1:
                    this.sendMsg(message, "Вас приветствует COVID-19-BOT-KZ. Здесь вы можете найти достоверную информацию про коронавирус и ситуацию в стране. Что вы хотели узнать?", 1);
                    break;
                case 2:
                    this.sendMsg(message, "COVID-19-BOT-KZ Сізге сәлем береді. Бұл жерде сіз коронавирус туралы және елдегі жағдай туралы сенімді ақпарат таба аласыз. Не білгіңіз келеді?", 2);
                    break;
                case 15:
                    this.sendMsg(message, "Статья 305. Сокрытие информации об обстоятельствах, создающих опасность для жизни или здоровья людей\n" +
                            "1. Сокрытие или искажение информации о событиях, фактах или явлениях, создающих опасность для жизни или здоровья людей либо для окружающей среды, совершенное лицом, обязанным обеспечивать население такой информацией, –\n" +
                            "\n" +
                            "наказывается штрафом в размере до двух тысяч месячных расчетных показателей либо исправительными работами в том же размере, либо привлечением к общественным работам на срок до шестисот часов, либо ограничением свободы на срок до двух лет, либо лишением свободы на тот же срок, с лишением права занимать определенные должности или заниматься определенной деятельностью на срок до трех лет или без такового.\n" +
                            "\n" +
                            "2. То же деяние, повлекшее по неосторожности причинение вреда здоровью человека либо иные тяжкие последствия", 2);
                    break;
                case 14:
                    this.sendMsg(message, "1)АптекаПлюс - ул. Ауэзова, 175, уг. ул. Габдуллина\n" +
                            "Номер телефона+7 727 274 07 07\n" +
                            "2)24 часа мкр. 5, пр. Абая, уг. пр. Алтынсарина\n" +
                            "3)Сеть Аптек мкр. Орбита-4, 32, ул. Биржана\n" +
                            "Номер телефона+7 727 229 37 08\n" +
                            "4)Аза ул. Толе би , д. 159\n" +
                            "Номер телефона+7 727 3796082\n" +
                            "5)Центральная аптека пр. Назарбаева, 91/97, уг. ул. Гоголя\n" +
                            "Номер телефона+7 727 273 07 07\n" +
                            "6)Керуен-Medicus бул. Бухар Жырау, 45/1, уг. ул. Байзакова\n" +
                            "Номер телефона+7 727 220 70 70\n" +
                            "7)Ремедиум пр. Жибек жолы , д. 39\n" +
                            "Номер телефона+ 727 397 73 73\n" +
                            "8)Точка ул. Байтурсынова , д. 41/43\n" +
                            "Номер телефона+7 727 2927593\n" +
                            "9)Айдаке-фарм мкр.-2, 50\n" +
                            "Номер телефона+7 727 276 04 74\n" +
                            "10)Аптека 36'6 мкр. Таугуль-1 , д. 19\n" +
                            "Номер телефона+7 727 2966136", 2);
                    break;
                case 13:
                    Parsing parsing = null;
                    try {
                        parsing = new Parsing();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String[] articles = parsing.getArticles();
                    for (int i = 0; i < articles.length; i++) {
                        this.sendMsg(message, articles[i], 1);
                    }
                    break;
                case 17:
                    this.sendMsg(message, "ОГРАНИЧИВАЕТСЯ ФУНКЦИОНИРОВАНИЕ КРУПНЫХ ОБЪЕКТОВ ТОРГОВЛИ \n" +
                            "ПРИОСТАНАВЛИВАЕТСЯ  ДЕЯТЕЛЬНОСТЬ ТРЦ, КИНОТЕАТРОВ, ТЕАТРОВ И ДРУГИХ ОБЪЕКТОВ С  МАССОВЫМ СКОПЛЕНИЕМ ЛЮДЕЙ\n" +
                            "ВВОДИТСЯ КАРАНТИН, ОСУЩЕСТВЛЯЮТСЯ МАСШТАБНЫЕ САНИТАРНО-ПРОТИВОЭПИДЕМИЧЕСКИЕ МЕРОПРИЯТИЯ \n" +
                            "ЗАПРЕЩАЕТСЯ ПРОВЕДЕНИЕ ЗРЕЛИЩНЫХ, СПОРТИВНЫХ И ДРУГИХ МАССОВЫХ МЕРОПРИЯТИЙ.\n" +
                            "УСТАНАВЛИВАЕТСЯ ОГРАНИЧЕНИЯ НА ВЪЕЗД НА ТЕР. РК , А ТАКЖЕ НА ВЫЕЗД С ЕЁ ТЕР. ВСЕМИ ВИДАМИ ТРАНСПОРТА, ЗА ИСКЛЮЧЕНИЕМ ПЕРСОНАЛА ДИПЛОМАТИЧЕСКОЙ СЛУЖБЫ РК И ИНОСТР. ГОСУДАРСТВ, А ТАКЖЕ ЧЛЕНОВ ДЕЛЕГАЦИЙ МЕЖДУНАРОДНЫХ ОРГАНИЗАЦИЙ, НАПРАВЛЯЮЩИХСЯ В РК ПО ПРИГЛАШЕНИЮ МИД РК.", 1);
                    break;
                default:
                    if ((var5 >= 3 && var5 <= 12)) this.sendImage(message, var5 - 3);
            }
        }

    }

    public void setButtonsRussian(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("НОВОСТИ ПРО КОРОНОВИРУС"));
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("КАК ПРАВИЛЬНО ПРОВОДИТЬ ДЕЗИНФЕКЦИЮ?"));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("ОСНОВНЫЕ СИМПТОМЫ КОРОНАВИРУСА"));
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(new KeyboardButton("ТОП СТРАН КОТОРЫЕ НЕ СТОИТ ПОСЕЩАТЬ В БЛИЖАЙШЕЕ ВРЕМЯ"));
        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow4.add(new KeyboardButton("ГДЕ В КЗ(Алматы) ПРОВОДИТСЯ ТЕСТ НА ВЫЯВЛЕНИЕ КОРОНАВИРУСА?"));
        KeyboardRow keyboardRow5 = new KeyboardRow();
        keyboardRow5.add(new KeyboardButton("ИНТЕРЕСНЫЕ ФАКТЫ О КОРОНАВИРУСЕ"));
        KeyboardRow keyboardRow6 = new KeyboardRow();
        keyboardRow6.add(new KeyboardButton("ТОП 10 АПТЕК В АЛМАТЕ"));
        KeyboardRow keyboardRow7 = new KeyboardRow();
        keyboardRow7.add(new KeyboardButton("ЗАКОНЫ О КАРАНТИНЕ"));
        KeyboardRow keyboardRow8 = new KeyboardRow();
        keyboardRow8.add(new KeyboardButton("ЧИСЛО ЗАРАЖЕННЫХ В ТОПЕ ЗАРАЖЕННЫХ СТРАН И В КАЗАХСТАНЕ"));
        KeyboardRow keyboardRow9 = new KeyboardRow();
        keyboardRow9.add(new KeyboardButton("ЧРЕЗВЫЧАЙНОЕ ПОЛОЖЕНИЕ"));
        keyboardRowList.add(keyboardRow);
        keyboardRowList.add(keyboardRow8);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        keyboardRowList.add(keyboardRow3);
        keyboardRowList.add(keyboardRow4);
        keyboardRowList.add(keyboardRow5);
        keyboardRowList.add(keyboardRow6);
        keyboardRowList.add(keyboardRow7);
        keyboardRowList.add(keyboardRow9);

        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setButtonsKazakh(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("КОРОНОВИРУС ТУРАЛЫ ЖАҢАЛЫҚТАР"));
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("ДЕЗИНФЕКЦИЯНЫ ДҰРЫС ҚАЛАЙ ЖҮРГІЗУ ҚАЖЕТ?"));
        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("КОРОНАВИРУСТЫҢ БАСТЫ БЕЛГІЛЕРІ"));
        KeyboardRow keyboardRow3 = new KeyboardRow();
        keyboardRow3.add(new KeyboardButton("ЖАҚЫН АРАДА БАРУҒА БОЛМАЙТЫН ТОП ЕЛДЕР"));
        KeyboardRow keyboardRow4 = new KeyboardRow();
        keyboardRow4.add(new KeyboardButton("Қазақстанда(Алматыда) қай жерде коронавирусты анықтау тесті жүргізіледі?"));
        KeyboardRow keyboardRow5 = new KeyboardRow();
        keyboardRow5.add(new KeyboardButton("КОРОНАВИРУС ТУРАЛЫ ҚЫЗЫҚТЫ ФАКТІЛЕР"));
        KeyboardRow keyboardRow6 = new KeyboardRow();
        keyboardRow6.add(new KeyboardButton("АЛМАТЫДАҒЫ ТОП 10 ДӘРІХАНАЛАР"));
        KeyboardRow keyboardRow7 = new KeyboardRow();
        keyboardRow7.add(new KeyboardButton("КАРАНТИН ТУРАЛЫ ЗАҢНАМА"));
        KeyboardRow keyboardRow8 = new KeyboardRow();
        keyboardRow8.add(new KeyboardButton("КОРОНОВИРУСПЕН АУЫРҒАНДАРДЫҢ САНЫ"));
        KeyboardRow keyboardRow9 = new KeyboardRow();
        keyboardRow9.add(new KeyboardButton("ЧРЕЗВЫЧАЙНОЕ ПОЛОЖЕНИЕ"));
        keyboardRowList.add(keyboardRow);
        keyboardRowList.add(keyboardRow8);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        keyboardRowList.add(keyboardRow3);
        keyboardRowList.add(keyboardRow4);
        keyboardRowList.add(keyboardRow5);
        keyboardRowList.add(keyboardRow6);
        keyboardRowList.add(keyboardRow7);
        keyboardRowList.add(keyboardRow9);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public void setLanguageButtons(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        keyboardFirstRow.add(new KeyboardButton("Қазақша"));
        keyboardFirstRow.add(new KeyboardButton("Русский"));
        keyboardRowList.add(keyboardFirstRow);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
    }

    public String getBotUsername() {
        return "hackathonCovid_bot";
    }

    public String getBotToken() {
        return "1144001990:AAFXOD0WHP9DyAN4yCmOwwTZ1wvCawAwwEM";
    }
}
