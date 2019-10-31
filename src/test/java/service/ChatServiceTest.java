package service;

import model.User;
import org.junit.Before;
import org.junit.Test;
import repository.inMemory.InMemoryMessageRepositoryImpl;
import repository.inMemory.InMemoryUserRepositoryImpl;

import static org.junit.Assert.*;
import static service.TestData.*;

public class ChatServiceTest {

    private InMemoryUserRepositoryImpl userRepository;
    private InMemoryMessageRepositoryImpl memoryMessageRepository;

    @Before
    public void init() {
        userRepository = new InMemoryUserRepositoryImpl();
        memoryMessageRepository = new InMemoryMessageRepositoryImpl();
    }

    @Test
    public void addMessage() {
        memoryMessageRepository.add(message);
        assertTrue(memoryMessageRepository.getAll().contains(message));
    }

    @Test
    public void addUser() {
        userRepository.add(user);
        assertTrue(userRepository.exist(user.getName()));
    }

    @Test
    public void getUsers() {
        assertNotNull(userRepository.getAll());
    }

    @Test
    public void getUser() {
        assertEquals(userRepository.getUser("Petr").getName(), "Petr");
    }

    @Test
    public void alreadyExists() {
        assertTrue(userRepository.exist(expected.getName()));
    }

    @Test
    public void notExists() {
        assertFalse(userRepository.exist(user.getName()));
    }
}