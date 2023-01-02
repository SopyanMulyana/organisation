package com.mitrais.organisation.service;

import com.mitrais.organisation.controller.request.UserRequest;
import com.mitrais.organisation.repository.UserRepository;
import com.mitrais.organisation.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<User> getById(String id) {
        return repository.findById(id);
    }

    public User create(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        return repository.save(user);
    }

    public User update(String id, UserRequest request) {
        User user = new User(id, request.getName(), request.getAge());
        return repository.save(user);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

