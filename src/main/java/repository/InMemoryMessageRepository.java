package repository;

import model.Message;

import java.time.LocalDateTime;
import java.util.List;

public interface InMemoryMessageRepository {

    void add(Message message);

    List<Message> getAll();
}
