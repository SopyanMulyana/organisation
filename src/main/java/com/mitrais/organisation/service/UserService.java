package com.mitrais.organisation.service;

import com.mitrais.organisation.repository.UserRepository;
import com.mitrais.organisation.repository.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> getAll() {
        return repository.findAll();
    }

    public Optional<User> getById(String id) {
        return repository.findById(id);
    }

    public User create(User user) {
        return repository.insert(user);
    }

    public User update(User user) {
        return repository.save(user);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}

