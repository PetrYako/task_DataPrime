package model;

import java.time.LocalDateTime;

public class Message {

    private User user;
    private String text;
    private LocalDateTime localDateTime;

    public Message(User user, String message, LocalDateTime localDateTime) {
        this.user = user;
        this.text = message;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return user.getName() + " " +
                text + " " + localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public User getUser() {
        return user;
    }

    public String getText() {
        return text;
    }
}
