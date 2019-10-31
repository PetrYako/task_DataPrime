package service;

import model.Message;
import model.User;

import java.time.LocalDateTime;

public class TestData {

    public static User user = new User("someone");
    public static Message message = new Message(user, "Hello", LocalDateTime.of(2019, 10, 10, 10, 10));

    public static User expected = new User("Petr");
}
