package com.mitrais.organisation.controller;

import com.mitrais.organisation.repository.entity.User;
import com.mitrais.organisation.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetAll() throws Exception {
        User user = new User("123", "John", 21);
        when(userService.getAll()).thenReturn(List.of(user));
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]").isArray())
                .andExpect(jsonPath("$[*].id").isNotEmpty())
                .andExpect(jsonPath("$[*].name").isNotEmpty())
                .andExpect(jsonPath("$[*].age").isNotEmpty());
    }

    @Test
    public void testGetById() throws Exception {
        User user = new User("123", "John", 21);
        when(userService.getById("123")).thenReturn(Optional.of(user));
        mockMvc.perform(get("/users/123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.name").isNotEmpty())
                .andExpect(jsonPath("$.age").isNumber());
    }

    @Test
    public void testGetByIdNotFound() throws Exception {
        when(userService.getById("456")).thenReturn(Optional.empty());
        mockMvc.perform(get("/users/456"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreate() throws Exception {
        String payload = "{\"name\": \"John\", \"age\": 30}";
        User user = new User("123", "John", 30);
        when(userService.create(user)).thenReturn(user);
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andExpect(status().isOk());

    }
}
