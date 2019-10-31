package service;

import model.Message;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.inMemory.InMemoryMessageRepositoryImpl;
import repository.inMemory.InMemoryUserRepositoryImpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ChatService {
    private static final Logger log = LoggerFactory.getLogger(ChatService.class);

    private InMemoryUserRepositoryImpl userRepository;
    private InMemoryMessageRepositoryImpl memoryMessageRepository;

    public void init() {
        userRepository = new InMemoryUserRepositoryImpl();
        memoryMessageRepository = new InMemoryMessageRepositoryImpl();
    }

    public void addMessage(String message, String time, String user) {
        LocalDateTime localDateTime = LocalDateTime.parse(time);
        User u = userRepository.getUser(user);
        log.info("add message {} from user {} in {}", message, user, localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm")));
        memoryMessageRepository.add(new Message(u, message, localDateTime));
    }

    public void addUser(String user) {
        User newUser = new User(user);
        log.info("add user{}", newUser);
        userRepository.add(newUser);
    }

    public List<User> getUsers() {
        log.info("getUsers");
        log.info(userRepository.getAll().toString());
        return userRepository.getAll();
    }

    public User getUser(String name) {
        log.info("get user {}", name);
        return userRepository.getUser(name); }

    public List<Message> getMessages()
    {
        log.info("getMessages");
        return memoryMessageRepository.getAll();
    }

    public boolean alreadyExists(String user) {
        log.info("check for existing user {}", user);
        return userRepository.exist(user);
    }
}
