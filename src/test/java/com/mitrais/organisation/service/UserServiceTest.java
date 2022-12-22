package com.mitrais.organisation.service;

import com.mitrais.organisation.repository.UserRepository;
import com.mitrais.organisation.repository.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @MockBean
    private UserRepository myRepository;

    @Autowired
    private UserService myService;

    @Test
    public void testGetById() {
        when(myRepository.findById("123")).thenReturn(Optional.of(new User("123", "name", 23)));
        Optional<User> user = myService.getById("123");
        assertEquals("123", user.get().getId());
        assertEquals("name", user.get().getName());
        verify(myRepository, times(1)).findById(anyString());
    }

    @Test
    public void testGetAll() {
        User user1 = new User("123", "name1", 23);
        User user2 = new User("456", "name2", 24);
        when(myRepository.findAll()).thenReturn(List.of(user1, user2));
        List<User> entities = myService.getAll();
        assertEquals(2, entities.size());
        assertEquals("123", entities.get(0).getId());
        assertEquals("name1", entities.get(0).getName());
        assertEquals(23, entities.get(0).getAge());
        assertEquals("456", entities.get(1).getId());
        assertEquals("name2", entities.get(1).getName());
        assertEquals(24, entities.get(1).getAge());
        verify(myRepository, times(1)).findAll();
    }

    @Test
    public void testEdit() {
        User user = new User("123", "new name", 23);
        doReturn(user).when(myRepository).save(user);

        User editedEntity = myService.update(user);
        assertEquals("123", editedEntity.getId());
        assertEquals("new name", editedEntity.getName());
        verify(myRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testDelete() {
        myService.deleteById("123");
        verify(myRepository, times(1)).deleteById(anyString());
    }
}