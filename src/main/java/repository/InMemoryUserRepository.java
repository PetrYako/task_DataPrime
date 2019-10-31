package repository;

import model.User;

import java.util.List;

public interface InMemoryUserRepository {

    void add(User user);

    boolean exist(String user);

    User getUser(String name);

    List<User> getAll();
}
