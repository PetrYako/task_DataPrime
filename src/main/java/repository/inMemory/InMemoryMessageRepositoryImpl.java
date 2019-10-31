package repository.inMemory;

import model.Message;
import model.User;
import repository.InMemoryMessageRepository;
import util.DataUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InMemoryMessageRepositoryImpl implements InMemoryMessageRepository {

    private List<Message> messages = new ArrayList<>();

    public InMemoryMessageRepositoryImpl() {
        DataUtil.fillListOfMessages(messages);
    }

    @Override
    public void add(Message message) {
        messages.add(message);
    }

    @Override
    public List<Message> getAll() {
        messages.sort(Comparator.comparing(Message::getLocalDateTime));
        return messages;
    }
}
