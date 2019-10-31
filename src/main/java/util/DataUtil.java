package util;

import model.Message;
import model.User;

import java.time.LocalDateTime;
import java.util.List;

public class DataUtil {

    public static void fillListOfMessages(List<Message> list) {
        list.add(new Message(new User("Petr"), "Привет!", LocalDateTime.of(2019, 10, 10, 10, 10)));
        list.add(new Message(new User("Valeri"), "Тестируем чат. Сообщения приходят? (+ в чат)", LocalDateTime.of(2019, 8, 10, 11, 10)));
        list.add(new Message(new User("Anon"), "+", LocalDateTime.of(2019, 10, 10, 12, 10)));
        list.add(new Message(new User("Luice"), "+", LocalDateTime.of(2019, 10, 13, 13, 10)));
        list.add(new Message(new User("Антон"), "+", LocalDateTime.of(2019, 10, 10, 15, 10)));
        list.add(new Message(new User("Aya"), "+", LocalDateTime.of(2019, 9, 10, 15, 10)));
    }

    public static void fillListOfUsers(List<User> users) {
        users.add(new User("Petr"));
        users.add(new User("Valeri"));
        users.add(new User("Anon"));
        users.add(new User("Luice"));
        users.add(new User("John"));
        users.add(new User("Антон"));
    }
}
