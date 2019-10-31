package repository.inMemory;

import model.User;
import repository.InMemoryUserRepository;
import util.DataUtil;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InMemoryUserRepositoryImpl implements InMemoryUserRepository {

    private List<User> users = new ArrayList<>();

    public InMemoryUserRepositoryImpl() {
        DataUtil.fillListOfUsers(users);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public boolean exist(String user) {
        return users.stream()
                .anyMatch(u -> u.getName().equals(user));
    }

    @Override
    public User getUser(String name) {
        return users.stream()
                .filter(u1 -> u1.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAll() {
        users.sort(Comparator.comparing(User::getName));
        return users;
    }
}
