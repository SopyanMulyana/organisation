package com.mitrais.organisation.controller;

import com.mitrais.organisation.controller.request.UserRequest;
import com.mitrais.organisation.repository.entity.User;
import com.mitrais.organisation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping()
    public User create(@RequestBody UserRequest user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @RequestBody UserRequest user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        service.deleteById(id);
    }
}

